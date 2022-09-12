package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 14/09/2018.
 */
@Entity
@Table( name = "EmpLeaveTransactionApplied" )
public class EmpLeaveTransactionApplied extends BaseIntEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmpLeaveTransactionApplied_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leavePolicyID", columnDefinition="VARCHAR(10)", foreignKey = @ForeignKey(name = "FK_EmpLeaveTransactionApplied_LeavePolicyInfo"))
    private LeavePolicyInfo leavePolicyInfo;

    @Size(max = 50)
    @NotNull
    @Column(name = "TransactionID")
    private String transactionID;

    @Column(name = "TransactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Column(name = "FromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name = "ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @Column(name = "LeaveDays", columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_LeaveDays DEFAULT 0")
    private double leaveDays;

    @Column(name = "LeaveDaysNextYr", columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_LeaveDaysNextYr DEFAULT 0")
    private double leaveDaysNextYr;

    @NotNull
    @Column(name = "ReqSync", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_ReqSync DEFAULT 0")
    private boolean reqSync;

    @Size(max = 150)
    @Column(name = "LeaveReason")
    private String leaveReason;

    @Size(max = 100)
    @Column(name = "LeaveAvailPlace")
    private String leaveAvailPlace;

    @Column(name = "IsForwarded", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsForwarded DEFAULT 0")
    private boolean isForwarded;

    @Column(name = "IsRecomended", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsRecomended DEFAULT 0")
    private boolean isRecomended;

    @Column(name = "IsApproved", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsApproved DEFAULT 0")
    private boolean isApproved;

    @Column(name = "IsRejected", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsRejected DEFAULT 0")
    private boolean isRejected;

    @Column(name = "IsPostApproved", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsPostApproved DEFAULT 0")
    private boolean isPostApproved;

    @Column(name = "IsPreApproved", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsPreApproved DEFAULT 0")
    private boolean isPreApproved;

    @Column(name = "IsProcessed", nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmpLeaveTransactionApplied_IsProcessed DEFAULT 0")
    private boolean isProcessed;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
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

    public LeavePolicyInfo getLeavePolicyInfo() {
        return leavePolicyInfo;
    }

    public void setLeavePolicyInfo(LeavePolicyInfo leavePolicyInfo) {
        this.leavePolicyInfo = leavePolicyInfo;
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

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
