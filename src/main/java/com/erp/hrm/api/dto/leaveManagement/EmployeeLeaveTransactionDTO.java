package com.erp.hrm.api.dto.leaveManagement;

import java.util.Date;

/**
 * Created by Navid on 14/09/2018.
 */
public class EmployeeLeaveTransactionDTO {
    private String employeeCode;
    private String transactionID;
    private Date transactionDate;
    private String leavePolicyID;
    private String leaveType;
    private Date fromDate;
    private Date toDate;
    private double leaveDays;
    private double leaveDaysNextYr;
    private boolean reqSync;
    private String leaveReason;
    private String leaveAvailPlace;
    private boolean isForwarded;
    private boolean isRecomended;
    private boolean isApproved;
    private boolean isRejected;
    private boolean isPostApproved;
    private boolean isPreApproved;

    public EmployeeLeaveTransactionDTO() {
    }

    public EmployeeLeaveTransactionDTO(String employeeCode, String transactionID, Date transactionDate, String leavePolicyID, String leaveType, Date fromDate, Date toDate, double leaveDays, double leaveDaysNextYr, boolean reqSync, String leaveReason, String leaveAvailPlace, boolean isForwarded, boolean isRecomended, boolean isApproved, boolean isRejected, boolean isPostApproved, boolean isPreApproved) {
        this.employeeCode = employeeCode;
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.leavePolicyID = leavePolicyID;
        this.leaveType = leaveType;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveDays = leaveDays;
        this.leaveDaysNextYr = leaveDaysNextYr;
        this.reqSync = reqSync;
        this.leaveReason = leaveReason;
        this.leaveAvailPlace = leaveAvailPlace;
        this.isForwarded = isForwarded;
        this.isRecomended = isRecomended;
        this.isApproved = isApproved;
        this.isRejected = isRejected;
        this.isPostApproved = isPostApproved;
        this.isPreApproved = isPreApproved;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
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

    public double getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(double leaveDays) {
        this.leaveDays = leaveDays;
    }

    public double getLeaveDaysNextYr() {
        return leaveDaysNextYr;
    }

    public void setLeaveDaysNextYr(double leaveDaysNextYr) {
        this.leaveDaysNextYr = leaveDaysNextYr;
    }

    public boolean isReqSync() {
        return reqSync;
    }

    public void setReqSync(boolean reqSync) {
        this.reqSync = reqSync;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveAvailPlace() {
        return leaveAvailPlace;
    }

    public void setLeaveAvailPlace(String leaveAvailPlace) {
        this.leaveAvailPlace = leaveAvailPlace;
    }

    public boolean isForwarded() {
        return isForwarded;
    }

    public void setForwarded(boolean forwarded) {
        isForwarded = forwarded;
    }

    public boolean isRecomended() {
        return isRecomended;
    }

    public void setRecomended(boolean recomended) {
        isRecomended = recomended;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isRejected() {
        return isRejected;
    }

    public void setRejected(boolean rejected) {
        isRejected = rejected;
    }

    public boolean isPostApproved() {
        return isPostApproved;
    }

    public void setPostApproved(boolean postApproved) {
        isPostApproved = postApproved;
    }

    public boolean isPreApproved() {
        return isPreApproved;
    }

    public void setPreApproved(boolean preApproved) {
        isPreApproved = preApproved;
    }
}
