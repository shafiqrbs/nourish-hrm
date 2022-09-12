package com.erp.hrm.api.dto.leaveManagement;

import java.util.Date;

public class LeaveRuleInfoDTO {
    private String leaveRuleID;
    private String description;

    public LeaveRuleInfoDTO() {
    }

    public LeaveRuleInfoDTO(String leaveRuleID, String description) {
        this.leaveRuleID = leaveRuleID;
        this.description = description;
    }

    public String getLeaveRuleID() {
        return leaveRuleID;
    }

    public void setLeaveRuleID(String leaveRuleID) {
        this.leaveRuleID = leaveRuleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
