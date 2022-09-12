package com.erp.hrm.service.leave;

import com.erp.hrm.api.dto.leaveManagement.MaternityLeaveTransInfoDTO;
import com.erp.hrm.api.dto.leaveManagement.MaternityLeaveTransSaveDTO;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface MaternityLeaveTransactionService {
    ActionResult saveMaternityLeaveTransInfo(MaternityLeaveTransSaveDTO dto);
    List<MaternityLeaveTransInfoDTO> getMaternityLeaveTransInfo(String EmployeeCode);
}
