package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.Filters;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.domain.City;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.ShiftPlan;
import com.erp.hrm.repository.CityRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.shift.ShiftPlanRepository;
import com.erp.hrm.service.EmployeeInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
    private EmployeeInfoRepository employeeInfoRepository;
    private CityRepository cityRepository;
    private ShiftPlanRepository shiftPlanRepository;
    public EmployeeInfoServiceImpl(EmployeeInfoRepository employeeInfoRepository, CityRepository cityRepository,
                                   ShiftPlanRepository shiftPlanRepository){
        this.employeeInfoRepository = employeeInfoRepository;
        this.cityRepository = cityRepository;
        this.shiftPlanRepository = shiftPlanRepository;
    }

    @Override
    public EmployeeInfoDTO getEmployeeInfo(String pEmployeeCode) {
        EmployeeInfoDTO dto ;
        try {

            EmployeeInfo info = employeeInfoRepository.getEmployeeInfo(pEmployeeCode);
            dto = getEmployeDTO(info);
        }catch (Exception e){
            e.printStackTrace();
            dto = null;
        }

        return dto;
    }

    @Override
    public EmployeeInfoGridDTO getAllEmployeeInfo(String pCallRequestFrom,PageableDTO pageableDTO) {

        List<EmployeeInfoDTO> list = new ArrayList<>();

//        Pageable pageable = new PageRequest(
//                pageableDTO.getPage(),
//                pageableDTO.getSize(),
//                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
//        );
        
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
        		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update

        String pEmpCodeFilter = "All",pEmpCodeOpt = "contains",pPunchCardFilter = "All",pPunchCardOpt = "contains";
        String pFirstNameFilter = "All",pFirstNameOpt = "contains",pUnitFilter = "All",pUnitFilterOpt = "contains";
        String pDepartmentFilter = "All",pDepartmentOpt = "contains",pDesignationFilter = "All",pDesignationOpt = "contains";
        String pStaffCategoryFilter = "All",pStaffCategoryOpt = "contains",pAdvanceSearchFilter = "All",pAdvanceSearchOpt = "contains";

        if(pageableDTO.getFilters() !="") {
            String[] filtersObj = pageableDTO.getFilters().split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("employeeCode")){
                    pEmpCodeFilter = filter[1];
                    pEmpCodeOpt = filter[2];
                }

                if(filter[0].contains("punchCardNo")){
                    pPunchCardFilter = filter[1];
                    pPunchCardOpt = filter[2];
                }

                if(filter[0].contains("firstName")){
                    pFirstNameFilter = filter[1];
                    pFirstNameOpt = filter[2];
                }

                if(filter[0].contains("unit")){
                    pUnitFilter = filter[1];
                    pUnitFilterOpt = filter[2];
                }

                if(filter[0].contains("department")){
                    pDepartmentFilter = filter[1];
                    pDepartmentOpt = filter[2];
                }

                if(filter[0].contains("designation")){
                    pDesignationFilter = filter[1];
                    pDesignationOpt = filter[2];
                }

                if(filter[0].contains("staffCategory")){
                    pStaffCategoryFilter = filter[1];
                    pStaffCategoryOpt = filter[2];
                }

                if(filter[0].contains("advanceSearchFiled")){
                    pAdvanceSearchFilter = filter[1];
                    pAdvanceSearchOpt = filter[2];
                }
            }
        }

        EmployeeInfoGridDTO employeeInfoGridDTO = new EmployeeInfoGridDTO();

        Page<Object[]> employeeInfo = null;
        if(pageableDTO.getFilters() == ""){
            if(pCallRequestFrom.contains("MaternityLeave")) {
                employeeInfo = employeeInfoRepository.getAllActiveMLApplicableEmployeeInfo(pageable);
            }
            else{
                employeeInfo = employeeInfoRepository.getAllActiveEmployeeInfo(pageable);
            }
        }
        else if(pCallRequestFrom.contains("PersonalManagement")) {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = employeeInfoRepository.getAllEmployeeAdvanceSearchByFilters(pAdvanceSearchFilter,"all",pageable);
            }
            else {
                employeeInfo = employeeInfoRepository.getAllEmployeeByFilters(pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                        pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,"all",
                        pageable);
            }
        }
        else if(pCallRequestFrom.contains("MaternityLeave")) {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = employeeInfoRepository.getAllActiveMLEmployeeAdvanceSearchByFilters(pAdvanceSearchFilter,pageable);
            }
            else {
                employeeInfo = employeeInfoRepository.getAllActiveMLEmployeeByFilters(pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                        pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
                        pageable);
            }
        }
        else {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = employeeInfoRepository.getAllEmployeeAdvanceSearchByFilters(pAdvanceSearchFilter,"Active",pageable);
            }
            else {
                employeeInfo = employeeInfoRepository.getAllEmployeeByFilters(pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                        pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,"Active",
                        pageable);
            }
        }

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
    public EmployeeInfoGridDTO getAllActiveEmployees(PageableDTO pageableDTO) {

        List<EmployeeInfoDTO> list = new ArrayList<>();

        /*Pageable pageable = new PageRequest(
                pageableDTO.getPage(),
                pageableDTO.getSize(),
                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
        );*/
        
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
        		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update

        String pEmpCodeFilter = "All",pEmpCodeOpt = "contains",pPunchCardFilter = "All",pPunchCardOpt = "contains";
        String pFirstNameFilter = "All",pFirstNameOpt = "contains",pUnitFilter = "All",pUnitFilterOpt = "contains";
        String pDepartmentFilter = "All",pDepartmentOpt = "contains",pDesignationFilter = "All",pDesignationOpt = "contains";
        String pStaffCategoryFilter = "All",pStaffCategoryOpt = "contains",pAdvanceSearchFilter = "All",pAdvanceSearchOpt = "contains";

        if(pageableDTO.getFilters() !="") {
            String[] filtersObj = pageableDTO.getFilters().split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("employeeCode")){
                    pEmpCodeFilter = filter[1];
                    pEmpCodeOpt = filter[2];
                }

                if(filter[0].contains("punchCardNo")){
                    pPunchCardFilter = filter[1];
                    pPunchCardOpt = filter[2];
                }

                if(filter[0].contains("firstName")){
                    pFirstNameFilter = filter[1];
                    pFirstNameOpt = filter[2];
                }

                if(filter[0].contains("unit")){
                    pUnitFilter = filter[1];
                    pUnitFilterOpt = filter[2];
                }

                if(filter[0].contains("department")){
                    pDepartmentFilter = filter[1];
                    pDepartmentOpt = filter[2];
                }

                if(filter[0].contains("designation")){
                    pDesignationFilter = filter[1];
                    pDesignationOpt = filter[2];
                }

                if(filter[0].contains("staffCategory")){
                    pStaffCategoryFilter = filter[1];
                    pStaffCategoryOpt = filter[2];
                }

                if(filter[0].contains("advanceSearchFiled")){
                    pAdvanceSearchFilter = filter[1];
                    pAdvanceSearchOpt = filter[2];
                }
            }
        }

        EmployeeInfoGridDTO employeeInfoGridDTO = new EmployeeInfoGridDTO();

        Page<Object[]> employeeInfo = null;
        if(pageableDTO.getFilters() == ""){
            employeeInfo = employeeInfoRepository.getAllActiveEmployeeInfo(pageable);
        }
        else {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = employeeInfoRepository.getAllEmployeeAdvanceSearchByFilters(pAdvanceSearchFilter,"Active",pageable);
            }
            else {
                employeeInfo = employeeInfoRepository.getAllEmployeeByFilters(pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                        pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,"Active",
                        pageable);
            }
        }

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
    public EmployeeInfoGridDTO getAllSelectedManualAttendanceEmployees(PageableDTO pageableDTO) {

        List<EmployeeInfoDTO> list = new ArrayList<>();

        /*Pageable pageable = new PageRequest(
                pageableDTO.getPage(),
                pageableDTO.getSize(),
                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
        );*/
        
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
        		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update

        String pEmpCodeFilter = "All",pEmpCodeOpt = "contains",pPunchCardFilter = "All",pPunchCardOpt = "contains";
        String pFirstNameFilter = "All",pFirstNameOpt = "contains",pUnitFilter = "All",pUnitFilterOpt = "contains";
        String pDepartmentFilter = "All",pDepartmentOpt = "contains",pDesignationFilter = "All",pDesignationOpt = "contains";
        String pStaffCategoryFilter = "All",pStaffCategoryOpt = "contains",pAdvanceSearchFilter = "All",pAdvanceSearchOpt = "contains";

        if(pageableDTO.getFilters() !="") {
            String[] filtersObj = pageableDTO.getFilters().split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("employeeCode")){
                    pEmpCodeFilter = filter[1];
                    pEmpCodeOpt = filter[2];
                }

                if(filter[0].contains("punchCardNo")){
                    pPunchCardFilter = filter[1];
                    pPunchCardOpt = filter[2];
                }

                if(filter[0].contains("firstName")){
                    pFirstNameFilter = filter[1];
                    pFirstNameOpt = filter[2];
                }

                if(filter[0].contains("unit")){
                    pUnitFilter = filter[1];
                    pUnitFilterOpt = filter[2];
                }

                if(filter[0].contains("department")){
                    pDepartmentFilter = filter[1];
                    pDepartmentOpt = filter[2];
                }

                if(filter[0].contains("designation")){
                    pDesignationFilter = filter[1];
                    pDesignationOpt = filter[2];
                }

                if(filter[0].contains("staffCategory")){
                    pStaffCategoryFilter = filter[1];
                    pStaffCategoryOpt = filter[2];
                }

                if(filter[0].contains("advanceSearchFiled")){
                    pAdvanceSearchFilter = filter[1];
                    pAdvanceSearchOpt = filter[2];
                }
            }
        }

        EmployeeInfoGridDTO employeeInfoGridDTO = new EmployeeInfoGridDTO();

        Page<Object[]> employeeInfo = null;
        employeeInfo = employeeInfoRepository.getAllSelectedManualAttendanceEmployees(pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
                pageable);

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
            employeeInfoDTO.setEditedEntryDateTime((Date) empInfo[14]);

            list.add(employeeInfoDTO);
        }

        employeeInfoGridDTO.setTotal((int) employeeInfo.getTotalElements());
        employeeInfoGridDTO.setData(list);
        return employeeInfoGridDTO;
    }

    @Override
    public EmployeeInfoGridDTO getEmployeeInfoByShift(String pShiftNature, String pShiftId, PageableDTO pageableDTO) {
        EmployeeInfoGridDTO employeeInfoGridDTO = new EmployeeInfoGridDTO();
        List<EmployeeInfoDTO> list = new ArrayList<>();

        /*Pageable pageable = new PageRequest(
                pageableDTO.getPage(),
                pageableDTO.getSize(),
                new Sort(new Sort.Order(pageableDTO.getSortOn(),pageableDTO.getSortBy()))
        );*/
        
        Pageable pageable = PageRequest.of(pageableDTO.getPage(), pageableDTO.getSize(), 
        		Sort.by(pageableDTO.getSortOn(),pageableDTO.getSortBy())); ///this method need to update

        String [] shiftIds = pShiftId.split(",");
        List<String> shiftIdList = new ArrayList<>();
        for (String shiftId : shiftIds) {
            shiftIdList.add(shiftId);
        }

        String pEmpCodeFilter = "All",pEmpCodeOpt = "contains",pPunchCardFilter = "All",pPunchCardOpt = "contains";
        String pFirstNameFilter = "All",pFirstNameOpt = "contains",pUnitFilter = "All",pUnitFilterOpt = "contains";
        String pDepartmentFilter = "All",pDepartmentOpt = "contains",pDesignationFilter = "All",pDesignationOpt = "contains";
        String pStaffCategoryFilter = "All",pStaffCategoryOpt = "contains",pAdvanceSearchFilter = "All",pAdvanceSearchOpt = "contains";

        if(pageableDTO.getFilters() !="") {
            String[] filtersObj = pageableDTO.getFilters().split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("employeeCode")){
                    pEmpCodeFilter = filter[1];
                    pEmpCodeOpt = filter[2];
                }

                if(filter[0].contains("punchCardNo")){
                    pPunchCardFilter = filter[1];
                    pPunchCardOpt = filter[2];
                }

                if(filter[0].contains("firstName")){
                    pFirstNameFilter = filter[1];
                    pFirstNameOpt = filter[2];
                }

                if(filter[0].contains("unit")){
                    pUnitFilter = filter[1];
                    pUnitFilterOpt = filter[2];
                }

                if(filter[0].contains("department")){
                    pDepartmentFilter = filter[1];
                    pDepartmentOpt = filter[2];
                }

                if(filter[0].contains("designation")){
                    pDesignationFilter = filter[1];
                    pDesignationOpt = filter[2];
                }

                if(filter[0].contains("staffCategory")){
                    pStaffCategoryFilter = filter[1];
                    pStaffCategoryOpt = filter[2];
                }

                if(filter[0].contains("advanceSearchFiled")){
                    pAdvanceSearchFilter = filter[1];
                    pAdvanceSearchOpt = filter[2];
                }
            }
        }

        Page<Object[]> employeeInfo = null;
        if(pShiftNature.equals("Fixed")) {
            if(pShiftId.equals("All")) {
                if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                    employeeInfo = employeeInfoRepository.getAllEmployeeByShiftsAdvanceSearch(shiftIdList,"all",pAdvanceSearchFilter,pageable);
                }
                else{
                    employeeInfo = employeeInfoRepository.getAllEmployeeByShifts(shiftIdList,"all",pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                            pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                            pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
                            pageable);
                }
            }else{
                if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                    employeeInfo = employeeInfoRepository.getAllEmployeeByShiftsAdvanceSearch(shiftIdList,"",pAdvanceSearchFilter,pageable);
                }
                else {
                    employeeInfo = employeeInfoRepository.getAllEmployeeByShifts(shiftIdList,"",pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                            pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                            pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
                            pageable);
                }
            }
        }else {
            if(pShiftId.equals("All")) {
                if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                    employeeInfo = employeeInfoRepository.getAllEmployeeByShiftsAdvanceSearch(shiftIdList,"all",pAdvanceSearchFilter,pageable);
                }
                else{
                    employeeInfo = employeeInfoRepository.getAllEmployeeByShifts(shiftIdList,"all",pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                            pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                            pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
                            pageable);
                }
            }else{
                if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                    employeeInfo = employeeInfoRepository.getAlldShiftRosterEmployeeByFiltersAdvanceSearch(shiftIdList,"",pAdvanceSearchFilter,pageable);
                }
                else {
                    employeeInfo = employeeInfoRepository.getAllShiftRosterEmployeeByFilters(shiftIdList,"",pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,
                            pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                            pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
                            pageable);
                }
            }
        }


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

    private List<EmployeeInfoDTO> getEmployeeInfoDTOList(Page<Object[]> employeeInfo){
        List<EmployeeInfoDTO> list = new ArrayList<>();

        for (Object[] empInfo : employeeInfo)
        {
            EmployeeInfoDTO employeeInfoDTO = new EmployeeInfoDTO();

            employeeInfoDTO.setEmployeeCode((String) empInfo[0]);
            employeeInfoDTO.setPunchCardNo((String) empInfo[1]);
            employeeInfoDTO.setSalutation((String) empInfo[2]);

            employeeInfoDTO.setFirstName((String) empInfo[3]);
            employeeInfoDTO.setMiddleName((String) empInfo[4]);
            employeeInfoDTO.setLastName((String) empInfo[5]);

            employeeInfoDTO.setDepartment((String) empInfo[6]);
            employeeInfoDTO.setDesignation((String) empInfo[7]);
            list.add(employeeInfoDTO);
        }
        return  list;
    }

    private EmployeeInfoDTO getEmployeDTO(EmployeeInfo info){
        EmployeeInfoDTO dto = new EmployeeInfoDTO();
        try {
            if(info != null) {
                dto.setEmployeeCode(info.getEmployeeCode());
                dto.setEmployeeType(info.getEmployeeType());
                dto.setEmployeeStatus(info.getEmployeeStatus());
                dto.setPunchCardNo(info.getPunchCardNo());
                dto.setSalutation(info.getSalutation());
                dto.setFirstName(info.getFirstName());
                dto.setMiddleName(info.getMiddleName());
                dto.setLastName(info.getLastName());
                dto.setNickName(info.getNickName());
                dto.setGender(info.getGender());
                dto.setNid(info.getNid());
                dto.setNationality(info.getNationality());
                dto.setDateOfBirth(info.getDob());
                dto.setEmployeeImage(info.getEmpImage());

                if (info.getEmployeeOfficeInfo() != null) {
                    dto.setUnit(info.getEmployeeOfficeInfo().getUnit());
                    dto.setDateOfJoin(info.getEmployeeOfficeInfo().getDoj());
                    dto.setDateOfConfirmation(info.getEmployeeOfficeInfo().getDoc());
                    dto.setDepartment(info.getEmployeeOfficeInfo().getDepartment());
                    dto.setDesignation(info.getEmployeeOfficeInfo().getDesignation());
                    dto.setStaffCategory(info.getEmployeeOfficeInfo().getStaffCategory());
                }

                if (info.getEmployeeRuleInfo() != null) {
                    dto.setShiftID(info.getEmployeeRuleInfo().getShiftID());
                    dto.setShiftRuleCode(info.getEmployeeRuleInfo().getShiftRuleCode());

                    if(info.getEmployeeRuleInfo().getShiftID() != null) {
                        ShiftPlan shiftPlan = shiftPlanRepository.findOneByShiftPlan(info.getEmployeeRuleInfo().getShiftID());
                        dto.setCheckInTime(shiftPlan.getInTime());
                        dto.setCheckOutTime(shiftPlan.getOutTime());
                        dto.setTiffinInTime(shiftPlan.getLunchInTime());
                        dto.setTiffinOutTime(shiftPlan.getLunchOutTime());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            dto = null;
        }

        return dto;
    }


    private List<EmployeeInfoDTO> getEmployeDTOList(List<EmployeeInfo> infos){

        List<EmployeeInfoDTO> list = new ArrayList<>();
        for (int i =0; i< infos.size(); i++){
            list.add(getEmployeDTO(infos.get(i)));
        }
        return list;
    }
}
