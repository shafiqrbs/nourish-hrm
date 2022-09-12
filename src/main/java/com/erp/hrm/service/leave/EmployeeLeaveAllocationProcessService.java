package com.erp.hrm.service.leave;

import com.erp.hrm.api.dto.leaveManagement.EmployeeLeaveAllocationDTO;
import com.erp.hrm.api.dto.leaveManagement.LeaveProcessDTO;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface EmployeeLeaveAllocationProcessService {
    List<EmployeeLeaveAllocationDTO> getAllLeaveAllocationByEmployeeCode(String pEmployeeCode);

    ActionResult leaveProcess(LeaveProcessDTO dto);
}
