package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by SA
 */
@Entity
@Table( name = "MaternityLeaveTransInfo")
public class MaternityLeaveTransInfo extends BaseEntity {

    @Size(max = 10)
    @Column(name = "MaternityLeaveRuleID")
    private String maternityLeaveRuleID;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_MaternityLeaveTransInfo_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @NotNull
    @Column(name = "FromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @NotNull
    @Column(name = "ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @NotNull
    @Column(name = "IsBenefitGiven")
    private int isBenefitGiven;

    @Column(name = "TotalLeaveAvail")
    private int totalLeaveAvail;

    @Column(name = "EDD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EDD;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TranID", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_MaternityLeaveTransInfo_MaternityPayment"))
    private MaternityPayment maternityPayment;

    @Column(name = "days")
    private int days;

    @Size(max = 20)
    @Column(name = "approvedBy")
    private String approvedBy;

    @Column(name = "dateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;

    @Size(max = 20)
    @Column(name = "HRDMemoNo")
    private String hrdMemoNo;

    @Column(name = "HRDMemoDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hrdMemoDate;

    @Size(max = 250)
    @Column(name = "remarks")
    private String remarks;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
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
        return isBenefitGiven;
    }

    public void setIsBenefitGiven(int isBenefitGiven) {
        isBenefitGiven = isBenefitGiven;
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

    public MaternityPayment getMaternityPayment() {
        return maternityPayment;
    }

    public void setMaternityPayment(MaternityPayment maternityPayment) {
        this.maternityPayment = maternityPayment;
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
