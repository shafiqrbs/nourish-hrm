package com.erp.hrm.service;
import com.erp.hrm.api.dto.EmployeeGrossSalaryDTO;
import com.erp.hrm.api.dto.EmployeeSalaryDTO;
import com.erp.hrm.api.dto.EmployeeSalaryInfoDTO;
import com.erp.hrm.domain.EmployeeSalary;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface EmployeeSalaryInfoService {
    List<EmployeeSalaryDTO> getAllEmployeeSalaryInfo(String pEmployeeCode, String pSalaryRuleCode, int pCalculate, float pGrossSalary);

    EmployeeGrossSalaryDTO getEmployeeGrossSalary(String pSalaryRuleCode,String pEmployeeCode);

    ActionResult save(EmployeeSalaryInfoDTO dto);

}
