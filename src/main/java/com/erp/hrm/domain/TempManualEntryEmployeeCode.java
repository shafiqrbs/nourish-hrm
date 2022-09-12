package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 19/01/2019.
 */
@Entity
@Table( name = "TempManualEntryEmployeeCode" )
public class TempManualEntryEmployeeCode extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Size(max = 5)
    @Column(name = "EntryType", columnDefinition = "VARCHAR(16)")
    private String entryType;

    @Column(name = "EntryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryDate;

    @Size(max = 16)
    @Column(name = "TimeStartRange", columnDefinition = "VARCHAR(16)")
    private String timeStartRange;

    @Size(max = 16)
    @Column(name = "TimeEndRange", columnDefinition = "VARCHAR(16)")
    private String timeEndRange;

    @Column(name = "EditedEntryDateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editedEntryDateTime;

    @Size(max = 20)
    @Column(name = "ShiftID")
    private String shiftID;

    @Size(max = 20)
    @Column(name = "ShiftType")
    private String shiftType;

    @Size(max = 250)
    @Column(name = "UserId")
    private String userId;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getTimeStartRange() {
        return timeStartRange;
    }

    public void setTimeStartRange(String timeStartRange) {
        this.timeStartRange = timeStartRange;
    }

    public String getTimeEndRange() {
        return timeEndRange;
    }

    public void setTimeEndRange(String timeEndRange) {
        this.timeEndRange = timeEndRange;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getEditedEntryDateTime() {
        return editedEntryDateTime;
    }

    public void setEditedEntryDateTime(Date editedEntryDateTime) {
        this.editedEntryDateTime = editedEntryDateTime;
    }
}
