package com.erp.hrm.api.dto.leaveManagement;

public class LeaveRuleDTO {
    private String leaveRuleName;

    public LeaveRuleDTO() {
    }

    public LeaveRuleDTO(String leaveRuleName) {
        this.leaveRuleName = leaveRuleName;
    }

    public String getLeaveRuleName() {
        return leaveRuleName;
    }

    public void setLeaveRuleName(String leaveRuleName) {
        this.leaveRuleName = leaveRuleName;
    }

}
