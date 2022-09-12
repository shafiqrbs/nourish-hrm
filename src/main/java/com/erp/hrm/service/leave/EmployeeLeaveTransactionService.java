package com.erp.hrm.service.leave;

import com.erp.hrm.api.dto.leaveManagement.EmployeeLeaveTransactionDTO;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface EmployeeLeaveTransactionService {
    ActionResult saveEmployeeLeaveTransaction(EmployeeLeaveTransactionDTO employeeLeaveTransactionDTO);
    List<EmployeeLeaveTransactionDTO> getEmployeeLeaveTransactions(String pEmployeeCode);
}
