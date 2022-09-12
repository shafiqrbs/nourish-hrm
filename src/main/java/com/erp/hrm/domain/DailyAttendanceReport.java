package com.erp.hrm.domain;

import com.erp.hrm.util.DateUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "DailyAttendanceReport", uniqueConstraints = { @UniqueConstraint( name="UK_DailyAttendanceReport",columnNames = { "WorkDate","EmployeeCode" } ) } )
public class DailyAttendanceReport extends BaseEntity {

    @NotNull
    @Column(name = "WorkDate",nullable = false)
    private Date workDate;

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @Size(max = 20)
    @Column(name = "PunchCardNo")
    private String punchCardNo;

    @Size(max = 64)
    @Column(name = "EmployeeName")
    private String employeeName;

    @Size(max = 15)
    @Column(name = "EmployeeStatus")
    private String employeeStatus;

    @Column(name = "DOJ")
    private Date doj;

    @Size(max = 24)
    @Column(name = "Department")
    private String department;

    @Size(max = 24)
    @Column(name = "Section")
    private String section;

    @Size(max = 60)
    @Column(name = "Designation")
    private String designation;

    @Size(max = 16)
    @Column(name = "Unit")
    private String unit;

    @Size(max = 16)
    @Column(name = "Floor")
    private String floor;

    @Size(max = 16)
    @Column(name = "Line")
    private String line;

    @Size(max = 16)
    @Column(name = "StaffCategory")
    private String staffCategory;

    @Size(max = 20)
    @Column(name = "ShiftID")
    private String shiftID;

    @Size(max = 20)
    @Column(name = "ShiftType")
    private String shiftType;

    @Column(name = "ShiftInTime")
    private String shiftInTime;

    @Column(name = "ShiftOutTime")
    private String shiftOutTime;

    @Column(name = "shiftOutTimeEndMargin")
    private String shiftOutTimeEndMargin;

    @Column(name = "punchInTime")
    private Date punchInTime;

    @Column(name = "PunchOutTime")
    private Date punchOutTime;

    @Column(name = "WorkingHour")
    private float workingHour;

    @Column(name = "OTHour")
    private float otHour;

    @Size(max = 20)
    @Column(name = "Late")
    private String late;

    @Column(name = "LateCountInMinute",nullable = false, columnDefinition = "INT CONSTRAINT DF_DailyAttendanceReport_LateCountMint DEFAULT 0")
    private int lateCountInMinute;

    /*
    @Size(max = 20)
    @Column(name = "Leave")
    private String leave;
   */

    @Size(max = 20)
    @Column(name = "DayStatus")
    private String dayStatus;

    @Column(name = "DateApproved")
    private Date dateApproved;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Size(max = 1000)
    @Column(name = "Remarks")
    private String remarks;

    @NotNull
    @Column(name = "IsProcessCompleted",nullable = false, columnDefinition = "BIT CONSTRAINT DF_DailyAttendanceReport_IsProcessCompleted DEFAULT 0")
    private boolean isProcessCompleted;

    @NotNull
    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(@NotNull Date workDate) {
        this.workDate = workDate;
    }

    @NotNull
    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(@NotNull String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPunchCardNo() {
        return punchCardNo;
    }

    public void setPunchCardNo(String punchCardNo) {
        this.punchCardNo = punchCardNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
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

    public String getShiftInTime() {
        return shiftInTime;
    }

    public void setShiftInTime(String shiftInTime) {
        this.shiftInTime = shiftInTime;
    }

    public String getShiftOutTime() {
        return shiftOutTime;
    }

    public void setShiftOutTime(String shiftOutTime) {
        this.shiftOutTime = shiftOutTime;
    }

    public String getShiftOutTimeEndMargin() {
        return shiftOutTimeEndMargin;
    }

    public void setShiftOutTimeEndMargin(String shiftOutTimeEndMargin) {
        this.shiftOutTimeEndMargin = shiftOutTimeEndMargin;
    }

    public Date getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(Date punchInTime) {
        this.punchInTime = punchInTime;
    }

    public Date getPunchOutTime() {
        return punchOutTime;
    }

    public void setPunchOutTime(Date punchOutTime) {
        this.punchOutTime = punchOutTime;
    }

    public float getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(float workingHour) {
        this.workingHour = workingHour;
    }

    public float getOtHour() {
        return otHour;
    }

    public void setOtHour(float otHour) {
        this.otHour = otHour;
    }

    public String getLate() {
        return late;
    }

    public void setLate(String late) {
        this.late = late;
    }

    public int getLateCountInMinute() {
        return lateCountInMinute;
    }

    public void setLateCountInMinute(int lateCountInMinute) {
        this.lateCountInMinute = lateCountInMinute;
    }

    /*
    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }
    */

    public String getDayStatus() {
        return dayStatus;
    }

    public void setDayStatus(String dayStatus) {
        this.dayStatus = dayStatus;
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

    public boolean isProcessCompleted() {
        return isProcessCompleted;
    }

    public void setProcessCompleted(boolean processCompleted) {
        isProcessCompleted = processCompleted;
    }

    public DailyAttendanceReport(){

    }

    public DailyAttendanceReport(EmployeeReport emp, ShiftPlan plan, Date workDate,Date punchInTime, Date punchOutTime,
                                 String dayType, String transactionID) {
        this.employeeCode = emp.getEmployeeCode();
        this.punchCardNo = emp.getPunchCardNo();
        this.employeeName = emp.getEmployeeName();
        this.doj = emp.getDoj();
        this.department = emp.getDepartment();
        this.section = emp.getSection();
        this.designation = emp.getDesignation();
        this.unit = emp.getUnit();
        this.floor = emp.getFloor();
        this.line = emp.getLine();
        this.staffCategory = emp.getStaffCategory();
        this.shiftID = emp.getShiftID();
        this.shiftType = emp.getShiftID();

        this.workDate = workDate;
        this.punchInTime = punchInTime;
        this.punchOutTime = punchOutTime;

        this.shiftInTime = plan.getInTime();
        this.shiftOutTime = plan.getOutTime();
        this.shiftOutTimeEndMargin = plan.getOutTimeEndMargin();
        this.workingHour = plan.getWorkingHour().floatValue();

        this.otHour = getOTHour(punchInTime, punchOutTime,workDate,plan.getOutTime());

        this.lateCountInMinute = getLateCountInMinute(punchInTime,workDate,plan.getInTime());
        this.late = this.lateCountInMinute > 0 ? "L" : null;


        String dayStatus =null;
        if(this.getPunchInTime().compareTo(this.getPunchOutTime()) < 0 && this.getPunchInTime().compareTo(this.getWorkDate()) >0 )
            dayStatus = "P";
        else if(dayType != "")
            dayStatus = dayType;
        else if (transactionID != null)
            dayStatus ="LV";
        else
            dayStatus = "A";

        this.dayStatus = dayStatus;
        this.isProcessCompleted = true;

    }
    private int getOTHour(Date punchInTime,Date punchOutTime,Date workDate , String time){
        int otHour = 0;
        if(punchInTime != null && punchOutTime != null )
            try {
                if(punchInTime.compareTo(workDate) != 0 ) {
                    long seconds = (punchOutTime.getTime() - DateUtils.getDateTime(workDate, time).getTime()) / 1000;
                    otHour = (int) (seconds / 3600);
                }
            } catch (Exception e){
                // e.printStackTrace();
            }
        return otHour;
    }
    private int getLateCountInMinute(Date punchInTime,Date workDate  , String time){
        int lateMinutes = 0;
        try {
            if(punchInTime.compareTo(workDate) != 0 ) {
                long seconds = (punchInTime.getTime() - DateUtils.getDateTime(workDate, time).getTime()) / 1000;
                lateMinutes = (int) (seconds / 60);
            }
        } catch (Exception e){
            //  e.printStackTrace();
        }
        return lateMinutes;
    }


}
