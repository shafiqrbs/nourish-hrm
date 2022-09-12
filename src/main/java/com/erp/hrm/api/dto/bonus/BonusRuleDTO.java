package com.erp.hrm.api.dto.bonus;

import java.util.Date;

/**
 * Created by Sohag on 27/09/2018.
 */
public class BonusRuleDTO {

    private String bonusCode;
    private String description;
    private boolean isActive;
    private String availFrom;
    private int calculationAfter;
    private boolean isProcessApproved;
    private long bonusPaymentPolicyId;
    private String staffCategory;
    private int minServiceLen;
    private int maxServiceLen;
    private int calOnPaidSalaryForProdEmployee;
    private int noOfMonthForAvrSalCal;
    private String sCriteria;
    private String salaryHeadID;
    private float amount;
    private boolean isFixedCalculation;
    private long bonusEffectiveId;
    private Date effectiveDate;

    public BonusRuleDTO() {
    }

    public BonusRuleDTO(String bonusCode, String description, boolean isActive, String availFrom, int calculationAfter,
                        boolean isProcessApproved, long bonusPaymentPolicyId, String staffCategory, int minServiceLen,
                        int maxServiceLen, int calOnPaidSalaryForProdEmployee, int noOfMonthForAvrSalCal, String sCriteria,
                        String salaryHeadID, float amount, boolean isFixedCalculation,Date effectiveDate,long bonusEffectiveId) {
        this.bonusCode = bonusCode;
        this.description = description;
        this.isActive = isActive;
        this.availFrom = availFrom;
        this.calculationAfter = calculationAfter;
        this.isProcessApproved = isProcessApproved;
        this.bonusPaymentPolicyId = bonusPaymentPolicyId;
        this.staffCategory = staffCategory;
        this.minServiceLen = minServiceLen;
        this.maxServiceLen = maxServiceLen;
        this.calOnPaidSalaryForProdEmployee = calOnPaidSalaryForProdEmployee;
        this.noOfMonthForAvrSalCal = noOfMonthForAvrSalCal;
        this.sCriteria = sCriteria;
        this.salaryHeadID = salaryHeadID;
        this.amount = amount;
        this.isFixedCalculation = isFixedCalculation;
        this.effectiveDate = effectiveDate;
        this.bonusEffectiveId = bonusEffectiveId;
    }

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAvailFrom() {
        return availFrom;
    }

    public void setAvailFrom(String availFrom) {
        this.availFrom = availFrom;
    }

    public int getCalculationAfter() {
        return calculationAfter;
    }

    public void setCalculationAfter(int calculationAfter) {
        this.calculationAfter = calculationAfter;
    }

    public boolean isProcessApproved() {
        return isProcessApproved;
    }

    public void setProcessApproved(boolean processApproved) {
        isProcessApproved = processApproved;
    }

    public long getBonusPaymentPolicyId() {
        return bonusPaymentPolicyId;
    }

    public void setBonusPaymentPolicyId(long bonusPaymentPolicyId) {
        this.bonusPaymentPolicyId = bonusPaymentPolicyId;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public int getMinServiceLen() {
        return minServiceLen;
    }

    public void setMinServiceLen(int minServiceLen) {
        this.minServiceLen = minServiceLen;
    }

    public int getMaxServiceLen() {
        return maxServiceLen;
    }

    public void setMaxServiceLen(int maxServiceLen) {
        this.maxServiceLen = maxServiceLen;
    }

    public int getCalOnPaidSalaryForProdEmployee() {
        return calOnPaidSalaryForProdEmployee;
    }

    public void setCalOnPaidSalaryForProdEmployee(int calOnPaidSalaryForProdEmployee) {
        this.calOnPaidSalaryForProdEmployee = calOnPaidSalaryForProdEmployee;
    }

    public int getNoOfMonthForAvrSalCal() {
        return noOfMonthForAvrSalCal;
    }

    public void setNoOfMonthForAvrSalCal(int noOfMonthForAvrSalCal) {
        this.noOfMonthForAvrSalCal = noOfMonthForAvrSalCal;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isFixedCalculation() {
        return isFixedCalculation;
    }

    public void setFixedCalculation(boolean isFixedCalculation) {
        this.isFixedCalculation = isFixedCalculation;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public long getBonusEffectiveId() {
        return bonusEffectiveId;
    }

    public void setBonusEffectiveId(long bonusEffectiveId) {
        this.bonusEffectiveId = bonusEffectiveId;
    }
}
