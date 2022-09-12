package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag
 */
@Entity
@Table( name = "MaternityLeaveRule" ,uniqueConstraints = { @UniqueConstraint( name = "UK_MaternityLeaveRule",columnNames = { "MaternityLeaveRuleID"} ) } )
public class MaternityLeaveRule extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "MaternityLeaveRuleID")
    private String maternityLeaveRuleID;

    @Size(max = 150)
    @Column(name = "Description")
    private String description;

    @NotNull
    @Column(name = "NoOfDays")
    private int noOfDays;

    @NotNull
    @Column(name = "MaxBenefit")
    private int maxBenefit;

    @NotNull
    @Column(name = "DayGap")
    private int dayGap;

    @NotNull
    @Column(name = "DaysBenefitBefore")
    private int daysBenefitBefore;

    @NotNull
    @Column(name = "CanGetBenefitAfterDays")
    private int canGetBenefitAfterDays;

    @Size(max = 3)
    @Column(name = "DependsOn")
    private String dependsOn;

    @Column(name = "YearCalculatedFrom",columnDefinition = "INT DEFAULT 0")
    private int yearCalculatedFrom;

    @Column(name = "OTAverageMonth")
    private int oTAverageMonth;

    @Column(name = "IsTransactionMonth",columnDefinition = "BIT DEFAULT 0")
    private boolean isTransactionMonth;

    @Size(max = 1)
    @Column(name = "CalculationOn")
    private String calculationOn;

    @Size(max = 1)
    @Column(name = "BasedOn")
    private String basedOn;

    @Column(name = "ConsiderEDD",columnDefinition = "BIT DEFAULT 0")
    private boolean considerEDD;

    @Size(max = 25)
    @Column(name = "BasedHead")
    private String basedHead;

    @Size(max = 25)
    @Column(name = "ReportingHead")
    private String reportingHead;

    @Size(max = 10)
    @Column(name = "CalculateBasedOn")
    private String calculateBasedOn;

    @Size(max = 50)
    @Column(name = "DayStatus")
    private String dayStatus;

    @Column(name = "ConsiderSalaryHead",columnDefinition = "BIT DEFAULT 0")
    private boolean considerSalaryHead;

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
