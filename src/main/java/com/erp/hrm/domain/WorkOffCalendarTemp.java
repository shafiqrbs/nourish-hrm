package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by WS on 15/08/2018.
 */
@Entity
@Table( name = "WorkOffCalendarTemp" )

public class WorkOffCalendarTemp extends BaseEntity {

    @Size(max = 20)
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @Column(name = "WorkOffDate", nullable = false)
    private Date workOffDate;

    @Size(max = 50)
    @Column(name = "ShiftType")
    private String shiftType;

    @Size(max = 20)
    @Column(name = "ShiftId")
    private String shiftId;

    @Size(max = 10)
    @Column(name = "DayType")
    private String dayType;

    @Size(max = 256)
    @Column(name = "Remarks")
    private String remarks;

    @Size(max = 250)
    @Column(name = "UserId")
    private String userId;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
