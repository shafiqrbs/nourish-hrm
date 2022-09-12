package com.erp.hrm.api.dto;

public class EmployeeGrossSalaryDTO {
    private String salaryRuleCode;
    private float grossSalary;
    private boolean isSalaryGenerateDisabled;

    public EmployeeGrossSalaryDTO() {
    }

    public EmployeeGrossSalaryDTO(String salaryRuleCode, float grossSalary, boolean isSalaryGenerateDisabled) {
        this.salaryRuleCode = salaryRuleCode;
        this.grossSalary = grossSalary;
        this.isSalaryGenerateDisabled = isSalaryGenerateDisabled;
    }

    public EmployeeGrossSalaryDTO(String salaryRuleCode, float grossSalary) {
        this.salaryRuleCode = salaryRuleCode;
        this.grossSalary = grossSalary;
    }

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
    }

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
    }

    public boolean isSalaryGenerateDisabled() {
        return isSalaryGenerateDisabled;
    }

    public void setSalaryGenerateDisabled(boolean salaryGenerateDisabled) {
        isSalaryGenerateDisabled = salaryGenerateDisabled;
    }
}
