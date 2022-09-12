package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveAlloc" )
public class LeaveAlloc extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @NotNull
    @Column(name = "LeaveAvailFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LeaveAvailFrom;

    @NotNull
    @Column(name = "ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ToDate;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @Column(name = "PreviousDays")
    private double PreviousDays;

    @Column(name = "Days")
    private double Days;

    @Column(name = "Balance")
    private double Balance;

    @Column(name = "OpeningTransaction")
    private double OpeningTransaction;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public Date getLeaveAvailFrom() {
        return LeaveAvailFrom;
    }

    public void setLeaveAvailFrom(Date LeaveAvailFrom) {
        this.LeaveAvailFrom = LeaveAvailFrom;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date ToDate) {
        this.ToDate = ToDate;
    }

    public String getLeaveRuleID() {
        return LeaveRuleID;
    }

    public void setLeaveRuleID(String LeaveRuleID) {
        this.LeaveRuleID = LeaveRuleID;
    }

    public String getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(String LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public double getPreviousDays() {
        return PreviousDays;
    }

    public void setPreviousDays(double PreviousDays) {
        this.PreviousDays = PreviousDays;
    }

    public double getDays() {
        return Days;
    }

    public void setDays(double Days) {
        this.Days = Days;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double Balance) {
        this.Balance = Balance;
    }

    public double getOpeningTransaction() {
        return OpeningTransaction;
    }

    public void setOpeningTransaction(double OpeningTransaction) {
        this.OpeningTransaction = OpeningTransaction;
    }
}
