package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 14/09/2018.
 */
@Entity
@Table( name = "EmployeeLeaveMaster", uniqueConstraints = { @UniqueConstraint( columnNames = { "EmployeeCode","LeavePolicyID" } ) } )
public class EmployeeLeaveMaster extends BaseIntEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeLeaveMaster_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leavePolicyID", columnDefinition="VARCHAR(10)", foreignKey = @ForeignKey(name = "FK_EmployeeLeaveMaster_LeavePolicyInfo"))
    private LeavePolicyInfo leavePolicyInfo;

    @Column(name = "AvailFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date availFrom;

    @Column(name = "AvailTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date availTo;

    @NotNull
    @Column(name = "AllocatedDays")
    private float allocatedDays;

    @NotNull
    @Column(name = "OpeningBalance")
    private float openingBalance;

    @Column(name = "PreviousYrAllocation")
    private float previousYrAllocation;

    @NotNull
    @Column(name = "LeaveAppliedCurrYr")
    private float leaveAppliedCurrYr;

    @NotNull
    @Column(name = "LeaveAvailedCurrYr")
    private float leaveAvailedCurrYr;

    @NotNull
    @Column(name = "LeaveAppliedNextYr")
    private float leaveAppliedNextYr;

    @NotNull
    @Column(name = "LeaveAvailedNextYr")
    private float leaveAvailedNextYr;

    @Column(name = "EntitlementDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entitlementDate;

    @Column(name = "AdjustedHLeave")
    private float adjustedHLeave;

    @Column(name = "LeaveAvailHour")
    private float leaveAvailHour;

    @Column(name = "UploadOpeningBalance")
    private float uploadOpeningBalance;

    @Column(name = "EncashDays")
    private float encashDays;

    @Column(name = "ReEntitlementDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reEntitlementDate;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public LeavePolicyInfo getLeavePolicyInfo() {
        return leavePolicyInfo;
    }

    public void setLeavePolicyInfo(LeavePolicyInfo leavePolicyInfo) {
        this.leavePolicyInfo = leavePolicyInfo;
    }

    public Date getAvailFrom() {
        return availFrom;
    }

    public void setAvailFrom(Date availFrom) {
        this.availFrom = availFrom;
    }

    public Date getAvailTo() {
        return availTo;
    }

    public void setAvailTo(Date availTo) {
        this.availTo = availTo;
    }

    public float getAllocatedDays() {
        return allocatedDays;
    }

    public void setAllocatedDays(float allocatedDays) {
        this.allocatedDays = allocatedDays;
    }

    public float getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(float openingBalance) {
        this.openingBalance = openingBalance;
    }

    public float getPreviousYrAllocation() {
        return previousYrAllocation;
    }

    public void setPreviousYrAllocation(float previousYrAllocation) {
        this.previousYrAllocation = previousYrAllocation;
    }

    public float getLeaveAppliedCurrYr() {
        return leaveAppliedCurrYr;
    }

    public void setLeaveAppliedCurrYr(float leaveAppliedCurrYr) {
        this.leaveAppliedCurrYr = leaveAppliedCurrYr;
    }

    public float getLeaveAvailedCurrYr() {
        return leaveAvailedCurrYr;
    }

    public void setLeaveAvailedCurrYr(float leaveAvailedCurrYr) {
        this.leaveAvailedCurrYr = leaveAvailedCurrYr;
    }

    public float getLeaveAppliedNextYr() {
        return leaveAppliedNextYr;
    }

    public void setLeaveAppliedNextYr(float leaveAppliedNextYr) {
        this.leaveAppliedNextYr = leaveAppliedNextYr;
    }

    public float getLeaveAvailedNextYr() {
        return leaveAvailedNextYr;
    }

    public void setLeaveAvailedNextYr(float leaveAvailedNextYr) {
        this.leaveAvailedNextYr = leaveAvailedNextYr;
    }

    public Date getEntitlementDate() {
        return entitlementDate;
    }

    public void setEntitlementDate(Date entitlementDate) {
        this.entitlementDate = entitlementDate;
    }

    public float getAdjustedHLeave() {
        return adjustedHLeave;
    }

    public void setAdjustedHLeave(float adjustedHLeave) {
        this.adjustedHLeave = adjustedHLeave;
    }

    public float getLeaveAvailHour() {
        return leaveAvailHour;
    }

    public void setLeaveAvailHour(float leaveAvailHour) {
        this.leaveAvailHour = leaveAvailHour;
    }

    public float getUploadOpeningBalance() {
        return uploadOpeningBalance;
    }

    public void setUploadOpeningBalance(float uploadOpeningBalance) {
        this.uploadOpeningBalance = uploadOpeningBalance;
    }

    public float getEncashDays() {
        return encashDays;
    }

    public void setEncashDays(float encashDays) {
        this.encashDays = encashDays;
    }

    public Date getReEntitlementDate() {
        return reEntitlementDate;
    }

    public void setReEntitlementDate(Date reEntitlementDate) {
        this.reEntitlementDate = reEntitlementDate;
    }
}
