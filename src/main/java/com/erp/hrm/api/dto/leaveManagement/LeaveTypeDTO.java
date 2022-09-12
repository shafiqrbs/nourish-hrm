package com.erp.hrm.api.dto.leaveManagement;

public class LeaveTypeDTO {
    private String leavePolicyID;
    private String leaveType;

    public LeaveTypeDTO() {
    }

    public LeaveTypeDTO(String leavePolicyID, String leaveType) {
        this.leavePolicyID = leavePolicyID;
        this.leaveType = leaveType;
    }

    public String getLeavePolicyID() {
        return leavePolicyID;
    }

    public void setLeavePolicyID(String leavePolicyID) {
        this.leavePolicyID = leavePolicyID;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}
