package com.erp.hrm.api.dto.leaveManagement;

import java.util.Date;

/**
 * Created by SA
 */
public class MaternityLeaveTransInfoDTO {
    private String employeeCode;
    private String maternityLeaveRuleID;
    private Date fromDate;
    private Date toDate;
    private int IsBenefitGiven;
    private int totalLeaveAvail;
    private Date EDD;
    private String tranID;
    private int days;
    private String approvedBy;
    private Date dateApproved;
    private String hrdMemoNo;
    private Date hrdMemoDate;
    private String remarks;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getMaternityLeaveRuleID() {
        return maternityLeaveRuleID;
    }

    public void setMaternityLeaveRuleID(String maternityLeaveRuleID) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getIsBenefitGiven() {
        return IsBenefitGiven;
    }

    public void setIsBenefitGiven(int isBenefitGiven) {
        IsBenefitGiven = isBenefitGiven;
    }

    public int getTotalLeaveAvail() {
        return totalLeaveAvail;
    }

    public void setTotalLeaveAvail(int totalLeaveAvail) {
        this.totalLeaveAvail = totalLeaveAvail;
    }

    public Date getEDD() {
        return EDD;
    }

    public void setEDD(Date EDD) {
        this.EDD = EDD;
    }

    public String getTranID() {
        return tranID;
    }

    public void setTranID(String tranID) {
        this.tranID = tranID;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getHrdMemoNo() {
        return hrdMemoNo;
    }

    public void setHrdMemoNo(String hrdMemoNo) {
        this.hrdMemoNo = hrdMemoNo;
    }

    public Date getHrdMemoDate() {
        return hrdMemoDate;
    }

    public void setHrdMemoDate(Date hrdMemoDate) {
        this.hrdMemoDate = hrdMemoDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
