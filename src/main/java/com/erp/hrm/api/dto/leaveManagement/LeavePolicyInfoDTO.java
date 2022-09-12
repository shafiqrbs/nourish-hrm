package com.erp.hrm.api.dto.leaveManagement;

public class LeavePolicyInfoDTO {
    private String policyID;
    private String leaveType;
    private String policyDescription;
    private String leaveCategory;
    private String leaveCredit;
    private boolean fixedDays;
    private String dayStatus; // Fixed or Based on Working Days
    private boolean serviceLengthDependant;
    private String leaveCalculationBasis;
    private int calculateAfter;
    private boolean isDefault;
    private boolean fYrLVProportionateBasedOnDOJDOC;
    private boolean carryForwarded;
    private boolean consecutiveLimit;
    private boolean allowAdvanceLeave;
    private boolean allowPreceedingHolidays;
    private boolean allowSucceedingHolidays;
    private String calenderType;
    private boolean allowOpeningBalance;
    private int adjustedHour;

    private int leaveDays;
    private int maxAllocationDays;

    public LeavePolicyInfoDTO() {
    }


    public String getPolicyID() {
        return policyID;
    }

    public void setPolicyID(String policyID) {
        this.policyID = policyID;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public String getLeaveCategory() {
        return leaveCategory;
    }

    public void setLeaveCategory(String leaveCategory) {
        this.leaveCategory = leaveCategory;
    }

    public String getLeaveCredit() {
        return leaveCredit;
    }

    public void setLeaveCredit(String leaveCredit) {
        this.leaveCredit = leaveCredit;
    }

    public boolean isFixedDays() {
        return fixedDays;
    }

    public void setFixedDays(boolean fixedDays) {
        this.fixedDays = fixedDays;
    }

    public String getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String dayStatus) {
        this.dayStatus = dayStatus;
    }

    public boolean isServiceLengthDependant() {
        return serviceLengthDependant;
    }

    public void setServiceLengthDependant(boolean serviceLengthDependant) {
        this.serviceLengthDependant = serviceLengthDependant;
    }

    public String getLeaveCalculationBasis() {
        return leaveCalculationBasis;
    }

    public void setLeaveCalculationBasis(String leaveCalculationBasis) {
        this.leaveCalculationBasis = leaveCalculationBasis;
    }

    public int getCalculateAfter() {
        return calculateAfter;
    }

    public void setCalculateAfter(int calculateAfter) {
        this.calculateAfter = calculateAfter;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isfYrLVProportionateBasedOnDOJDOC() {
        return fYrLVProportionateBasedOnDOJDOC;
    }

    public void setfYrLVProportionateBasedOnDOJDOC(boolean fYrLVProportionateBasedOnDOJDOC) {
        this.fYrLVProportionateBasedOnDOJDOC = fYrLVProportionateBasedOnDOJDOC;
    }

    public boolean isCarryForwarded() {
        return carryForwarded;
    }

    public void setCarryForwarded(boolean carryForwarded) {
        this.carryForwarded = carryForwarded;
    }

    public boolean isConsecutiveLimit() {
        return consecutiveLimit;
    }

    public void setConsecutiveLimit(boolean consecutiveLimit) {
        this.consecutiveLimit = consecutiveLimit;
    }

    public boolean isAllowAdvanceLeave() {
        return allowAdvanceLeave;
    }

    public void setAllowAdvanceLeave(boolean allowAdvanceLeave) {
        this.allowAdvanceLeave = allowAdvanceLeave;
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

    public String getCalenderType() {
        return calenderType;
    }

    public void setCalenderType(String calenderType) {
        this.calenderType = calenderType;
    }

    public boolean isAllowOpeningBalance() {
        return allowOpeningBalance;
    }

    public void setAllowOpeningBalance(boolean allowOpeningBalance) {
        this.allowOpeningBalance = allowOpeningBalance;
    }

    public int getAdjustedHour() {
        return adjustedHour;
    }

    public void setAdjustedHour(int adjustedHour) {
        this.adjustedHour = adjustedHour;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public int getMaxAllocationDays() {
        return maxAllocationDays;
    }

    public void setMaxAllocationDays(int maxAllocationDays) {
        this.maxAllocationDays = maxAllocationDays;
    }
}
