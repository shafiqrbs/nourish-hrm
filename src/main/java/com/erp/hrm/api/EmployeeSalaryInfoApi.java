package com.erp.hrm.api;

import com.erp.hrm.api.dto.EmployeeGrossSalaryDTO;
import com.erp.hrm.api.dto.EmployeeSalaryDTO;
import com.erp.hrm.api.dto.EmployeeSalaryInfoDTO;
import com.erp.hrm.domain.EmployeeSalary;
import com.erp.hrm.domain.SalaryRule;
import com.erp.hrm.service.EmployeeSalaryInfoService;
import com.erp.hrm.service.SalaryRuleService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/employeeSalaryInfo")
public class EmployeeSalaryInfoApi {
    private EmployeeSalaryInfoService employeeSalaryInfoService;
    public EmployeeSalaryInfoApi(EmployeeSalaryInfoService employeeSalaryInfoService){
        this.employeeSalaryInfoService = employeeSalaryInfoService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<EmployeeSalaryDTO> getAllEmployeeSalaryInfo(String pEmployeeCode, String pSalaryRuleCode, int pCalculate, float pGrossSalary){
        return employeeSalaryInfoService.getAllEmployeeSalaryInfo(pEmployeeCode,pSalaryRuleCode,pCalculate,pGrossSalary);
    }

    @RequestMapping(value = "/getEmployeeGrossSalary", method = RequestMethod.GET)
    public EmployeeGrossSalaryDTO getEmployeeGrossSalary(String pSalaryRuleCode, String pEmployeeCode){
        return employeeSalaryInfoService.getEmployeeGrossSalary(pSalaryRuleCode,pEmployeeCode);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody EmployeeSalaryInfoDTO employeeSalaryInfoDTO){
        return employeeSalaryInfoService.save(employeeSalaryInfoDTO);
    }
}