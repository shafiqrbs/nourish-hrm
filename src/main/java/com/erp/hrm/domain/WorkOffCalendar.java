package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by WS on 15/08/2018.
 */
@Entity
@Table( name = "WorkOffCalendar", uniqueConstraints = { @UniqueConstraint( name ="UK_WorkOffCalendar",columnNames = { "EmployeeCode","WorkOffDate","ShiftID" } ) } )

public class WorkOffCalendar extends BaseEntity {

    @Size(max = 20)
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @Column(name = "WorkOffDate", nullable = false)
    private Date workOffDate;

    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String shiftID;

    @Size(max = 50)
    @Column(name = "ShiftType")
    private String shiftType;

    @Size(max = 10)
    @Column(name = "DayType")
    private String dayType;

    @Column(name = "WorkDate")
    private Date workDate;

    @Column(name = "IscompensatoryLeave", columnDefinition = "BIT  CONSTRAINT DF_WorkOffCalendar_IscompensatoryLeave DEFAULT 0")
    private boolean isCompensatoryLeave;

    @Column(name = "Sequence",nullable = false, columnDefinition = "INT  CONSTRAINT DF_WorkOffCalendar_Sequence DEFAULT 0")
    private int sequence;

    @Size(max = 256)
    @Column(name = "Remarks")
    private String remarks;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getWorkOffDate() {
        return workOffDate;
    }

    public void setWorkOffDate(Date workOffDate) {
        this.workOffDate = workOffDate;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public boolean isCompensatoryLeave() {
        return isCompensatoryLeave;
    }

    public void setCompensatoryLeave(boolean compensatoryLeave) {
        isCompensatoryLeave = compensatoryLeave;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
