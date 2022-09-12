package com.erp.hrm.api.dto.leaveManagement;

import java.math.BigDecimal;
import java.util.Date;

public class LeaveTransInfoDTO {
    private String employeeCode;
    private String leaveType;
    private Date fromDate;
    private Date toDate;
    private int totalDays;
    private String leaveReason;
    private String addressWhenOnLeave;
    private boolean isPreApproved;
    private boolean isPostApproved;

    public LeaveTransInfoDTO() {
    }

    public LeaveTransInfoDTO(String employeeCode,String leaveType, Date fromDate, Date toDate, int totalDays, String leaveReason, String addressWhenOnLeave, boolean isPreApproved, boolean isPostApproved) {
        this.employeeCode = employeeCode;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalDays = totalDays;
        this.leaveReason = leaveReason;
        this.addressWhenOnLeave = addressWhenOnLeave;
        this.isPreApproved = isPreApproved;
        this.isPostApproved = isPostApproved;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getAddressWhenOnLeave() {
        return addressWhenOnLeave;
    }

    public void setAddressWhenOnLeave(String addressWhenOnLeave) {
        this.addressWhenOnLeave = addressWhenOnLeave;
    }

    public boolean isPreApproved() {
        return isPreApproved;
    }

    public void setPreApproved(boolean preApproved) {
        isPreApproved = preApproved;
    }

    public boolean isPostApproved() {
        return isPostApproved;
    }

    public void setPostApproved(boolean postApproved) {
        isPostApproved = postApproved;
    }
}
