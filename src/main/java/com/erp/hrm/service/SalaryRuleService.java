package com.erp.hrm.service;
import com.erp.hrm.api.dto.SalaryRuleCodeDTO;
import com.erp.hrm.api.dto.SalaryRuleDTO;
import com.erp.hrm.domain.SalaryRule;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface SalaryRuleService{
    ActionResult save(SalaryRule salaryRule);

    ActionResult update(SalaryRule salaryRule);

    List<SalaryRuleDTO> getAllSalaryRuleByRuleCode(String pSalaryRuleCode);

    List<SalaryRuleCodeDTO> getAllSalaryRuleCode();

    SalaryRuleDTO findOne(Long id);

    void delete(Long id);
}
