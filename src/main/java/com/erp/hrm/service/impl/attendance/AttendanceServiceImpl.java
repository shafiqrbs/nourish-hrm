package com.erp.hrm.service.impl.attendance;

import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.attendance.AttendanceHistoryGridDTO;
import com.erp.hrm.api.dto.attendance.DailyAttendanceDTO;
import com.erp.hrm.api.dto.attendance.ManualAttendanceDTO;
import com.erp.hrm.api.dto.attendance.ManualAttendanceEntryDTO;
import com.erp.hrm.domain.*;
import com.erp.hrm.repository.attendance.DailyAttendanceRepository;
import com.erp.hrm.repository.attendance.TempManualEntryEmployeeRepository;
import com.erp.hrm.repository.employee.EmployeeOfficeInfoRepository;
import com.erp.hrm.repository.shift.ShiftPlanRepository;
import com.erp.hrm.service.attendance.AttendanceService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.ErpUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private EmployeeOfficeInfoRepository employeeOfficeInfoRepository;
    private DailyAttendanceRepository dailyAttendanceRepository;
    private ShiftPlanRepository shiftPlanRepository;
    private TempManualEntryEmployeeRepository tempManualEntryEmployeeRepository;

    public AttendanceServiceImpl(EmployeeOfficeInfoRepository employeeOfficeInfoRepository,
                                 DailyAttendanceRepository dailyAttendanceRepository,
                                 ShiftPlanRepository shiftPlanRepository,
                                 TempManualEntryEmployeeRepository tempManualEntryEmployeeRepository) {
        this.employeeOfficeInfoRepository = employeeOfficeInfoRepository;
        this.dailyAttendanceRepository = dailyAttendanceRepository;
        this.shiftPlanRepository = shiftPlanRepository;
        this.tempManualEntryEmployeeRepository = tempManualEntryEmployeeRepository;
    }

    @Override
    public ActionResult saveEmployeeCodeIntoTemp(ManualAttendanceEntryDTO dto) {
        ActionResult actionResult = new ActionResult();
        List<TempManualEntryEmployeeCode> tagEmployeeCodesObj = new ArrayList<>();
        try{
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            List<Object[]> employeeInfoObj = null;
            if(dto.isUsingFilter() == true){
                employeeInfoObj = employeeOfficeInfoRepository.getAllActiveEmployeeForManualAttendanceByFilters(
                        dto.getUnitName(),dto.getDepartmentName(),dto.getDesignationName(),dto.getStaffCategoryName(),dateFormat.parse(dto.getEntryDate()));
            }
            else {
                String[] vEmployeeCodeObj = dto.getSelectedEmployeeCodes().split(",");
                List<String> vEmployeeCodeList = new ArrayList<>();
                for (String vEmployeeCode : vEmployeeCodeObj) {
                    vEmployeeCodeList.add(vEmployeeCode);
                }
                employeeInfoObj = employeeOfficeInfoRepository.getAllActiveEmployeeForManualAttByEmpCodes(vEmployeeCodeList);
            }

            for (Object[] data:employeeInfoObj) {
                TempManualEntryEmployeeCode tagEmployeeCodeObj = new TempManualEntryEmployeeCode();
                tagEmployeeCodeObj.setEmployeeCode(data[0].toString());
                tagEmployeeCodeObj.setEntryDate(dateFormat.parse(dto.getEntryDate()));
                tagEmployeeCodeObj.setEntryType(dto.getEntryType());

                String vStartDate="",vEndDate="";
                if(dto.getEntryType().contains("In")) {
                    tagEmployeeCodeObj.setTimeStartRange(data[1].toString());
                    tagEmployeeCodeObj.setTimeEndRange(data[2].toString());
                    vStartDate = dto.getEntryDate()+" "+data[1].toString();
                    vEndDate = dto.getEntryDate()+" "+data[2].toString();
                }
                else if(dto.getEntryType().contains("Out")) {
                    tagEmployeeCodeObj.setTimeStartRange(data[3].toString());
                    tagEmployeeCodeObj.setTimeEndRange(data[4].toString());
                    vStartDate = dto.getEntryDate()+" "+data[3].toString();
                    vEndDate = dto.getEntryDate()+" "+data[4].toString();
                }

                Date vEditedDateTime = new Date(ThreadLocalRandom.current()
                        .nextLong(dateTimeFormat.parse(vStartDate).getTime(),
                                (dateTimeFormat.parse(vEndDate)).getTime()));

                tagEmployeeCodeObj.setEditedEntryDateTime(vEditedDateTime);
                tagEmployeeCodeObj.setShiftID(data[5].toString());
                tagEmployeeCodeObj.setShiftType(data[6].toString());
                tagEmployeeCodeObj.setUserId(dto.getUserId());
                tagEmployeeCodesObj.add(tagEmployeeCodeObj);
            }

            int tempDataCount = tempManualEntryEmployeeRepository.getTempEmployeeCodeCount(dto.getUserId());
            if(tempDataCount > 0)
                tempManualEntryEmployeeRepository.delete(dto.getUserId());
//            tempManualEntryEmployeeRepository.save(tagEmployeeCodesObj);
            tempManualEntryEmployeeRepository.saveAll(tagEmployeeCodesObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Added employee code into temporary table!");
        }
        catch (Exception e){
            //Set custom message if error
            e.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult save(ManualAttendanceDTO attendanceDTO) {
        ActionResult actionResult = new ActionResult();
        try {

            boolean isLate = false;
            String punchDate = "";
            String marginDate = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            SimpleDateFormat dateFormatOnly = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
            String workingDate = attendanceDTO.getWorkDate();
            Date workDate = dateFormatOnly.parse(workingDate);

            if(dailyAttendanceRepository.getAttendanceCountByEmployeeCodeAndDate(attendanceDTO.getEmployeeCode(),workDate) == 0)
            {

                List<DailyAttendance> dailyAttendances = new ArrayList<>();
                ShiftPlan shiftPlan = shiftPlanRepository.findOneByShiftPlan(attendanceDTO.getShiftID());

                if(attendanceDTO.getIsCheckInTime()){
                    DailyAttendance checkInDTOObj = new DailyAttendance();

                    punchDate = workingDate + " "+attendanceDTO.getCheckInTime();
                    Date checkInDateTime = sdf.parse(punchDate);

                    marginDate = workingDate + " "+shiftPlan.getInTimeStartMargin();
                    Date checkInStartMargin = sdf.parse(marginDate);

                    if(checkInDateTime.after(checkInStartMargin))
                        isLate = true;
                    else
                        isLate = false;

                    checkInDTOObj.setEmployeeCode(attendanceDTO.getEmployeeCode());
                    checkInDTOObj.setShiftID(attendanceDTO.getShiftID());
                    checkInDTOObj.setShiftType(shiftPlan.getShiftType());
                    checkInDTOObj.setWorkDate(workDate);
                    checkInDTOObj.setpTime(checkInDateTime);
                    checkInDTOObj.setBcTime(checkInDateTime);
                    checkInDTOObj.setPunchType("In");
                    checkInDTOObj.setManual(true);
                    checkInDTOObj.setLate(isLate);
                    checkInDTOObj.setRemarks(attendanceDTO.getCheckInRemarks());

                    dailyAttendances.add(checkInDTOObj);
                }

                if(attendanceDTO.getIsLunchOutTime()){
                    DailyAttendance lunchOutDTOObj = new DailyAttendance();

                    punchDate = workingDate + " "+attendanceDTO.getLunchOutTime();
                    Date lunchOutTime = sdf.parse(punchDate);

                    lunchOutDTOObj.setEmployeeCode(attendanceDTO.getEmployeeCode());
                    lunchOutDTOObj.setShiftID(attendanceDTO.getShiftID());
                    lunchOutDTOObj.setShiftType(shiftPlan.getShiftType());
                    lunchOutDTOObj.setWorkDate(workDate);
                    lunchOutDTOObj.setpTime(lunchOutTime);
                    lunchOutDTOObj.setBcTime(lunchOutTime);
                    lunchOutDTOObj.setPunchType("LOut");
                    lunchOutDTOObj.setManual(true);
                    lunchOutDTOObj.setLate(false);
                    lunchOutDTOObj.setRemarks(attendanceDTO.getLunchOutRemarks());

                    dailyAttendances.add(lunchOutDTOObj);
                }

                if(attendanceDTO.getIsLunchInTime()){
                    DailyAttendance lunchFromInDTOObj = new DailyAttendance();

                    punchDate = workingDate + " "+attendanceDTO.getLunchInTime();
                    Date lunchInTime = sdf.parse(punchDate);

                    marginDate = workingDate + " "+shiftPlan.getLunchInEndMargin();
                    Date lunchInStartMargin = sdf.parse(marginDate);

                    if(lunchInTime.after(lunchInStartMargin))
                        isLate = true;
                    else
                        isLate = false;

                    lunchFromInDTOObj.setEmployeeCode(attendanceDTO.getEmployeeCode());
                    lunchFromInDTOObj.setShiftID(attendanceDTO.getShiftID());
                    lunchFromInDTOObj.setShiftType(shiftPlan.getShiftType());
                    lunchFromInDTOObj.setWorkDate(workDate);
                    lunchFromInDTOObj.setpTime(lunchInTime);
                    lunchFromInDTOObj.setBcTime(lunchInTime);
                    lunchFromInDTOObj.setPunchType("LIn");
                    lunchFromInDTOObj.setManual(true);
                    lunchFromInDTOObj.setLate(isLate);
                    lunchFromInDTOObj.setRemarks(attendanceDTO.getLunchInRemarks());

                    dailyAttendances.add(lunchFromInDTOObj);
                }

                if(attendanceDTO.getIsCheckOutTime()){
                    DailyAttendance checkOutDTOObj = new DailyAttendance();

                    punchDate = workingDate + " "+attendanceDTO.getCheckOutTime();
                    Date checkOutTime = sdf.parse(punchDate);

                    checkOutDTOObj.setEmployeeCode(attendanceDTO.getEmployeeCode());
                    checkOutDTOObj.setShiftID(attendanceDTO.getShiftID());
                    checkOutDTOObj.setShiftType(shiftPlan.getShiftType());
                    checkOutDTOObj.setWorkDate(workDate);
                    checkOutDTOObj.setpTime(checkOutTime);
                    checkOutDTOObj.setBcTime(checkOutTime);
                    checkOutDTOObj.setPunchType("Out");
                    checkOutDTOObj.setManual(true);
                    checkOutDTOObj.setLate(false);
                    checkOutDTOObj.setRemarks(attendanceDTO.getCheckOutRemarks());

                    dailyAttendances.add(checkOutDTOObj);
                }

//                dailyAttendanceRepository.save(dailyAttendances);
                dailyAttendanceRepository.saveAll(dailyAttendances);
                actionResult.setIsSuccess(true);
                actionResult.setSuccessMessage("Saved successfully!");
            }
            else {
                actionResult.setIsSuccess(false);
                actionResult.setErrorMessage("Already exists!");
            }
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }
/*
    @Override
    public AttendanceHistoryGridDTO getAllDailyAttendance(PageableDTO pageableDTO) {

        AttendanceHistoryGridDTO attendanceHistoryGridDTO = new AttendanceHistoryGridDTO();

        pageableDTO.setSize(pageableDTO.getSize() * 2); // for PunchIn And PunchOut data row will be 2 times

        Pageable pageable = new PageRequest(
                pageableDTO.getPage(),
                pageableDTO.getSize(),
                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
        );

        String pEmpCodeFilter = "All",pEmpCodeOpt = "contains",pFirstNameFilter = "All",pFirstNameOpt = "contains";
        String pPunchCardFilter = "All",pPunchCardOpt = "contains",pShiftIdFilter = "All",pShiftIdFilterOpt = "contains";
        String pShiftTypeFilter = "All",pShiftTypeOpt = "contains";

        if(pageableDTO.getFilters() !="") {
            String[] filtersObj = pageableDTO.getFilters().split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("employeeCode")){
                    pEmpCodeFilter = filter[1];
                    pEmpCodeOpt = filter[2];
                }

                if(filter[0].contains("firstName")){
                    pFirstNameFilter = filter[1];
                    pFirstNameOpt = filter[2];
                }

                if(filter[0].contains("punchCardNo")){
                    pPunchCardFilter = filter[1];
                    pPunchCardOpt = filter[2];
                }

                if(filter[0].contains("shiftID")){
                    pShiftIdFilter = filter[1];
                    pShiftIdFilterOpt = filter[2];
                }

                if(filter[0].contains("shiftType")){
                    pShiftTypeFilter = filter[1];
                    pShiftTypeOpt = filter[2];
                }
            }
        }

        List<DailyAttendanceDTO> dailyAttendanceDTOS = new ArrayList<>();
        Page<Object[]> dailyAttendances = null;
        if(pageableDTO.getFromDate() != null && pageableDTO.getToDate() != null) {
            dailyAttendances = dailyAttendanceRepository.getAllHistoryByFiltersWithDate(pageableDTO.getFromDate(), pageableDTO.getToDate(), pEmpCodeFilter, pEmpCodeOpt,
                    pFirstNameFilter, pFirstNameOpt, pPunchCardFilter, pPunchCardOpt, pShiftIdFilter, pShiftIdFilterOpt, pShiftTypeFilter, pShiftTypeOpt, pageable);
        }
        else{
            dailyAttendances = dailyAttendanceRepository.getAllHistoryByFiltersWithOutDate( pEmpCodeFilter, pEmpCodeOpt,pFirstNameFilter, pFirstNameOpt, pPunchCardFilter,
                    pPunchCardOpt, pShiftIdFilter, pShiftIdFilterOpt, pShiftTypeFilter, pShiftTypeOpt, pageable);
        }
        int indexCount = 0;
        DailyAttendanceDTO dailyAttendanceDTO = null;
        for (Object[] dailyAttendance : dailyAttendances) {
            if(indexCount % 2 == 0) {
                dailyAttendanceDTO = new DailyAttendanceDTO();
                dailyAttendanceDTO.setWorkDate((Date) dailyAttendance[0]);
                dailyAttendanceDTO.setEmployeeCode((String) dailyAttendance[1]);
                dailyAttendanceDTO.setSalutation((String) dailyAttendance[2]);
                dailyAttendanceDTO.setFirstName((String) dailyAttendance[3]);
                dailyAttendanceDTO.setMiddleName((String) dailyAttendance[4]);
                dailyAttendanceDTO.setLastName((String) dailyAttendance[5]);
                dailyAttendanceDTO.setPunchCardNo((String) dailyAttendance[6]);
                dailyAttendanceDTO.setShiftID((String) dailyAttendance[7]);
                dailyAttendanceDTO.setShiftType((String) dailyAttendance[8]);
                dailyAttendanceDTO.setPunchInTime((Date) dailyAttendance[9]);
                dailyAttendanceDTO.setPunchType((String) dailyAttendance[10]);

                try {
                    dailyAttendanceDTO.setManual((boolean) dailyAttendance[11]);
                }catch (Exception ex){
                    dailyAttendanceDTO.setManual(false);
                }

                try {
                    dailyAttendanceDTO.setLate((boolean) dailyAttendance[12]);
                }catch (Exception ex){
                    dailyAttendanceDTO.setLate(false);
                }

                dailyAttendanceDTO.setDateApproved((Date) dailyAttendance[13]);
                dailyAttendanceDTO.setApprovedBy((String) dailyAttendance[14]);
                dailyAttendanceDTO.setRemarks((String) dailyAttendance[15]);

            }
            else{
                if(dailyAttendanceDTO.getEmployeeCode().equalsIgnoreCase(dailyAttendance[1].toString())) {
                    dailyAttendanceDTO.setPunchOutTime((Date) dailyAttendance[9]);
                }
                dailyAttendanceDTOS.add(dailyAttendanceDTO);
                dailyAttendanceDTO = null;
            }


            indexCount ++;
        }

        attendanceHistoryGridDTO.setTotal((int) dailyAttendances.getTotalElements() / 2);
        attendanceHistoryGridDTO.setData(dailyAttendanceDTOS);

        return attendanceHistoryGridDTO;
    }
*/

    @Override
    public AttendanceHistoryGridDTO getAllDailyAttendance(PageableDTO pageableDTO) {

        AttendanceHistoryGridDTO attendanceHistoryGridDTO = new AttendanceHistoryGridDTO();
        int showRowCount = pageableDTO.getSize();
           pageableDTO.setSize(pageableDTO.getSize() * 2); // for PunchIn And PunchOut data row will be 2 times

        /*Pageable pageable = new PageRequest(
                pageableDTO.getPage(),
                pageableDTO.getSize(),
                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
        );*/
           
           Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
           		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update


        String pEmpCodeFilter = "All",pEmpCodeOpt = "contains",pFirstNameFilter = "All",pFirstNameOpt = "contains";
        String pPunchCardFilter = "All",pPunchCardOpt = "contains",pShiftIdFilter = "All",pShiftIdFilterOpt = "contains";
        String pShiftTypeFilter = "All",pShiftTypeOpt = "contains";

        if(pageableDTO.getFilters() !="") {
            String[] filtersObj = pageableDTO.getFilters().split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("employeeCode")){
                    pEmpCodeFilter = filter[1];
                    pEmpCodeOpt = filter[2];
                }

                if(filter[0].contains("firstName")){
                    pFirstNameFilter = filter[1];
                    pFirstNameOpt = filter[2];
                }

                if(filter[0].contains("punchCardNo")){
                    pPunchCardFilter = filter[1];
                    pPunchCardOpt = filter[2];
                }

                if(filter[0].contains("shiftID")){
                    pShiftIdFilter = filter[1];
                    pShiftIdFilterOpt = filter[2];
                }

                if(filter[0].contains("shiftType")){
                    pShiftTypeFilter = filter[1];
                    pShiftTypeOpt = filter[2];
                }
            }
        }

        List<DailyAttendanceDTO> dailyAttendanceDTOS = new ArrayList<>();
        Page<Object[]> dailyAttendances = null;
        if(pageableDTO.getFromDate() != null && pageableDTO.getToDate() != null) {
            Calendar fDate = Calendar.getInstance();
            Calendar tDate = Calendar.getInstance();

            fDate.setTime(pageableDTO.getFromDate());
            fDate.set(Calendar.SECOND,0);
            fDate.set(Calendar.MINUTE,0);
            fDate.set(Calendar.HOUR,0);

            tDate.setTime(pageableDTO.getToDate());
            fDate.set(Calendar.SECOND,0);
            fDate.set(Calendar.MINUTE,0);
            fDate.set(Calendar.HOUR,0);

            dailyAttendances = dailyAttendanceRepository.getAllHistoryByFiltersWithDate(fDate.getTime(), tDate.getTime(), pEmpCodeFilter, pEmpCodeOpt,
                    pFirstNameFilter, pFirstNameOpt, pPunchCardFilter, pPunchCardOpt, pShiftIdFilter, pShiftIdFilterOpt, pShiftTypeFilter, pShiftTypeOpt, pageable);
        }
        else{
            dailyAttendances = dailyAttendanceRepository.getAllHistoryByFiltersWithOutDate( pEmpCodeFilter, pEmpCodeOpt,pFirstNameFilter, pFirstNameOpt, pPunchCardFilter,
                    pPunchCardOpt, pShiftIdFilter, pShiftIdFilterOpt, pShiftTypeFilter, pShiftTypeOpt, pageable);
        }

        int index = 0, inCount = 0,outCount = 0;

        DailyAttendanceDTO  preDTO = null;
        String punchType;
        boolean insertFlag = false, lastRowEntryFlag = false, preRowAddedFlag = false;

        List<Object []> attendanceList = dailyAttendances.getContent();
        int listSize = attendanceList.size();
        for (Object[] dailyAttendance : attendanceList ) {

            index ++;
            if(inCount <= showRowCount && outCount <= showRowCount) {

                DailyAttendanceDTO dailyAttendanceDTO = new DailyAttendanceDTO();
                dailyAttendanceDTO.setWorkDate((Date) dailyAttendance[0]);
                dailyAttendanceDTO.setEmployeeCode((String) dailyAttendance[1]);
                dailyAttendanceDTO.setSalutation((String) dailyAttendance[2]);
                dailyAttendanceDTO.setFirstName((String) dailyAttendance[3]);
                dailyAttendanceDTO.setMiddleName((String) dailyAttendance[4]);
                dailyAttendanceDTO.setLastName((String) dailyAttendance[5]);
                dailyAttendanceDTO.setPunchCardNo((String) dailyAttendance[6]);
                dailyAttendanceDTO.setShiftID((String) dailyAttendance[7]);
                dailyAttendanceDTO.setShiftType((String) dailyAttendance[8]);

                punchType = dailyAttendance[10].toString();
                dailyAttendanceDTO.setPunchType((String) dailyAttendance[10]);

                dailyAttendanceDTO.setManual(ErpUtils.getBoolean(dailyAttendance[11]));
                dailyAttendanceDTO.setLate(ErpUtils.getBoolean(dailyAttendance[12]));
                dailyAttendanceDTO.setDateApproved((Date) dailyAttendance[13]);
                dailyAttendanceDTO.setApprovedBy((String) dailyAttendance[14]);
                dailyAttendanceDTO.setRemarks((String) dailyAttendance[15]);

                if (punchType.equalsIgnoreCase("in")) {
                    inCount++;
                    dailyAttendanceDTO.setPunchInTime((Date) dailyAttendance[9]);
                } else {
                    outCount++;
                    dailyAttendanceDTO.setPunchOutTime((Date) dailyAttendance[9]);
                }

                if(preDTO != null ) {
                    boolean isSameEmp = preDTO.getEmployeeCode().equalsIgnoreCase(dailyAttendanceDTO.getEmployeeCode());
                    if (preDTO.getWorkDate().compareTo(dailyAttendanceDTO.getWorkDate()) == 0 &&
                            isSameEmp) {
                        if (punchType.equalsIgnoreCase("in")) {
                            preDTO.setPunchInTime((Date) dailyAttendance[9]);
                        } else {
                            preDTO.setPunchOutTime((Date) dailyAttendance[9]);
                        }
                    }

                    index = (index == listSize ) ? 0 : index;

//                    Object[] checkObject = attendanceList.get(index);
//                    boolean isNextSameEmp = checkObject[1].toString().equalsIgnoreCase(dailyAttendanceDTO.getEmployeeCode());
                    boolean isPunchTypeChange = preDTO.getPunchType().equalsIgnoreCase(dailyAttendanceDTO.getPunchType());
                    if(index == 0 || preDTO.getWorkDate().compareTo(dailyAttendanceDTO.getWorkDate()) != 0 || !isSameEmp ||
                            (isSameEmp && !isPunchTypeChange)){
                        insertFlag = true;

                    }

                    if(insertFlag && !preRowAddedFlag){
                        dailyAttendanceDTOS.add(preDTO);
                        insertFlag = false;
                    }
                    if(preDTO.getWorkDate().compareTo(dailyAttendanceDTO.getWorkDate()) == 0 && isSameEmp && !isPunchTypeChange) {
                        preRowAddedFlag = true;
                    }else{
                        preRowAddedFlag = false;
                    }

                    isSameEmp = preDTO.getEmployeeCode().equalsIgnoreCase(dailyAttendanceDTO.getEmployeeCode());
                    if(index == 0 && (preDTO.getWorkDate().compareTo(dailyAttendanceDTO.getWorkDate()) != 0 || ! isSameEmp)){
                        lastRowEntryFlag = true;
                    }

                }

                preDTO = dailyAttendanceDTO;
                if(index == 0 && lastRowEntryFlag){
                    dailyAttendanceDTOS.add(preDTO);
                }


            }
        }


        attendanceHistoryGridDTO.setTotal((int) dailyAttendances.getTotalElements() );
        attendanceHistoryGridDTO.setData(dailyAttendanceDTOS);

        return attendanceHistoryGridDTO;
    }

    @Override
    public ActionResult saveManualBulkAttendances(ManualAttendanceEntryDTO dto) {
        ActionResult actionResult = new ActionResult();
        List<DailyAttendance> dailyAttendancesObj = new ArrayList<>();
        try{
            List<TempManualEntryEmployeeCode> manualEntryEmployeeObj = tempManualEntryEmployeeRepository.getAllSelectedManualBulkAttendances(dto.getUserId());
            for (TempManualEntryEmployeeCode data:manualEntryEmployeeObj) {
                DailyAttendance dailyAttendance = new DailyAttendance();
                dailyAttendance.setEmployeeCode(data.getEmployeeCode());
                dailyAttendance.setShiftID(data.getShiftID());
                dailyAttendance.setShiftType(data.getShiftType());
                dailyAttendance.setWorkDate(data.getEntryDate());
                dailyAttendance.setpTime(data.getEditedEntryDateTime());
                dailyAttendance.setBcTime(data.getEditedEntryDateTime());
                dailyAttendance.setPunchType(data.getEntryType());
                dailyAttendance.setManual(true);
                dailyAttendance.setLate(false);
                dailyAttendance.setRemarks(null);
                dailyAttendancesObj.add(dailyAttendance);
            }
//            dailyAttendanceRepository.save(dailyAttendancesObj);
            dailyAttendanceRepository.saveAll(dailyAttendancesObj);
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Saved successfully!");
        }
        catch (Exception ex){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(ex.getMessage());
        }
        return null;
    }
}
