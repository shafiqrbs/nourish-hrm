package com.erp.hrm.service.leave;

import com.erp.hrm.api.dto.leaveManagement.*;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface LeavePolicyService {

    ActionResult saveLeaveRuleInfo(LeaveRuleInfoDTO dto);
    List<LeaveRuleInfoDTO> getLeaveRuleInfos();
    List<LeaveRuleDTO> getAllLeaveRuleName();

    ActionResult saveLeavePolicyInfo(LeavePolicyInfoDTO dto);
    ActionResult updateLeavePolicyInfo(LeavePolicyInfoDTO dto);
    List<LeavePolicyInfoDTO> getLeavePolicyInfos();
    LeavePolicyInfoDTO getLeavePolicy(String LeavePolicyID);
    List<LeaveTypeDTO> getAllLeaveType();
    List<LeaveCategoryDTO> getAllLeaveCategory();
    List<LeaveCreditDTO> getAllLeaveCredit();

    ActionResult saveMaternityLeavePolicyInfo(MaternityLeavePolicyDTO dto);
    ActionResult updateMaternityLeavePolicyInfo(MaternityLeavePolicyDTO dto);
    List<MaternityLeavePolicyDTO> getMaternityLeavePolicyInfos();
    MaternityLeavePolicyDTO getMaternityLeavePolicy(String pMaternityLeavePolicyID);
    List<MaternityLeaveRuleDTO> getAllMaternityLeaveRule();
}
