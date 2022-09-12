package com.erp.hrm.service;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeRuleTagDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.util.ActionResult;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface EmployeeRuleTagService {

    ActionResult saveEmployeeRuleTag(EmployeeRuleTagDTO dto);

    ActionResult saveEmployeeCodeIntoTemp(EmployeeRuleTagDTO dto);

    EmployeeInfoGridDTO getAllRuleTaggedEmployeeByRuleCode(String pRuleName,String pRuleCode,PageableDTO pageableDTO);

    EmployeeInfoGridDTO getAllRuleUnTaggedEmployeeByRuleCode(String pRuleName,String pRuleCode,PageableDTO pageableDTO);

    EmployeeInfoGridDTO getAllSelectedEmployeesForRuleTag(String pRuleCode,String pUserId,PageableDTO pageableDTO);
}
