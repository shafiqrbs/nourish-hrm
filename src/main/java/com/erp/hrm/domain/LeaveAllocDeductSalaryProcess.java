package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveAllocDeductSalaryProcess" )
public class LeaveAllocDeductSalaryProcess extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryProcID")
    private String SalaryProcID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @NotNull
    @Column(name = "LeaveAvailFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date LeaveAvailFrom;

    @NotNull
    @Column(name = "ToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ToDate;

    @Column(name = "Days")
    private double Days;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getSalaryProcID() {
        return SalaryProcID;
    }

    public void setSalaryProcID(String SalaryProcID) {
        this.SalaryProcID = SalaryProcID;
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

    public double getDays(){
        return Days;
    }

    public void setDays(double Days){
        this.Days=Days;
    }
}
