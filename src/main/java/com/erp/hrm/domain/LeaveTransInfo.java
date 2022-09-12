package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by WS
 */
@Entity
@Table( name = "LeaveTransInfo")
public class LeaveTransInfo extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_LeaveTransInfo_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 10)
    @Column(name = "LeaveTypeID")
    private String leaveTypeID;

    @Size(max = 10)
    @Column(name = "LeaveRuleID")
    private String leaveRuleID;

    @NotNull
    @Column(name = "FromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @Column(name = "ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @Column(name = "Days")
    private int days;

    @Size(max = 500)
    @Column(name = "LeaveReason")
    private String leaveReason;

    @Size(max = 100)
    @Column(name = "LeaveAvailPlace")
    private String leaveAvailPlace;

    @Column(name = "IsForwarded", columnDefinition = "BIT CONSTRAINT DF_LeaveTrans_IsForwarded DEFAULT 0")
    private boolean isForwarded;

    @Column(name = "IsRecomended", columnDefinition = "BIT CONSTRAINT DF_LeaveTrans_IsRecomended DEFAULT 0")
    private boolean isRecomended;

    @Column(name = "IsApproved", columnDefinition = "BIT CONSTRAINT DF_LeaveTrans_IsApproved DEFAULT 0")
    private boolean isApproved;

    @Column(name = "IsRejected", columnDefinition = "BIT CONSTRAINT DF_LeaveTrans_IsRejected DEFAULT 0")
    private boolean isRejected;

    @NotNull
    @Column(name = "IsPostApproved", columnDefinition = "BIT CONSTRAINT DF_LeaveTrans_IsPostApproved DEFAULT 0")
    private boolean isPostApproved;

    @Size(max = 50)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Column(name = "DateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getLeaveTypeID() {
        return leaveTypeID;
    }

    public void setLeaveTypeID(String leaveTypeID) {
        this.leaveTypeID = leaveTypeID;
    }

    public String getLeaveRuleID() {
        return leaveRuleID;
    }

    public void setLeaveRuleID(String leaveRuleID) {
        this.leaveRuleID = leaveRuleID;
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

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }
}
