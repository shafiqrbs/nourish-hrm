package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity(name = "EmployeeRuleInfo")
@Table(name = "EmployeeRuleInfo")
public class EmployeeRuleInfo extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode",columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeRuleInfo_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;


    @Size(max = 20)
    @Column(name = "LeaveRuleCode")
    private String leaveRuleCode;

    @Size(max = 20)
    @Column(name = "SalaryGradeCode")
    private String salaryGradeCode;

    @Size(max = 20)
    @Column(name = "MaternityLeaveRuleCode")
    private String maternityLeaveRuleCode;

    @Size(max = 20)
    @Column(name = "AttendanceRuleCode")
    private String attendanceRuleCode;

    @Size(max = 20)
    @Column(name = "PaymentPolicyRuleCode")
    private String paymentPolicyRuleCode;

    @Size(max = 20)
    @Column(name = "CurrencyRuleCode")
    private String currencyRuleCode;

    @Column(name = "IsRosterApplicable")
    private boolean isRosterApplicable;

    @Size(max = 32)
    @Column(name = "ShiftRuleCode")
    private String shiftRuleCode;

    @Size(max = 10)
    @Column(name = "ShiftID")
    private String shiftID;

    @Column(name = "DefaultWorkOfStartDate")
    private Date defaultWorkOfStartDate;

    @Size(max = 256)
    @Column(name = "BankName")
    private String bankName;

    @Size(max = 256)
    @Column(name = "BranchName")
    private String branchName;

    @Size(max = 256)
    @Column(name = "AccountNo")
    private String accountNo;

    @Size(max = 256)
    @Column(name = "AccountName")
    private String AccountName;


    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getLeaveRuleCode() {
        return leaveRuleCode;
    }

    public void setLeaveRuleCode(String leaveRuleCode) {
        this.leaveRuleCode = leaveRuleCode;
    }

    public String getSalaryGradeCode() {
        return salaryGradeCode;
    }

    public void setSalaryGradeCode(String salaryGradeCode) {
        this.salaryGradeCode = salaryGradeCode;
    }

    public String getMaternityLeaveRuleCode() {
        return maternityLeaveRuleCode;
    }

    public void setMaternityLeaveRuleCode(String maternityLeaveRuleCode) {
        this.maternityLeaveRuleCode = maternityLeaveRuleCode;
    }

    public String getAttendanceRuleCode() {
        return attendanceRuleCode;
    }

    public void setAttendanceRuleCode(String attendanceRuleCode) {
        this.attendanceRuleCode = attendanceRuleCode;
    }

    public String getPaymentPolicyRuleCode() {
        return paymentPolicyRuleCode;
    }

    public void setPaymentPolicyRuleCode(String paymentPolicyRuleCode) {
        this.paymentPolicyRuleCode = paymentPolicyRuleCode;
    }

    public String getCurrencyRuleCode() {
        return currencyRuleCode;
    }

    public void setCurrencyRuleCode(String currencyRuleCode) {
        this.currencyRuleCode = currencyRuleCode;
    }

    public boolean isRosterApplicable() {
        return isRosterApplicable;
    }

    public void setRosterApplicable(boolean rosterApplicable) {
        isRosterApplicable = rosterApplicable;
    }

    public void setIsRosterApplicable(boolean isRosterApplicable){
        this.isRosterApplicable = isRosterApplicable;
    }

    public String getShiftRuleCode() {
        return shiftRuleCode;
    }

    public void setShiftRuleCode(String shiftRuleCode) {
        this.shiftRuleCode = shiftRuleCode;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public Date getDefaultWorkOfStartDate() {
        return defaultWorkOfStartDate;
    }

    public void setDefaultWorkOfStartDate(Date defaultWorkOfStartDate) {
        this.defaultWorkOfStartDate = defaultWorkOfStartDate;
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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }
}
