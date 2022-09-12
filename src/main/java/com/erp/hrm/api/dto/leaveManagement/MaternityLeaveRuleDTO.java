package com.erp.hrm.api.dto.leaveManagement;

public class MaternityLeaveRuleDTO {
    private String maternityLeaveRuleID;

    public MaternityLeaveRuleDTO() {
    }

    public MaternityLeaveRuleDTO(String maternityLeaveRuleID) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
    }

    public String getMaternityLeaveRuleID() {
        return maternityLeaveRuleID;
    }

    public void setMaternityLeaveRuleID(String maternityLeaveRuleID) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
    }

}
