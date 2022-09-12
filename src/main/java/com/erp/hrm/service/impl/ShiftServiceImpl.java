package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.shift.*;
import com.erp.hrm.domain.*;
import com.erp.hrm.repository.CompanySettingsRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.employee.EmployeeOfficeInfoRepository;
import com.erp.hrm.repository.employee.EmployeeRuleInfoRepository;
import com.erp.hrm.repository.shift.*;
import com.erp.hrm.service.ShiftService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.BulkInsetUtil;
import com.erp.hrm.util.DateUtils;
import com.erp.hrm.util.ErpUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by WS on 18/04/2018.
 */
@Service
public class ShiftServiceImpl implements ShiftService {
    private ShiftRuleRepository shiftRuleRepository;
    private ShiftPlanRepository shiftPlanRepository;
    private ShiftRosterRepository shiftRosterRepository;
    private ShiftRuleDetailRepository shiftRuleDetailRepository;
    private CompanySettingsRepository companySettingsRepository;
    private WorkOffCalendarTempRepository workOffCalendarTempRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    private EmployeeRuleInfoRepository employeeRuleInfoRepository;
    private RosteringTempEmployeeCodeRepository rosteringTempEmployeeCodeRepository;
    private ManualShiftTempEmployeeCodeRepository manualShiftTempEmployeeCodeRepository;
    private EmployeeOfficeInfoRepository employeeOfficeInfoRepository;
    private EntityManagerFactory emf;

    public ShiftServiceImpl(
            ShiftRuleRepository shiftRuleRepository,
            ShiftPlanRepository shiftPlanRepository,
            ShiftRosterRepository shiftRosterRepository,
            ShiftRuleDetailRepository shiftRuleDetailRepository,
            CompanySettingsRepository companySettingsRepository,
            WorkOffCalendarTempRepository workOffCalendarTempRepository,
            EmployeeInfoRepository employeeInfoRepository,
            EmployeeRuleInfoRepository employeeRuleInfoRepository,
            RosteringTempEmployeeCodeRepository rosteringTempEmployeeCodeRepository,
            ManualShiftTempEmployeeCodeRepository manualShiftTempEmployeeCodeRepository,
            EmployeeOfficeInfoRepository employeeOfficeInfoRepository,
            EntityManagerFactory emf) {
        this.shiftRuleRepository = shiftRuleRepository;
        this.shiftPlanRepository = shiftPlanRepository;
        this.shiftRosterRepository = shiftRosterRepository;
        this.shiftRuleDetailRepository = shiftRuleDetailRepository;
        this.companySettingsRepository = companySettingsRepository;
        this.workOffCalendarTempRepository = workOffCalendarTempRepository;
        this.employeeInfoRepository = employeeInfoRepository;
        this.employeeRuleInfoRepository = employeeRuleInfoRepository;
        this.rosteringTempEmployeeCodeRepository = rosteringTempEmployeeCodeRepository;
        this.manualShiftTempEmployeeCodeRepository = manualShiftTempEmployeeCodeRepository;
        this.employeeOfficeInfoRepository = employeeOfficeInfoRepository;
        this.emf = emf;
    }

    @Override
    public ShiftPlanDTO getShiftPlan(String ShiftId) {
        ShiftPlanDTO dto = new ShiftPlanDTO();
        try{
            ShiftPlan info = shiftPlanRepository.findOneByShiftPlan(ShiftId);
            if(info == null){
                throw new RuntimeException("ShiftPlan is not Available for -> " + ShiftId);
            }
            dto.setShiftID(info.getShiftID());
            dto.setShiftType(info.getShiftType());
            dto.setAlais(info.getAlias());
            dto.setDescriptions(info.getDescriptions());
            dto.setDefault(info.isDefaultPlan());
            dto.setActive(info.isActive());
            dto.setRoundAfter(info.getRoundAfter());
            dto.setRoundFor(info.getRoundFor());
            dto.setMorningOTRoundAfter(info.getMorningOTRoundAfter());
            dto.setMorningOTRoundFor(info.getMorningOTRoundFor());
            dto.setIgnoreMorningOTInHoliday(info.isIgnoreMonringOTInHoliday());
            dto.setIgnoreMorningOTInWeekend(info.isIgnoreMonringOTInWeekend());
            dto.setInTime(info.getInTime());
            dto.setInTimeStartMargin(info.getInTimeStartMargin());
            dto.setAbsentEndMargin(info.getAbsentEndMargin());
            dto.setOutTime(info.getOutTime());
            dto.setOutTimeEndMargin(info.getOutTimeEndMargin());

            dto.setBreakInTime(info.getLunchInTime());
            dto.setBreakOutTime(info.getLunchOutTime());
            dto.setBreakInEndMargin(info.getLunchInEndMargin());
            dto.setBreakPeriod(info.getLunchPeriod());

            dto.setWorkingHour(info.getWorkingHour());
            dto.setLateMargin(info.getLateMargin());
            dto.setEarlyOutMargin(info.getEarlyOutMargin());
            dto.setSpecialLateMargin(info.getSpecialLateMargin());
            dto.setEarlyOutAbsentEndMargin(info.getEarlyOutMargin());
            dto.setProcessInSameDay(info.isProcessCheck());
        }
        catch (Exception e){
            e.printStackTrace();
            dto = null;
        }
        return dto;
    }

    @Override
    public List<ShiftDTO> getAllShift() {
        List<ShiftDTO> shiftDTOS = new ArrayList<>();
        List<Object[]> sftObj= shiftPlanRepository.getAllShiftPlan();
        for (Object sftPlan : sftObj) {
            ShiftDTO shiftDTO = new ShiftDTO();
            shiftDTO.setShiftID((String) sftPlan);
            shiftDTOS.add(shiftDTO);
        }
        return shiftDTOS;
    }

    @Override
    public List<ShiftTypeDTO> getAllShiftType() {
        List<ShiftTypeDTO> shiftTypeDTOS = new ArrayList<>();
        List<Object[]> shiftTypes= shiftPlanRepository.getAllShiftType();
        for (Object shiftType : shiftTypes) {
            ShiftTypeDTO shiftTypeDTO = new ShiftTypeDTO();
            shiftTypeDTO.setShiftType((String) shiftType);
            shiftTypeDTOS.add(shiftTypeDTO);
        }
        return shiftTypeDTOS;
    }

    @Override
    public List<ShiftPlan> getAllShiftPlan() {
        return shiftPlanRepository.findAll();
    }

    @Override
    public List<ShiftPlan> getAllShiftPlan(String pShiftNature) {
        try{
            List<ShiftPlan> shiftPlan = new ArrayList<>();

            if(pShiftNature.equals("Rostering")){
                shiftPlan = shiftPlanRepository.getAllRosteringShiftPlan();
            }
            else {
                shiftPlan = shiftPlanRepository.getAllFixedShiftPlan();
            }
            return shiftPlan;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public ActionResult saveShiftPlan(ShiftPlanDTO dto) {
        ActionResult result = new ActionResult();

        try{
            ShiftPlan plan = shiftPlanRepository.findOneByShiftPlan(dto.getShiftID());
            if(plan == null){
                plan = new ShiftPlan();
                plan.setShiftID(dto.getShiftID());
            }
            plan.setShiftType(dto.getShiftType());
            plan.setAlias(dto.getAlais());
            plan.setDescriptions(dto.getDescriptions());
            plan.setDefaultPlan(dto.isDefault());
            plan.setActive(dto.isActive());
            plan.setRoundAfter(dto.getRoundAfter());
            plan.setRoundFor(dto.getRoundFor());
            plan.setMorningOTRoundAfter(dto.getMorningOTRoundAfter());
            plan.setMorningOTRoundFor(dto.getMorningOTRoundFor());
            plan.setIgnoreMonringOTInHoliday(dto.isIgnoreMorningOTInHoliday());
            plan.setIgnoreMonringOTInWeekend(dto.isIgnoreMorningOTInWeekend());
            plan.setInTime(dto.getInTime());
            plan.setInTimeStartMargin(dto.getInTimeStartMargin());
            plan.setAbsentEndMargin(dto.getAbsentEndMargin());
            plan.setOutTime(dto.getOutTime());
            plan.setOutTimeEndMargin(dto.getOutTimeEndMargin());

            plan.setLunchInTime(dto.getBreakInTime());
            plan.setLunchOutTime(dto.getBreakOutTime());
            plan.setLunchInEndMargin(dto.getBreakInEndMargin());
            plan.setLunchPeriod(dto.getBreakPeriod());

            plan.setWorkingHour(dto.getWorkingHour());
            plan.setLateMargin(dto.getLateMargin());
            plan.setEarlyOutMargin(dto.getEarlyOutMargin());
            plan.setSpecialLateMargin(dto.getSpecialLateMargin());
            plan.setEarlyOutAbsentMargin(dto.getEarlyOutAbsentEndMargin());
            plan.setProcessCheck(dto.isProcessInSameDay());

            shiftPlanRepository.save(plan);

            result.setIsSuccess(true);
            result.setSuccessMessage("Shift Plan saved successfully!");
        }
        catch (Exception e){
            e.printStackTrace();
            result.setIsSuccess(false);
            result.setSuccessMessage(e.getMessage());
        }

        return result;
    }

    @Override
    public ShiftRule getShiftRuleByCode(String pShiftRuleCode) {
        return shiftRuleRepository.getShiftRuleByCode(pShiftRuleCode);
    }

    @Override
    public List<ShiftRuleCodeDTO> getAllShiftRuleCode() {
        List<ShiftRuleCodeDTO> shiftRuleCodeDTOS = new ArrayList<>();
        List<Object[]> sftRuleCodeObj= shiftRuleRepository.getAllShiftRuleCode();
        for (Object sftRuleCode : sftRuleCodeObj) {
            ShiftRuleCodeDTO shiftRuleCodeDTO = new ShiftRuleCodeDTO();
            shiftRuleCodeDTO.setShiftRuleCode((String) sftRuleCode);
            shiftRuleCodeDTOS.add(shiftRuleCodeDTO);
        }
        return shiftRuleCodeDTOS;
    }

    @Override
    public ShiftRule getShiftRuleById(long id) {
//        return shiftRuleRepository.findOne(id);
    	return shiftRuleRepository.getOne(id);
    }

    @Override
    public List<ShiftRule> getAllShiftRule() {
        return shiftRuleRepository.findAll();
    }

    @Override
    public ActionResult saveShiftRule(ShiftRule shiftRule) {
        ActionResult actionResult = new ActionResult();
        try{
            shiftRuleRepository.save(shiftRule);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Shift rule saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult updateShiftRule(ShiftRule shiftRule) {
        ActionResult actionResult = new ActionResult();
        try{
            shiftRuleRepository.save(shiftRule);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Shift rule updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public void deleteShiftRule(Long pId) {
//        shiftRuleRepository.delete(pId);
    	shiftRuleRepository.deleteById(pId);
    }

    @Override
    public ActionResult saveWorkOffCalendar(WorkOffCalendarDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            List<WorkOffCalendarTemp> insetList = new ArrayList<>();
            String [] dates = dto.getDayOffDates().split(",");
            String [] empCodes = dto.getEmployeeCodes().split(",");
            String [] shiftIds = dto.getShiftIds().split(",");
            List<String> shiftIdList = new ArrayList<>();
            for (String shiftId : shiftIds) {
                shiftIdList.add(shiftId);
            }
            String pShiftId = null;
            if(!dto.getEmployeeCodes().equals("All")){
                for (String empCode : empCodes) {
                    for (String date : dates) {
                        pShiftId = employeeInfoRepository.getEmployeeShiftId(empCode);
                        if(pShiftId !=null) {
                            WorkOffCalendarTemp offCalendar = getWorkOffCalendarTemp(pShiftId, empCode, date, dto.getShiftNature(), dto.getDayType(), dto.getRemarks(), dto.getUserId());
                            insetList.add(offCalendar);
                        }
                    }
                }
            }else{
                List<String> empFilteredCodes =  employeeInfoRepository.getEmployeeBy(shiftIdList,dto.getUnitName(),dto.getDepartmentName(), dto.getDesignationName(),dto.getStaffCategoryName());
                for (String empCode : empFilteredCodes) {
                    for (String date : dates) {
                        pShiftId = employeeInfoRepository.getEmployeeShiftId(empCode);
                        if(pShiftId !=null) {
                            WorkOffCalendarTemp offCalendar = getWorkOffCalendarTemp(pShiftId, empCode, date, dto.getShiftNature(), dto.getDayType(), dto.getRemarks(), dto.getUserId());
                            insetList.add(offCalendar);
                        }
                    }
                }

            }

            int tempDataCount = workOffCalendarTempRepository.getTempWorkOfCalEmployeeCodeCount(dto.getUserId());
            if(tempDataCount > 0)
                workOffCalendarTempRepository.deleteAllByUserId(dto.getUserId());

            bulkInsertDeviceRowDataTempWithEntityManager(insetList);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("WorkOffCalendar saved successfully");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    public void bulkInsertDeviceRowDataTempWithEntityManager(List<WorkOffCalendarTemp> tempList) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
    public List<WorkOffCalendar> bulkInsertDeviceRowDataWithEntityManager(List<WorkOffCalendar> tempList) {
        return BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
    private WorkOffCalendarTemp getWorkOffCalendarTemp(String pShiftId,String empCode,String workOffDate, String shiftType, String dayType,String remarks, String pUserId) throws ParseException {
        WorkOffCalendarTemp workOffCalendar = new WorkOffCalendarTemp();
        try{
            workOffCalendar.setEmployeeCode(empCode);
            workOffCalendar.setWorkOffDate(DateUtils.parse(workOffDate,workOffDate.contains("/") ? "dd/MM/yyyy" : "yyyy-MM-dd"));
            workOffCalendar.setShiftType(shiftType);
            workOffCalendar.setDayType(dayType);
            workOffCalendar.setRemarks(remarks);
            workOffCalendar.setUserId(pUserId);
            workOffCalendar.setShiftId(pShiftId);
        }catch (Exception e){
            throw e;
        }
        return workOffCalendar;
    }
    private WorkOffCalendar getWorkOffCalendar(WorkOffCalendarTemp temp) throws ParseException {
        WorkOffCalendar workOffCalendar = new WorkOffCalendar();
        try{
            workOffCalendar.setEmployeeCode(temp.getEmployeeCode());
            workOffCalendar.setWorkOffDate(temp.getWorkOffDate());
            workOffCalendar.setShiftType(temp.getShiftType());
            workOffCalendar.setDayType(temp.getDayType());
            workOffCalendar.setRemarks(temp.getRemarks());

            workOffCalendar.setSequence(0);
            workOffCalendar.setCompensatoryLeave(false);
            workOffCalendar.setShiftID(temp.getShiftId());
        }catch (Exception e){
            throw e;
        }
        return workOffCalendar;
    }


    @Override
    public ActionResult pushWorkOffCalendar(String pUserId) {
        ActionResult actionResult = new ActionResult();
        try{
            List<WorkOffCalendarTemp> temps = workOffCalendarTempRepository.findAllByUserId(pUserId);
            List<WorkOffCalendar> offCalendars = new ArrayList<>();
            for (WorkOffCalendarTemp temp: temps) {
                offCalendars.add(getWorkOffCalendar(temp));
            }
            bulkInsertDeviceRowDataWithEntityManager(offCalendars);
            workOffCalendarTempRepository.deleteAllByUserId(pUserId);
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Work Of Calender updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public EmployeeInfoGridDTO getWorkOffCalendarTempList(String pUserId,PageableDTO pageableDTO) {
        EmployeeInfoGridDTO employeeInfoGridDTO = new EmployeeInfoGridDTO();
        List<EmployeeInfoDTO> list = new ArrayList<>();
//        Pageable pageable = new PageRequest(
//            pageableDTO.getPage(),
//            pageableDTO.getSize(),
//            new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
//        );
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
        		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update
        Page<Object[]> employeeInfo = workOffCalendarTempRepository.getAllTemp(pUserId,pageable);

        for (Object[] empInfo : employeeInfo)
        {
            EmployeeInfoDTO employeeInfoDTO = new EmployeeInfoDTO();
            employeeInfoDTO.setEmployeeCode((String) empInfo[0]);
            employeeInfoDTO.setDisplayEmployeeCode((String) empInfo[1]);
            employeeInfoDTO.setSalutation((String) empInfo[2]);
            employeeInfoDTO.setFirstName((String) empInfo[3]);
            employeeInfoDTO.setMiddleName((String) empInfo[4]);
            employeeInfoDTO.setLastName((String) empInfo[5]);
            employeeInfoDTO.setPunchCardNo((String) empInfo[6]);
            employeeInfoDTO.setEmployeeStatus((String) empInfo[7]);
            employeeInfoDTO.setDepartment((String) empInfo[8]);
            employeeInfoDTO.setDesignation((String) empInfo[9]);
            employeeInfoDTO.setUnit((String) empInfo[10]);
            employeeInfoDTO.setDoj((Date) empInfo[11]);
            employeeInfoDTO.setDoc((Date) empInfo[12]);
            employeeInfoDTO.setStaffCategory((String) empInfo[13]);
            list.add(employeeInfoDTO);
        }

        employeeInfoGridDTO.setTotal((int) employeeInfo.getTotalElements());
        employeeInfoGridDTO.setData(list);
        return employeeInfoGridDTO;
    }

    @Override
    public List<ShiftPlanRosteringDTO> getAllShiftRosteringBySRC(String pShiftRuleCode) {
        List<ShiftPlanRosteringDTO> rosteringDTOS = new ArrayList<>();
        List<ShiftRuleDetail> ruleDetails = shiftRuleDetailRepository.getAllShiftRosteringBySRC(pShiftRuleCode);
        for (ShiftRuleDetail ruleDetail: ruleDetails)
        {
            ShiftPlanRosteringDTO rosteringDTO = new ShiftPlanRosteringDTO();
            rosteringDTO.setShiftID(ruleDetail.getShiftID());
            rosteringDTO.setShiftType(ruleDetail.getShiftType());
            rosteringDTO.setAlias(ruleDetail.getAlias());
            rosteringDTO.setDays(ruleDetail.getDays());
            rosteringDTO.setSequenceNo(ruleDetail.getSequenceNo());
            rosteringDTOS.add(rosteringDTO);
        }
        return rosteringDTOS;
    }

    @Override
    public ActionResult saveShiftRuleRostering(List<ShiftPlanRosteringDTO> shiftPlanRosteringDTOS) {
        ActionResult actionResult = new ActionResult();
        try{
            List<ShiftRuleDetail> shiftRuleDetails = (List<ShiftRuleDetail>) new ShiftRuleDetail();
            for (ShiftPlanRosteringDTO shiftPlanRosteringDTO:shiftPlanRosteringDTOS){
                ShiftRuleDetail shiftRuleDetail = new ShiftRuleDetail();
                shiftRuleDetail.setShiftRuleCode(shiftPlanRosteringDTO.getShiftRuleCode());
                shiftRuleDetail.setShiftID(shiftPlanRosteringDTO.getShiftID());
                shiftRuleDetail.setShiftType(shiftPlanRosteringDTO.getShiftType());
                shiftRuleDetail.setAlias(shiftPlanRosteringDTO.getAlias());
                shiftRuleDetail.setDays(shiftPlanRosteringDTO.getDays());
                shiftRuleDetail.setSequenceNo(shiftPlanRosteringDTO.getSequenceNo());
                shiftRuleDetails.add(shiftRuleDetail);
            }
//            shiftRuleDetailRepository.save(shiftRuleDetails);
            shiftRuleDetailRepository.saveAll(shiftRuleDetails);

            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Shift rule saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult saveShiftRuleWithRostering(ShiftRule shiftRule, List<ShiftPlanRosteringDTO> shiftPlanRosteringDTOS)
    {
        ActionResult actionResult = new ActionResult();
        try{
            //Save shift rule
            shiftRuleRepository.save(shiftRule);

            //Save shift rule details
            List<ShiftRuleDetail> shiftRuleDetails = (List<ShiftRuleDetail>) new ShiftRuleDetail();
            for (ShiftPlanRosteringDTO shiftPlanRosteringDTO:shiftPlanRosteringDTOS){
                ShiftRuleDetail shiftRuleDetail = new ShiftRuleDetail();
                shiftRuleDetail.setShiftRuleCode(shiftPlanRosteringDTO.getShiftRuleCode());
                shiftRuleDetail.setShiftID(shiftPlanRosteringDTO.getShiftID());
                shiftRuleDetail.setShiftType(shiftPlanRosteringDTO.getShiftType());
                shiftRuleDetail.setAlias(shiftPlanRosteringDTO.getAlias());
                shiftRuleDetail.setDays(shiftPlanRosteringDTO.getDays());
                shiftRuleDetail.setSequenceNo(shiftPlanRosteringDTO.getSequenceNo());
                shiftRuleDetails.add(shiftRuleDetail);
            }
//            shiftRuleDetailRepository.save(shiftRuleDetails);
            shiftRuleDetailRepository.saveAll(shiftRuleDetails);

            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Shift rule saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult saveRosteringEmployeeCodeIntoTemp(RosteringTempEmployeeCodeDTO dto) {
        ActionResult actionResult = new ActionResult();
        List<RosteringTempEmployeeCode> employeeCodesObj = new ArrayList<>();
        try {
            if(dto.isUsingFilter() == true){
                List<Object[]> employeeCodeObj = employeeOfficeInfoRepository.getAllEmployeeCodesByFilters(
                        dto.getRuleName(),dto.getRuleCode(),dto.getUnitName(),dto.getDepartmentName(),
                        dto.getDesignationName(),dto.getStaffCategoryName());
                for (Object employeeCode:employeeCodeObj) {
                    RosteringTempEmployeeCode EmployeeCodeObj = new RosteringTempEmployeeCode();
                    EmployeeCodeObj.setEmployeeCode(employeeCode.toString());
                    EmployeeCodeObj.setUserId(dto.getUserId());
                    employeeCodesObj.add(EmployeeCodeObj);
                }
            }
            else {
                String[] vEmployeeCodeObj = dto.getSelectedEmployeeCodes().split(",");
                for (String vEmployeeCode:vEmployeeCodeObj) {
                    RosteringTempEmployeeCode EmployeeCodeObj = new RosteringTempEmployeeCode();
                    EmployeeCodeObj.setEmployeeCode(vEmployeeCode);
                    EmployeeCodeObj.setUserId(dto.getUserId());
                    employeeCodesObj.add(EmployeeCodeObj);
                }
            }

            int tempDataCount = rosteringTempEmployeeCodeRepository.getRosteringTempEmployeeCodeCount(dto.getUserId());
            if(tempDataCount > 0)
                rosteringTempEmployeeCodeRepository.delete(dto.getUserId());
//            rosteringTempEmployeeCodeRepository.save(employeeCodesObj);
            rosteringTempEmployeeCodeRepository.saveAll(employeeCodesObj);
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
    public EmployeeInfoGridDTO getRosteringTempEployeeList(String pUserId,PageableDTO pageableDTO) {
        EmployeeInfoGridDTO employeeInfoGridDTO = new EmployeeInfoGridDTO();
        List<EmployeeInfoDTO> list = new ArrayList<>();
//        Pageable pageable = new PageRequest(
//                pageableDTO.getPage(),
//                pageableDTO.getSize(),
//                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
//        );
        
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
        		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update

        Page<Object[]> employeeInfo = rosteringTempEmployeeCodeRepository.getAllTemp(pUserId,pageable);

        for (Object[] empInfo : employeeInfo)
        {
            EmployeeInfoDTO employeeInfoDTO = new EmployeeInfoDTO();
            employeeInfoDTO.setEmployeeCode((String) empInfo[0]);
            employeeInfoDTO.setDisplayEmployeeCode((String) empInfo[1]);
            employeeInfoDTO.setSalutation((String) empInfo[2]);
            employeeInfoDTO.setFirstName((String) empInfo[3]);
            employeeInfoDTO.setMiddleName((String) empInfo[4]);
            employeeInfoDTO.setLastName((String) empInfo[5]);
            employeeInfoDTO.setPunchCardNo((String) empInfo[6]);
            employeeInfoDTO.setEmployeeStatus((String) empInfo[7]);
            employeeInfoDTO.setDepartment((String) empInfo[8]);
            employeeInfoDTO.setDesignation((String) empInfo[9]);
            employeeInfoDTO.setUnit((String) empInfo[10]);
            employeeInfoDTO.setDoj((Date) empInfo[11]);
            employeeInfoDTO.setDoc((Date) empInfo[12]);
            employeeInfoDTO.setStaffCategory((String) empInfo[13]);
            list.add(employeeInfoDTO);
        }

        employeeInfoGridDTO.setTotal((int) employeeInfo.getTotalElements());
        employeeInfoGridDTO.setData(list);
        return employeeInfoGridDTO;
    }

    @Override
    public ActionResult saveManualShiftRoster(ManualShiftAssignmentDTO dto) {
        ActionResult result = new ActionResult();

        try{
            List<ShiftRuleDetail> shiftRuleList = new ArrayList<>();
            List<ShiftRoster> list = new ArrayList<>();
            ShiftPlan plan = null;
            if(dto.isFixedShift())
                plan = shiftPlanRepository.findOneByShiftPlan(dto.getShiftID());
            else
                shiftRuleList = shiftRuleDetailRepository.getAllShiftRosteringBySRC(dto.getShiftRule());

            List<ManualShiftTempEmployeeCode> employeeCodesObj = manualShiftTempEmployeeCodeRepository.findAllByUserId(dto.getUserId());

            if(dto.getShiftTransferType().contains("Daily")){
                if(dto.isFixedShift()) {
                    for (ManualShiftTempEmployeeCode employeeCodeObj : employeeCodesObj) {
                        ShiftRoster roster = getShiftRoster(employeeCodeObj.getEmployeeCode(), plan.getShiftID(), plan.getShiftType(), dto.getCurrentDate());
                        list.add(roster);
                    }
                }else{
                    for (ManualShiftTempEmployeeCode employeeCodeObj : employeeCodesObj) {
                        ShiftRoster roster = getShiftRoster(employeeCodeObj.getEmployeeCode(), shiftRuleList.get(0).getShiftID(),  shiftRuleList.get(0).getShiftType(), dto.getCurrentDate());
                        list.add(roster);
                    }
                }
            }
            else {
                if(dto.isFixedShift()) {
                    List<Date> dates = getDatesBetween(dto.getCurrentDate(),dto.getToDate());
                    for (ManualShiftTempEmployeeCode employeeCodeObj : employeeCodesObj) {
                        for (int j = 0; j < dates.size(); j++) {
                            ShiftRoster roster = getShiftRoster(employeeCodeObj.getEmployeeCode(), plan.getShiftID(), plan.getShiftType(), dates.get(j));
                            list.add(roster);
                        }
                    }
                }
                else {
                    List<Date> dates = getDatesBetween(dto.getCurrentDate(),dto.getToDate());
                    int shiftIndex = 0;
                    ShiftRuleDetail ruleDetail = shiftRuleList.get(shiftIndex);
                    for(ManualShiftTempEmployeeCode employeeCodeObj : employeeCodesObj) {
                        for (int j = 0; j < dates.size(); j++) {
                            if (j % ruleDetail.getDays() == 0) {
                                shiftIndex = shiftIndex == 3 ? 0 : shiftIndex + 1;
                                ruleDetail = shiftRuleList.get(shiftIndex);
                            }
                            ShiftRoster roster = getShiftRoster(employeeCodeObj.getEmployeeCode(), ruleDetail.getShiftID(), ruleDetail.getShiftType(), dates.get(j));
                            list.add(roster);
                        }
                    }
                }
            }

//            shiftRosterRepository.save(list);
            shiftRosterRepository.saveAll(list);
            //bulkInsertShiftRosterWithEntityManager(list);

            if(dto.getShiftTransferType() == "Permanent"){
                List<EmployeeRuleInfo> ruleInfoList = new ArrayList<>();
                for (ManualShiftTempEmployeeCode employeeCodeObj : employeeCodesObj) {
                    EmployeeRuleInfo info = employeeRuleInfoRepository.get(employeeCodeObj.getEmployeeCode());
                    if(dto.isFixedShift())
                        info.setShiftID(dto.getShiftID());
                    else
                        info.setShiftRuleCode(dto.getShiftRule());
                    ruleInfoList.add(info);
                }
//                employeeRuleInfoRepository.save(ruleInfoList);
                employeeRuleInfoRepository.saveAll(ruleInfoList);
                //bulkInsertEmployeeRuleInfoWithEntityManager(ruleInfoList);
            }

            result.setIsSuccess(true);
            result.setSuccessMessage("ManualShiftRoster saved successfully!");
        }
        catch (Exception e){
            e.printStackTrace();

            result.setIsSuccess(false);
            result.setSuccessMessage(e.getMessage());
        }

        return result;
    }

    @Override
    public ActionResult saveManualShiftEmployeeCodeIntoTemp(ManualShiftTempEmployeeCodeDTO dto) {
        ActionResult actionResult = new ActionResult();
        List<ManualShiftTempEmployeeCode> employeeCodesObj = new ArrayList<>();
        try {
            if(dto.isUsingFilter() == true){
                List<Object[]> employeeCodeObj = employeeOfficeInfoRepository.getAllEmployeeCodesByFilters(
                        dto.getRuleName(),dto.getRuleCode(),dto.getUnitName(),dto.getDepartmentName(),
                        dto.getDesignationName(),dto.getStaffCategoryName());
                for (Object employeeCode:employeeCodeObj) {
                    ManualShiftTempEmployeeCode EmployeeCodeObj = new ManualShiftTempEmployeeCode();
                    EmployeeCodeObj.setEmployeeCode(employeeCode.toString());
                    EmployeeCodeObj.setUserId(dto.getUserId());
                    employeeCodesObj.add(EmployeeCodeObj);
                }
            }
            else {
                String[] vEmployeeCodeObj = dto.getSelectedEmployeeCodes().split(",");
                for (String vEmployeeCode:vEmployeeCodeObj) {
                    ManualShiftTempEmployeeCode EmployeeCodeObj = new ManualShiftTempEmployeeCode();
                    EmployeeCodeObj.setEmployeeCode(vEmployeeCode);
                    EmployeeCodeObj.setUserId(dto.getUserId());
                    employeeCodesObj.add(EmployeeCodeObj);
                }
            }

            int tempDataCount = manualShiftTempEmployeeCodeRepository.getManualShiftTempEmployeeCodeCount(dto.getUserId());
            if(tempDataCount > 0)
                manualShiftTempEmployeeCodeRepository.delete(dto.getUserId());
//            manualShiftTempEmployeeCodeRepository.save(employeeCodesObj);
            manualShiftTempEmployeeCodeRepository.saveAll(employeeCodesObj);
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

    private ShiftRoster getShiftRoster(String empCode, String ShiftID, String ShiftType, Date ShiftDate) {
        ShiftRoster roster = shiftRosterRepository.getRoster(empCode,ShiftDate);
        if(roster == null) roster = new ShiftRoster();
        roster.setEmployeeCode(empCode);
        roster.setShiftID(ShiftID);
        roster.setShiftType(ShiftType);
        roster.setShiftDate(ShiftDate);
        return roster;
    }

    private ShiftRoster getShiftRosterForProcess(String empCode, String ShiftID, String ShiftType, Date ShiftDate) {
        ShiftRoster roster = new ShiftRoster();
        roster.setEmployeeCode(empCode);
        roster.setShiftID(ShiftID);
        roster.setShiftType(ShiftType);
        roster.setShiftDate(ShiftDate);
        return roster;
    }

    private List<Date> getDatesBetween(Date startDate, Date endDate) {
        List<Date> datesInRange = new ArrayList<>();
        if(endDate.getTime() >= startDate.getTime()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);

            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endDate);

            while (calendar.before(endCalendar)) {
                Date result = calendar.getTime();
                datesInRange.add(result);
                calendar.add(Calendar.DATE, 1);
            }
            datesInRange.add(endDate);
        }
        return datesInRange;
    }

    @Override
    public ActionResult processShiftRostering(ShiftRosteringDTO dto) {
        ActionResult result = new ActionResult();
        try{
            dto.setFromDate(DateUtils.setDefaultTime(dto.getFromDate()));
            dto.setToDate(DateUtils.setDefaultTime(dto.getToDate()));
            List<Date> dates = getDatesBetween(dto.getFromDate(),dto.getToDate());

            List<RosteringTempEmployeeCode> rteObj = rosteringTempEmployeeCodeRepository.findAllByUserId(dto.getUserId());
            List<String> rosteringTempCodes = new ArrayList<>();
            for(RosteringTempEmployeeCode data:rteObj) {
                rosteringTempCodes.add(data.getEmployeeCode());
            }

            //Delete Previous Roster Data
            for (int i = 0 ; i < rosteringTempCodes.size() ; i += 2000){
                int start = i ;
                int end = (i + 2000) > rosteringTempCodes.size() ? rosteringTempCodes.size()  : i + 2000;
                shiftRosterRepository.delete(rosteringTempCodes.subList(start ,end ), dates);
            }

            for (String empCode : rosteringTempCodes) {
                List<Object[]> shiftTypeAndIdsForPlan = employeeInfoRepository.getShiftIdAndShiftTypeFromShiftPlan(empCode);
                if(shiftTypeAndIdsForPlan.size() > 0) {
                    saveShiftRosterFromPlan(shiftTypeAndIdsForPlan, dates);
                }else {
                    List<Object[]> shiftTypeAndIdsForRoster = employeeInfoRepository.getShiftIdAndShiftTypeFromShiftRule(empCode);
                    saveShiftRosterFromRule(shiftTypeAndIdsForRoster,dates);
                }
            }

            result.setIsSuccess(true);
            result.setSuccessMessage("Shift Processed successfully!");
        }
        catch (Exception e){
            e.printStackTrace();

            result.setIsSuccess(false);
            result.setSuccessMessage(e.getMessage());
        }

        return result;
    }

    /*
    @Override
    public ActionResult processShiftRostering(ShiftRosteringDTO dto) {
        ActionResult result = new ActionResult();
        try{
            dto.setFromDate(DateUtils.setDefaultTime(dto.getFromDate()));
            dto.setToDate(DateUtils.setDefaultTime(dto.getToDate()));

            List<Date> dates = getDatesBetween(dto.getFromDate(),dto.getToDate());
            if(dto.isAllEmployees()){
                List<String> empCodes = new ArrayList<String>();
                List<Object[]> shiftTypeAndIdsForPlan = employeeInfoRepository.getShiftIdAndShiftTypeFromShiftPlan("All");
                for (Object[] object : shiftTypeAndIdsForPlan)
                    empCodes.add(object[0].toString());

                List<Object[]> shiftTypeAndIdsForRoster = employeeInfoRepository.getShiftIdAndShiftTypeFromShiftRule("All");
                for (Object[] object : shiftTypeAndIdsForRoster)
                    empCodes.add(object[0].toString());

                //Delete Previous Roster Data
                for (int i = 0 ; i < empCodes.size() ; i += 2000 ) {
                    int start = i ;
                    int end = (i + 2000) > empCodes.size() ? empCodes.size() : i + 2000;
                    shiftRosterRepository.delete(empCodes.subList(start ,end ), dates);
                }

                // Save Fixed Shift Employees
                saveShiftRosterFromPlan(shiftTypeAndIdsForPlan, dates);
                // Save Roster Shift Employees
                saveShiftRosterFromRule(shiftTypeAndIdsForRoster,dates);
            }
            else {
                //Delete Previous Roster Data
                for (int i = 0 ; i < dto.getEmployeeCodes().size() ; i += 2000 ) {
                    int start = i ;
                    int end = (i + 2000) > dto.getEmployeeCodes().size() ? dto.getEmployeeCodes().size()  : i + 2000;
                    shiftRosterRepository.delete(dto.getEmployeeCodes().subList(start ,end ), dates);
                }

                for (String empCode : dto.getEmployeeCodes()) {
                    List<Object[]> shiftTypeAndIdsForPlan = employeeInfoRepository.getShiftIdAndShiftTypeFromShiftPlan(empCode);
                    if(shiftTypeAndIdsForPlan.size() > 0) {
                        saveShiftRosterFromPlan(shiftTypeAndIdsForPlan, dates);
                    }else {
                        List<Object[]> shiftTypeAndIdsForRoster = employeeInfoRepository.getShiftIdAndShiftTypeFromShiftRule(empCode);
                        saveShiftRosterFromRule(shiftTypeAndIdsForRoster,dates);
                    }
                }
            }

            result.setIsSuccess(true);
            result.setSuccessMessage("Shift Processed successfully!");
        }
        catch (Exception e){
            e.printStackTrace();

            result.setIsSuccess(false);
            result.setSuccessMessage(e.getMessage());
        }

        return result;
    }
    */

    private void saveShiftRosterFromPlan(List<Object[]> shiftTypeAndIdsForPlan, List<Date> dates) {
        String shiftId = "";
        String shiftType = "";
        String employeeCode ="";
        List<ShiftRoster> list = new ArrayList<>();
        for(Object[] object : shiftTypeAndIdsForPlan){
            employeeCode = object[0].toString();
            shiftId = object[1].toString();
            shiftType = object[2].toString();
            for (int j = 0 ; j < dates.size(); j++) {
                ShiftRoster roster = getShiftRosterForProcess(employeeCode, shiftId, shiftType, dates.get(j));
                list.add(roster);
            }
        }
        if(list.size()> 0) {
            bulkInsertShiftRosterWithEntityManager(list);
            list.clear();
        }
    }
    private void saveShiftRosterFromRule(List<Object[]> shiftTypeAndIdsForRoster, List<Date> dates) {
        String shiftId = "";
        String shiftType = "";
        String employeeCode ="";
        int days, shiftIndex ;
        List<ShiftRoster> list = new ArrayList<>();
        for (int i = 0; i < shiftTypeAndIdsForRoster.size(); i += 3) {

            shiftIndex = 0;
            employeeCode = shiftTypeAndIdsForRoster.get(i + shiftIndex)[0].toString();
            days = Integer.parseInt(shiftTypeAndIdsForRoster.get(i)[3].toString());

            for (int j = 0; j < dates.size(); j++) {
               if (j % days == 0) {
                    shiftIndex = shiftIndex == 3 ? 0 : shiftIndex + 1;
                    shiftId = shiftTypeAndIdsForRoster.get(i + shiftIndex)[1].toString();
                    shiftType = shiftTypeAndIdsForRoster.get(i + shiftIndex)[2].toString();
                    days = Integer.parseInt(shiftTypeAndIdsForRoster.get(i + shiftIndex)[3].toString());
                }

                ShiftRoster roster = getShiftRosterForProcess(employeeCode, shiftId, shiftType, dates.get(j));
                list.add(roster);


            }
        }
        if(list.size() > 0) {
            bulkInsertShiftRosterWithEntityManager(list);
            list.clear();
        }
    }


    public void bulkInsertShiftRosterWithEntityManager(List<ShiftRoster> tempList) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
    public void bulkInsertEmployeeRuleInfoWithEntityManager(List<EmployeeRuleInfo> tempList) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
}
