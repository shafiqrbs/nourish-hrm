package com.erp.hrm.api.dto.leaveManagement;

import java.util.Date;

/**
 * Created by Sohag on 15/09/2018.
 */
public class EmployeeLeaveAllocationDTO {
    private String employeeCode;
    private String leavePolicyID;
    private String leaveType;
    private String description;
    private float leaveAllocatedDays;
    private float openingBalance;
    private float externalOpening;
    private float totalDays;
    private float enCashDays;
    private float availedDays;
    private float adjustedDays;
    private float balance;
    private Date entitlementDate;

    public EmployeeLeaveAllocationDTO() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getLeaveAllocatedDays() {
        return leaveAllocatedDays;
    }

    public void setLeaveAllocatedDays(float leaveAllocatedDays) {
        this.leaveAllocatedDays = leaveAllocatedDays;
    }

    public float getOpeningBalance() {
        return openingBalance;
    }

    public void setOpeningBalance(float openingBalance) {
        this.openingBalance = openingBalance;
    }

    public float getExternalOpening() {
        return externalOpening;
    }

    public void setExternalOpening(float externalOpening) {
        this.externalOpening = externalOpening;
    }

    public float getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(float totalDays) {
        this.totalDays = totalDays;
    }

    public float getEnCashDays() {
        return enCashDays;
    }

    public void setEnCashDays(float enCashDays) {
        this.enCashDays = enCashDays;
    }

    public float getAvailedDays() {
        return availedDays;
    }

    public void setAvailedDays(float availedDays) {
        this.availedDays = availedDays;
    }

    public float getAdjustedDays() {
        return adjustedDays;
    }

    public void setAdjustedDays(float adjustedDays) {
        this.adjustedDays = adjustedDays;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getEntitlementDate() {
        return entitlementDate;
    }

    public void setEntitlementDate(Date entitlementDate) {
        this.entitlementDate = entitlementDate;
    }
}
