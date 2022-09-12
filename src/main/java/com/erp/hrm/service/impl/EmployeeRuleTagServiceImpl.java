package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeRuleTagDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.EmployeeRuleTag;
import com.erp.hrm.domain.ShiftPlan;
import com.erp.hrm.domain.TemporaryRuleTagEmployeeCode;
import com.erp.hrm.repository.CityRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.employee.EmployeeOfficeInfoRepository;
import com.erp.hrm.repository.employee.EmployeeRuleTagRepository;
import com.erp.hrm.repository.employee.TemporaryRuleTagEmployeeCodeRepository;
import com.erp.hrm.repository.shift.ShiftPlanRepository;
import com.erp.hrm.service.EmployeeInfoService;
import com.erp.hrm.service.EmployeeRuleTagService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.ErpUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeRuleTagServiceImpl implements EmployeeRuleTagService {
    private EmployeeInfoRepository employeeInfoRepository;
    private EmployeeOfficeInfoRepository employeeOfficeInfoRepository;
    private EmployeeRuleTagRepository employeeRuleTagRepository;
    private CityRepository cityRepository;
    private ShiftPlanRepository shiftPlanRepository;
    private TemporaryRuleTagEmployeeCodeRepository tagEmployeeCodeRepository;
    public EmployeeRuleTagServiceImpl(EmployeeInfoRepository employeeInfoRepository,
                                      EmployeeOfficeInfoRepository employeeOfficeInfoRepository,
                                      EmployeeRuleTagRepository employeeRuleTagRepository,
                                      CityRepository cityRepository,
                                      ShiftPlanRepository shiftPlanRepository,
                                      TemporaryRuleTagEmployeeCodeRepository tagEmployeeCodeRepository){
        this.employeeInfoRepository = employeeInfoRepository;
        this.employeeOfficeInfoRepository = employeeOfficeInfoRepository;
        this.employeeRuleTagRepository = employeeRuleTagRepository;
        this.cityRepository = cityRepository;
        this.shiftPlanRepository = shiftPlanRepository;
        this.tagEmployeeCodeRepository = tagEmployeeCodeRepository;
    }

    @Override
    public ActionResult saveEmployeeRuleTag(EmployeeRuleTagDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            List<EmployeeRuleTag> employeeRuleTagObj = new ArrayList<>();
            //Preparing object for Update rule tag
            List<EmployeeRuleTag> employeeRuleTags = employeeRuleTagRepository.getAllEmployeesForUpdateRuleCode(dto.getRuleCode(),dto.getUserId());
            for (EmployeeRuleTag employeeRuleTag:employeeRuleTags) {
                if(dto.getRuleName().contains("Bonus Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("OT Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("Attendance Late Deduction Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("Final Settlement Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("Additional Salary Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());

                employeeRuleTag.setUpdatedBy(dto.getUserId());
                employeeRuleTag.setUpdatedDate(ErpUtils.todayDate());
                employeeRuleTagObj.add(employeeRuleTag);
            }

            //Preparing object for Insert rule tag
            List<Object[]> employeeCodesObj =employeeRuleTagRepository.getAllEmployeesForInsertRuleCode(dto.getRuleCode(),dto.getUserId());
            for (Object employeeCode:employeeCodesObj) {
                EmployeeRuleTag employeeRuleTag = new EmployeeRuleTag();

                EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(employeeCode.toString());
                employeeRuleTag.setEmployeeInfo(employeeInfo);

                if(dto.getRuleName().contains("Bonus Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("OT Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("Attendance Late Deduction Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("Final Settlement Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());
                else if(dto.getRuleName().contains("Additional Salary Rule"))
                    employeeRuleTag.setBonusPolicyCode(dto.getRuleCode());

                employeeRuleTag.setAddedBy(dto.getUserId());
                employeeRuleTag.setDateAdded(ErpUtils.todayDate());
                employeeRuleTagObj.add(employeeRuleTag);
            }

//            employeeRuleTagRepository.save(employeeRuleTagObj);
            employeeRuleTagRepository.saveAll(employeeRuleTagObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Employee Rule tagged successfully!");
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
    public ActionResult saveEmployeeCodeIntoTemp(EmployeeRuleTagDTO dto) {
        ActionResult actionResult = new ActionResult();
        List<TemporaryRuleTagEmployeeCode> tagEmployeeCodesObj = new ArrayList<>();
        try {
            if(dto.isUsingFilter() == true){
                List<Object[]> employeeCodeObj = employeeOfficeInfoRepository.getAllEmployeeCodesByFilters(
                        dto.getRuleName(),dto.getRuleCode(),dto.getUnitName(),dto.getDepartmentName(),
                        dto.getDesignationName(),dto.getStaffCategoryName());
                for (Object employeeCode:employeeCodeObj) {
                    TemporaryRuleTagEmployeeCode tagEmployeeCodeObj = new TemporaryRuleTagEmployeeCode();
                    tagEmployeeCodeObj.setEmployeeCode(employeeCode.toString());
                    tagEmployeeCodeObj.setRuleCode(dto.getRuleCode());
                    tagEmployeeCodeObj.setUserId(dto.getUserId());
                    tagEmployeeCodesObj.add(tagEmployeeCodeObj);
                }
            }
            else {
                String[] vEmployeeCodeObj = dto.getSelectedEmployeeCodes().split(",");
                for (String vEmployeeCode:vEmployeeCodeObj) {
                    TemporaryRuleTagEmployeeCode tagEmployeeCodeObj = new TemporaryRuleTagEmployeeCode();
                    tagEmployeeCodeObj.setEmployeeCode(vEmployeeCode);
                    tagEmployeeCodeObj.setRuleCode(dto.getRuleCode());
                    tagEmployeeCodeObj.setUserId(dto.getUserId());
                    tagEmployeeCodesObj.add(tagEmployeeCodeObj);
                }
            }

            int tempDataCount = tagEmployeeCodeRepository.getTempRuleTagEmployeeCodeCount(dto.getRuleCode(),dto.getUserId());
            if(tempDataCount > 0)
                tagEmployeeCodeRepository.delete(dto.getUserId(),dto.getRuleCode());
//            tagEmployeeCodeRepository.save(tagEmployeeCodesObj);
            tagEmployeeCodeRepository.saveAll(tagEmployeeCodesObj);
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
    public EmployeeInfoGridDTO getAllRuleTaggedEmployeeByRuleCode(String pRuleName,String pRuleCode,PageableDTO pageableDTO) {

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
            employeeInfo = employeeInfoRepository.getAllRuleTaggedEmployeeByRuleCode(pRuleName,pRuleCode,pageable);
        }
        else {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = employeeInfoRepository.getAllRuleTaggedEmployeeAdvanceSearchByFilters(pRuleName,pRuleCode,pAdvanceSearchFilter,pageable);
            }
            else {
                employeeInfo = employeeInfoRepository.getAllRuleTaggedEmployeeByRuleCodeByFilters(pRuleName,pRuleCode,
                        pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,
                        pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
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
    public EmployeeInfoGridDTO getAllRuleUnTaggedEmployeeByRuleCode(String pRuleName,String pRuleCode,PageableDTO pageableDTO) {

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
            employeeInfo = employeeInfoRepository.getAllRuleUnTaggedEmployeeByRuleCode(pRuleName,pRuleCode,pageable);
        }
        else {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = employeeInfoRepository.getAllRuleUnTaggedEmployeeAdvanceSearchByFilters(pRuleName,pRuleCode,pAdvanceSearchFilter,pageable);
            }
            else {
                employeeInfo = employeeInfoRepository.getAllRuleUnTaggedEmployeeByRuleCodeByFilters(pRuleName,pRuleCode,
                        pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,
                        pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
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
    public EmployeeInfoGridDTO getAllSelectedEmployeesForRuleTag(String pRuleCode,String pUserId,PageableDTO pageableDTO) {

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
            employeeInfo = tagEmployeeCodeRepository.getAllSelectedEmployeesForRuleTag(pRuleCode,pUserId,pageable);
        }
        else {
            if(pageableDTO.getFilters().contains("advanceSearchFiled")){
                employeeInfo = tagEmployeeCodeRepository.getAllSelectedEmployeesForRuleTagByAdvanceSearch(pRuleCode,pUserId,pAdvanceSearchFilter,pageable);
            }
            else {
                employeeInfo = tagEmployeeCodeRepository.getAllSelectedEmployeesForRuleTagByFilters(pRuleCode,pUserId,
                        pEmpCodeFilter,pEmpCodeOpt,pPunchCardFilter,pPunchCardOpt,pFirstNameFilter,pFirstNameOpt,
                        pUnitFilter,pUnitFilterOpt,pDepartmentFilter,pDepartmentOpt,
                        pDesignationFilter,pDesignationOpt,pStaffCategoryFilter,pStaffCategoryOpt,
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
}
