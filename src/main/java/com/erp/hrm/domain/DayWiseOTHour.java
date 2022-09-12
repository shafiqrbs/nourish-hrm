package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "DayWiseOTHour" )
public class DayWiseOTHour extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @NotNull
    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String shiftID;

    @Column(name = "WorkDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date workDate;

    @Size(max = 20)
    @Column(name = "SlabType",nullable = false)
    private String slabType;

    @Column(name = "OTHour", columnDefinition = "NUMERIC(18,4)")
    private float otHour;

    @Column(name = "Rate", columnDefinition = "NUMERIC(18,4)")
    private float rate;

    @Size(max = 50)
    @Column(name = "otRule",nullable = false)
    private String otRule;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getSlabType() {
        return slabType;
    }

    public void setSlabType(String slabType) {
        this.slabType = slabType;
    }

    public float getOtHour() {
        return otHour;
    }

    public void setOtHour(float otHour) {
        this.otHour = otHour;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getOtRule() {
        return otRule;
    }

    public void setOtRule(String otRule) {
        this.otRule = otRule;
    }
}
