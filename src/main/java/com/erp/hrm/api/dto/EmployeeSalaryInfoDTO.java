package com.erp.hrm.api.dto;

/**
 * Created by Sohag on 15/08/2018.
 */
public class EmployeeSalaryInfoDTO {
    private String employeeCode;
    private String salaryRuleCode;
    private float employeeGrossSalary;

    public EmployeeSalaryInfoDTO() {
    }

    public EmployeeSalaryInfoDTO(String employeeCode, String salaryRuleCode, float employeeGrossSalary) {
        this.employeeCode = employeeCode;
        this.salaryRuleCode = salaryRuleCode;
        this.employeeGrossSalary = employeeGrossSalary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
    }

    public float getEmployeeGrossSalary() {
        return employeeGrossSalary;
    }

    public void setEmployeeGrossSalary(float employeeGrossSalary) {
        this.employeeGrossSalary = employeeGrossSalary;
    }
}
