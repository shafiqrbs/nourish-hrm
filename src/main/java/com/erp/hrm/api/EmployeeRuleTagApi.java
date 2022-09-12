package com.erp.hrm.api;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeRuleTagDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.service.EmployeeRuleTagService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sohag on 15/04/2018.
 */
@RestController
@RequestMapping("/api/v1/employees/ruleTag")
public class EmployeeRuleTagApi {
    private EmployeeRuleTagService employeeRuleTagService;
    public EmployeeRuleTagApi(EmployeeRuleTagService employeeRuleTagService){
        this.employeeRuleTagService = employeeRuleTagService;
    }

    @RequestMapping(value = "/saveEmployeeRuleTag", method = RequestMethod.POST)
    public @ResponseBody
    ActionResult saveEmployeeRuleTag(@RequestBody EmployeeRuleTagDTO dto){
        return employeeRuleTagService.saveEmployeeRuleTag(dto);
    }

    @RequestMapping(value = "/saveEmployeeCodeIntoTemp", method = RequestMethod.POST)
    public @ResponseBody
    ActionResult saveEmployeeCodeIntoTemp(@RequestBody EmployeeRuleTagDTO dto){
        return employeeRuleTagService.saveEmployeeCodeIntoTemp(dto);
    }

    @RequestMapping(value = "/getAllRuleTaggedEmployee", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getAllRuleTaggedEmployeeByRuleCode(String pRuleName,String pRuleCode,PageableDTO pageableDTO){
        return employeeRuleTagService.getAllRuleTaggedEmployeeByRuleCode(pRuleName,pRuleCode,pageableDTO);
    }

    @RequestMapping(value = "/getAllRuleUnTagEmployee", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getAllRuleUnTaggedEmployeeByRuleCode(String pRuleName,String pRuleCode,PageableDTO pageableDTO){
        return employeeRuleTagService.getAllRuleUnTaggedEmployeeByRuleCode(pRuleName,pRuleCode,pageableDTO);
    }

    @RequestMapping(value = "/getAllSelectedEmployeesForRuleTag", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getAllSelectedEmployeesForRuleTag(String pRuleCode,String pUserId,PageableDTO pageableDTO){
        return employeeRuleTagService.getAllSelectedEmployeesForRuleTag(pRuleCode,pUserId,pageableDTO);
    }

}
