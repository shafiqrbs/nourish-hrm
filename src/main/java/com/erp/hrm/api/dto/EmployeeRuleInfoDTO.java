package com.erp.hrm.api.dto;

import java.util.Date;

public class EmployeeRuleInfoDTO {
    private String employeeCode;
    private String leaveRuleCode;
    private String maternityLeaveRuleCode;
    private String paymentPolicy;
    private boolean ifRoasterApplicable;
    private String shiftPlan;
    private String shiftRosterRule;
    private String salaryGradeCode;
    private String attendanceRuleCode;
    private String currencyRuleCode;
    private Date dos;
    private String bankName;
    private String branchName;
    private String accountName;
    private String accountNo;

    public EmployeeRuleInfoDTO() {
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLeaveRuleCode() {
        return leaveRuleCode;
    }

    public void setLeaveRuleCode(String leaveRuleCode) {
        this.leaveRuleCode = leaveRuleCode;
    }

    public String getMaternityLeaveRuleCode() {
        return maternityLeaveRuleCode;
    }

    public void setMaternityLeaveRuleCode(String maternityLeaveRuleCode) {
        this.maternityLeaveRuleCode = maternityLeaveRuleCode;
    }

    public String getPaymentPolicy() {
        return paymentPolicy;
    }

    public void setPaymentPolicy(String paymentPolicy) {
        this.paymentPolicy = paymentPolicy;
    }

    public boolean isIfRoasterApplicable() {
        return ifRoasterApplicable;
    }

    public void setIfRoasterApplicable(boolean ifRoasterApplicable) {
        this.ifRoasterApplicable = ifRoasterApplicable;
    }

    public String getShiftPlan() {
        return shiftPlan;
    }

    public void setShiftPlan(String shiftPlan) {
        this.shiftPlan = shiftPlan;
    }

    public String getShiftRosterRule() {
        return shiftRosterRule;
    }

    public void setShiftRosterRule(String shiftRosterRule) {
        this.shiftRosterRule = shiftRosterRule;
    }

    public String getSalaryGradeCode() {
        return salaryGradeCode;
    }

    public void setSalaryGradeCode(String salaryGradeCode) {
        this.salaryGradeCode = salaryGradeCode;
    }

    public String getAttendanceRuleCode() {
        return attendanceRuleCode;
    }

    public void setAttendanceRuleCode(String attendanceRuleCode) {
        this.attendanceRuleCode = attendanceRuleCode;
    }

    public String getCurrencyRuleCode() {
        return currencyRuleCode;
    }

    public void setCurrencyRuleCode(String currencyRuleCode) {
        this.currencyRuleCode = currencyRuleCode;
    }

    public Date getDos() {
        return dos;
    }

    public void setDos(Date dos) {
        this.dos = dos;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
