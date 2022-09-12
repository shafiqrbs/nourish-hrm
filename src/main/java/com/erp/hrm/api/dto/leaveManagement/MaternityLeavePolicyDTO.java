package com.erp.hrm.api.dto.leaveManagement;
/**
 * Created by Sohag
 *
 */

public class MaternityLeavePolicyDTO {

    private String maternityLeaveRuleID;
    private String description;
    private int noOfDays;
    private int maxBenefit;
    private int dayGap;
    private int daysBenefitBefore;
    private int canGetBenefitAfterDays;
    private String dependsOn;
    private int yearCalculatedFrom;
    private int oTAverageMonth;
    private boolean isTransactionMonth;
    private String calculationOn;
    private String basedOn;
    private boolean considerEDD;
    private String basedHead;
    private String reportingHead;
    private String calculateBasedOn;
    private String dayStatus;
    private boolean considerSalaryHead;

    public MaternityLeavePolicyDTO() {
    }

    public MaternityLeavePolicyDTO(String maternityLeaveRuleID, String description, int noOfDays, int maxBenefit, int dayGap, int daysBenefitBefore, int canGetBenefitAfterDays, String dependsOn, int yearCalculatedFrom, int oTAverageMonth, boolean isTransactionMonth, String calculationOn, String basedOn, boolean considerEDD, String basedHead, String reportingHead, String calculateBasedOn, String dayStatus, boolean considerSalaryHead) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
        this.description = description;
        this.noOfDays = noOfDays;
        this.maxBenefit = maxBenefit;
        this.dayGap = dayGap;
        this.daysBenefitBefore = daysBenefitBefore;
        this.canGetBenefitAfterDays = canGetBenefitAfterDays;
        this.dependsOn = dependsOn;
        this.yearCalculatedFrom = yearCalculatedFrom;
        this.oTAverageMonth = oTAverageMonth;
        this.isTransactionMonth = isTransactionMonth;
        this.calculationOn = calculationOn;
        this.basedOn = basedOn;
        this.considerEDD = considerEDD;
        this.basedHead = basedHead;
        this.reportingHead = reportingHead;
        this.calculateBasedOn = calculateBasedOn;
        this.dayStatus = dayStatus;
        this.considerSalaryHead = considerSalaryHead;
    }

    public String getMaternityLeaveRuleID() {
        return maternityLeaveRuleID;
    }

    public void setMaternityLeaveRuleID(String maternityLeaveRuleID) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public int getMaxBenefit() {
        return maxBenefit;
    }

    public void setMaxBenefit(int maxBenefit) {
        this.maxBenefit = maxBenefit;
    }

    public int getDayGap() {
        return dayGap;
    }

    public void setDayGap(int dayGap) {
        this.dayGap = dayGap;
    }

    public int getDaysBenefitBefore() {
        return daysBenefitBefore;
    }

    public void setDaysBenefitBefore(int daysBenefitBefore) {
        this.daysBenefitBefore = daysBenefitBefore;
    }

    public int getCanGetBenefitAfterDays() {
        return canGetBenefitAfterDays;
    }

    public void setCanGetBenefitAfterDays(int canGetBenefitAfterDays) {
        this.canGetBenefitAfterDays = canGetBenefitAfterDays;
    }

    public String getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(String dependsOn) {
        this.dependsOn = dependsOn;
    }

    public int getYearCalculatedFrom() {
        return yearCalculatedFrom;
    }

    public void setYearCalculatedFrom(int yearCalculatedFrom) {
        this.yearCalculatedFrom = yearCalculatedFrom;
    }

    public int getoTAverageMonth() {
        return oTAverageMonth;
    }

    public void setoTAverageMonth(int oTAverageMonth) {
        this.oTAverageMonth = oTAverageMonth;
    }

    public boolean isTransactionMonth() {
        return isTransactionMonth;
    }

    public void setTransactionMonth(boolean transactionMonth) {
        isTransactionMonth = transactionMonth;
    }

    public String getCalculationOn() {
        return calculationOn;
    }

    public void setCalculationOn(String calculationOn) {
        this.calculationOn = calculationOn;
    }

    public String getBasedOn() {
        return basedOn;
    }

    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn;
    }

    public boolean isConsiderEDD() {
        return considerEDD;
    }

    public void setConsiderEDD(boolean considerEDD) {
        this.considerEDD = considerEDD;
    }

    public String getBasedHead() {
        return basedHead;
    }

    public void setBasedHead(String basedHead) {
        this.basedHead = basedHead;
    }

    public String getReportingHead() {
        return reportingHead;
    }

    public void setReportingHead(String reportingHead) {
        this.reportingHead = reportingHead;
    }

    public String getCalculateBasedOn() {
        return calculateBasedOn;
    }

    public void setCalculateBasedOn(String calculateBasedOn) {
        this.calculateBasedOn = calculateBasedOn;
    }

    public String getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String dayStatus) {
        this.dayStatus = dayStatus;
    }

    public boolean isConsiderSalaryHead() {
        return considerSalaryHead;
    }

    public void setConsiderSalaryHead(boolean considerSalaryHead) {
        this.considerSalaryHead = considerSalaryHead;
    }
}
