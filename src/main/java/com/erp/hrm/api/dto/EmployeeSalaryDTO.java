package com.erp.hrm.api.dto;

/**
 * Created by Sohag on 15/08/2018.
 */
public class EmployeeSalaryDTO {
    private String salaryRuleCode;
    private String salaryHeadID;
    private String sCriteria;
    private float amount;
    private float netAmount;

    public EmployeeSalaryDTO() {
    }

    public EmployeeSalaryDTO(String salaryRuleCode, String salaryHeadID, String sCriteria, float amount, float netAmount) {
        this.salaryRuleCode = salaryRuleCode;
        this.salaryHeadID = salaryHeadID;
        this.sCriteria = sCriteria;
        this.amount = amount;
        this.netAmount = netAmount;
    }

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(float netAmount) {
        this.netAmount = netAmount;
    }
}
