package com.erp.hrm.domain;

import com.erp.hrm.util.DateUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "DailyAttendance", uniqueConstraints = { @UniqueConstraint( name="UK_DailyAttendance",columnNames = { "EmployeeCode","WorkDate","ShiftID","ShiftType","PunchType" } ) } )
public class DailyAttendance extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @NotNull
    @Column(name = "WorkDate",nullable = false)
    private Date workDate;

    @Size(max = 20)
    @NotNull
    @Column(name = "ShiftID",nullable = false)
    private String shiftID;

    @Size(max = 20)
    @NotNull
    @Column(name = "ShiftType",nullable = false)
    private String shiftType;

    @Column(name = "PTime")
    private Date pTime;

    @Column(name = "ApprovedPTime")
    private Date approvedPTime;

    @Size(max = 5)
    @NotNull
    @Column(name = "PunchType",nullable = false)
    private String punchType;

    @Column(name = "BCTime")
    private Date bcTime;

    @Column(name = "IsManual")
    private boolean isManual;

    @NotNull
    @Column(name = "IsLate",nullable = false, columnDefinition = "BIT CONSTRAINT DF_DailyAttendance_IsLate  DEFAULT 0")
    private boolean isLate;

    @Column(name = "DateApproved")
    private Date dateApproved;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Size(max = 1000)
    @Column(name = "Remarks")
    private String remarks;

    @Column(name = "IsReportProcessed" , nullable = false, columnDefinition = "BIT CONSTRAINT DF_DailyAttendance_IsReportProcessed  DEFAULT 0")
    private boolean isReportProcessed;


    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
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

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public Date getApprovedPTime() {
        return approvedPTime;
    }

    public void setApprovedPTime(Date approvedPTime) {
        this.approvedPTime = approvedPTime;
    }

    public String getPunchType() {
        return punchType;
    }

    public void setPunchType(String punchType) {
        this.punchType = punchType;
    }

    public Date getBcTime() {
        return bcTime;
    }

    public void setBcTime(Date bcTime) {
        this.bcTime = bcTime;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isReportProcessed() {
        return isReportProcessed;
    }

    public void setReportProcessed(boolean reportProcessed) {
        isReportProcessed = reportProcessed;
    }

    public DailyAttendance() {
    }

    public DailyAttendance(@NotNull String employeeCode,
                           @NotNull Date workDate,
                           @NotNull String shiftID,
                           @NotNull String shiftType,
                           @NotNull String punchType,
                           Date pTime) {

        this.employeeCode = employeeCode;
        this.workDate = workDate;
        this.shiftID = shiftID;
        this.shiftType = shiftType;
        this.pTime = pTime;
        this.punchType = punchType;
        this.isLate = false;
        this.bcTime = workDate;
        this.isManual = false;

        this.isReportProcessed = false;


    }
}
