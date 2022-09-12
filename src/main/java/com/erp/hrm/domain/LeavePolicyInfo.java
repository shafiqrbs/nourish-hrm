package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by WS
 */
@Entity
@Table( name = "LeavePolicyInfo" ,uniqueConstraints = { @UniqueConstraint( name = "UK_LeavePolicyInfo",columnNames = { "LeavePolicyID"} ) }  )
public class LeavePolicyInfo extends BaseByOnEntity {

    @Id
    @Size(max = 10)
    @NotNull
    @Column(name = "LeavePolicyID")
    private String leavePolicyID;

    @Size(max = 50)
    @Column(name = "PolicyDescription")
    private String policyDescription;

    @Size(max = 50)
    @Column(name = "LeaveType")
    private String leaveType;

    @Size(max = 5)
    @NotNull
    @Column(name = "LeaveCategory")
    private String leaveCategory;

    @Column(name = "IsDefault", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_IsDefault DEFAULT 0")
    private boolean isDefault;

    @Size(max = 25)
    @NotNull
    @Column(name = "LeaveCredit")
    private String leaveCredit;

    @Column(name = "IsServiceLengthDependant", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_IsServiceLengthDependant DEFAULT 0")
    private boolean isServiceLengthDependant;

    @Column(name = "IsFixedDays", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_IsFixedDays DEFAULT 0")
    private boolean isFixedDays;

    @Column(name = "isCarryForwarded", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_IsCarryForwarded DEFAULT 0")
    private boolean isCarryForwarded;

    @Column(name = "IsConsecutiveLimit", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_IsConsecutiveLimit DEFAULT 0")
    private boolean isConsecutiveLimit;

    @Size(max = 25)
    @NotNull
    @Column(name = "CalculationBasis")
    private String calculationBasis;

    @NotNull
    @Column(name = "CalculateAfter")
    private int calculateAfter;

    @Column(name = "AllowPreceedingHolidays", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_AllowPreceedingHolidays DEFAULT 0")
    private boolean allowPreceedingHolidays;

    @Column(name = "AllowSucceedingHolidays", nullable = false, columnDefinition = "BIT CONSTRAINT DF_LeavePolicyInfo_AllowSucceedingHolidays DEFAULT 0")
    private boolean allowSucceedingHolidays;

    @Size(max = 10)
    @Column(name = "WorkDayType")
    private String workDayType;

    @Size(max = 5)
    @Column(name = "CalenderType",nullable = false)
    private String calenderType;

    @Size(max = 100)
    @Column(name = "DayStatus")
    private String dayStatus;

    @Column(name = "AdjustedHour", columnDefinition = "NUMERIC(18, 0)")
    private BigDecimal adjustedHour;

    @Column(name = "FYrLVProportionateBasedOnDOJDOC")
    private boolean fyrLVProportionateBasedOnDOJDOC;

    @Column(name = "IsAllowAdvanceLeave")
    private boolean isAllowAdvanceLeave;

    @Column(name = "IsAllowOpeningBalance")
    private boolean isAllowOpeningBalance;

    @OneToMany(mappedBy = "leavePolicyInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmpLeaveTransactionApplied> empLeaveTransactionApplied;

    @OneToMany(mappedBy = "leavePolicyInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmployeeLeaveMaster> employeeLeaveMasters;

    public String getLeavePolicyID() {
        return leavePolicyID;
    }

    public void setLeavePolicyID(String leavePolicyID) {
        this.leavePolicyID = leavePolicyID;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveCategory() {
        return leaveCategory;
    }

    public void setLeaveCategory(String leaveCategory) {
        this.leaveCategory = leaveCategory;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getLeaveCredit() {
        return leaveCredit;
    }

    public void setLeaveCredit(String leaveCredit) {
        this.leaveCredit = leaveCredit;
    }

    public boolean isServiceLengthDependant() {
        return isServiceLengthDependant;
    }

    public void setServiceLengthDependant(boolean serviceLengthDependant) {
        isServiceLengthDependant = serviceLengthDependant;
    }

    public boolean isFixedDays() {
        return isFixedDays;
    }

    public void setFixedDays(boolean fixedDays) {
        isFixedDays = fixedDays;
    }

    public boolean isCarryForwarded() {
        return isCarryForwarded;
    }

    public void setCarryForwarded(boolean carryForwarded) {
        isCarryForwarded = carryForwarded;
    }

    public boolean isConsecutiveLimit() {
        return isConsecutiveLimit;
    }

    public void setConsecutiveLimit(boolean consecutiveLimit) {
        isConsecutiveLimit = consecutiveLimit;
    }

    public String getCalculationBasis() {
        return calculationBasis;
    }

    public void setCalculationBasis(String calculationBasis) {
        this.calculationBasis = calculationBasis;
    }

    public int getCalculateAfter() {
        return calculateAfter;
    }

    public void setCalculateAfter(int calculateAfter) {
        this.calculateAfter = calculateAfter;
    }

    public boolean isAllowPreceedingHolidays() {
        return allowPreceedingHolidays;
    }

    public void setAllowPreceedingHolidays(boolean allowPreceedingHolidays) {
        this.allowPreceedingHolidays = allowPreceedingHolidays;
    }

    public boolean isAllowSucceedingHolidays() {
        return allowSucceedingHolidays;
    }

    public void setAllowSucceedingHolidays(boolean allowSucceedingHolidays) {
        this.allowSucceedingHolidays = allowSucceedingHolidays;
    }

    public String getWorkDayType() {
        return workDayType;
    }

    public void setWorkDayType(String workDayType) {
        this.workDayType = workDayType;
    }

    public String getCalenderType() {
        return calenderType;
    }

    public void setCalenderType(String calenderType) {
        this.calenderType = calenderType;
    }

    public String getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String dayStatus) {
        this.dayStatus = dayStatus;
    }

    public BigDecimal getAdjustedHour() {
        return adjustedHour;
    }

    public void setAdjustedHour(BigDecimal adjustedHour) {
        this.adjustedHour = adjustedHour;
    }

    public boolean isFyrLVProportionateBasedOnDOJDOC() {
        return fyrLVProportionateBasedOnDOJDOC;
    }

    public void setFyrLVProportionateBasedOnDOJDOC(boolean fyrLVProportionateBasedOnDOJDOC) {
        this.fyrLVProportionateBasedOnDOJDOC = fyrLVProportionateBasedOnDOJDOC;
    }

    public boolean isAllowAdvanceLeave() {
        return isAllowAdvanceLeave;
    }

    public void setAllowAdvanceLeave(boolean allowAdvanceLeave) {
        isAllowAdvanceLeave = allowAdvanceLeave;
    }

    public boolean isAllowOpeningBalance() {
        return isAllowOpeningBalance;
    }

    public void setAllowOpeningBalance(boolean allowOpeningBalance) {
        isAllowOpeningBalance = allowOpeningBalance;
    }
}
