package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveEncashment" )
public class LeaveEncashment extends BaseEntity {

    @NotNull
    @Column(name = "YearNo")
    private Integer YearNo;

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EffectiveDate;

    @Column(name = "Days")
    private double Days;

    @Column(name = "Amount")
    private double Amount;

    @Column(name = "DivideFactor")
    private double DivideFactor;

    @Size(max = 20)
    @Column(name = "SalaryProcID")
    private String SalaryProcID;

    public Integer getYearNo() {
        return YearNo;
    }

    public void setYearNo(Integer YearNo) {
        this.YearNo = YearNo;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(String LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public Date getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(Date EffectiveDate) {
        this.EffectiveDate = EffectiveDate;
    }

    public double getDays() {
        return Days;
    }

    public void setDays(double Days) {
        this.Days = Days;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public double getDivideFactor(){
        return DivideFactor;
    }

    public void setDivideFactor(double DivideFactor){
        this.DivideFactor=DivideFactor;
    }

    public String getSalaryProcID(){
        return SalaryProcID;
    }

    public void setSalaryProcID(String SalaryProcID){
        this.SalaryProcID=SalaryProcID;
    }
}
