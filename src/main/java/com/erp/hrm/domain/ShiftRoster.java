package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table( name = "ShiftRoster", uniqueConstraints = { @UniqueConstraint( name ="UK_ShiftRoster",columnNames = { "EmployeeCode","ShiftDate","ShiftID" } ) } )
public class ShiftRoster extends BaseEntity {

    @Size(max = 20)
    @Column(name = "EmployeeCode",nullable = false)
    private String EmployeeCode;

    @Column(name = "ShiftDate",nullable = false)
    private Date ShiftDate;

    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String ShiftID;

    @Size(max = 20)
    @Column(name = "ShiftType",nullable = false)
    private String ShiftType;

    @Column(name = "IsDefault",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_ShiftRoster_IsDefault DEFAULT 0")
    private boolean IsDefault;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public Date getShiftDate() {
        return ShiftDate;
    }

    public void setShiftDate(Date shiftDate) {
        ShiftDate = shiftDate;
    }

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String shiftID) {
        ShiftID = shiftID;
    }

    public String getShiftType() {
        return ShiftType;
    }

    public void setShiftType(String shiftType) {
        ShiftType = shiftType;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }
}
