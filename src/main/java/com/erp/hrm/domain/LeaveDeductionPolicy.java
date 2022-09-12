package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveDeductionPolicy" )
public class LeaveDeductionPolicy extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "AttendancePaymentRuleCode")
    private String AttendancePaymentRuleCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "AttendancePaymentName")
    private String AttendancePaymentName;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @Column(name = "SequenceNo")
    private Integer SequenceNo;

    public String getAttendancePaymentRuleCode() {
        return AttendancePaymentRuleCode;
    }

    public void setAttendancePaymentRuleCode(String AttendancePaymentRuleCode) {
        this.AttendancePaymentRuleCode = AttendancePaymentRuleCode;
    }

    public String getAttendancePaymentName() {
        return AttendancePaymentName;
    }

    public void setAttendancePaymentName(String AttendancePaymentName) {
        this.AttendancePaymentName = AttendancePaymentName;
    }

    public String getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(String LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public String getLeaveRuleID() {
        return LeaveRuleID;
    }

    public void setLeaveRuleID(String LeaveRuleID) {
        this.LeaveRuleID = LeaveRuleID;
    }

    public Integer getSequenceNo(){
        return SequenceNo;
    }

    public void setSequenceNo(Integer SequenceNo){
        this.SequenceNo=SequenceNo;
    }
}
