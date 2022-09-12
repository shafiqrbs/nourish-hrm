package com.erp.hrm.service.leave;

import com.erp.hrm.domain.LeaveYear;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface LeaveYearService {
    ActionResult saveLeaveYear(LeaveYear dto);
    List<LeaveYear> getLeaveYears();
    LeaveYear getActiveLeaveYear();
}
