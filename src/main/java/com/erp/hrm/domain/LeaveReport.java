package com.erp.hrm.domain;

import com.erp.hrm.util.DateUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table( name = "LeaveReport", uniqueConstraints = { @UniqueConstraint( name="UK_LeaveReport",columnNames = { "TransactionID" } ) } )
public class LeaveReport extends BaseEntity  {

    @Size(max = 50)
    @NotNull
    @Column(name = "TransactionID",nullable = false)
    private String transactionID;

    @NotNull
    @Column(name = "TransactionDate")
    private Date transactionDate;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeavePolicyID",nullable = false)
    private String leavePolicyID;

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @NotNull
    @Size(max = 64)
    @Column(name = "EmployeeName")
    private String employeeName;

    @Size(max = 20)
    @Column(name = "PunchCardNo")
    private String punchCardNo;

    @Size(max = 16)
    @Column(name = "Unit")
    private String unit;

    @Size(max = 24)
    @Column(name = "Section")
    private String section;

    @Size(max = 16)
    @Column(name = "Floor")
    private String floor;

    @Size(max = 16)
    @Column(name = "Line")
    private String line;

    @Size(max = 24)
    @Column(name = "Department")
    private String department;

    @Size(max = 60)
    @Column(name = "Designation")
    private String designation;

    @Size(max = 16)
    @Column(name = "StaffCategory")
    private String staffCategory;

    @Size(max = 6)
    @Column(name = "LeaveType")
    private String leaveType;

    @Size(max = 64)
    @Column(name = "LeaveDescription")
    private String leaveDescription;

    @NotNull
    @Column(name = "LeaveFromDate")
    private Date leaveFromDate;

    @NotNull
    @Column(name = "LeaveToDate")
    private Date leaveToDate;

    @NotNull
    @Column(name = "TotalDays")
    private int totalDays;

    @Size(max = 256)
    @Column(name = "LeaveReason")
    private String leaveReason;

    @Size(max = 64)
    @Column(name = "ServiceLength")
    private String serviceLength;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Column(name = "DateApproved")
    private Date dateApproved;

    @Size(max = 20)
    @Column(name = "AddedBy", length = 20)
    private String AddedBy;

    @Column(name = "DateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateAdded;

    @Size(max = 20)
    @Column(name = "UpdatedBy", length = 20)
    private String UpdatedBy;

    @Column(name = "UpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdatedDate;

    public LeaveReport() {
    }

    public LeaveReport(String transactionID, Date transactionDate, String leavePolicyID, String employeeCode, String employeeName, String punchCardNo, String unit, String section, String floor, String line, String department, String designation, String staffCategory, String leaveType, String leaveDescription, Date leaveFromDate, Date leaveToDate, int totalDays, String leaveReason, String serviceLength, String approvedBy, Date dateApproved, String addedBy, Date dateAdded, String updatedBy, Date updatedDate) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.leavePolicyID = leavePolicyID;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.punchCardNo = punchCardNo;
        this.unit = unit;
        this.section = section;
        this.floor = floor;
        this.line = line;
        this.department = department;
        this.designation = designation;
        this.staffCategory = staffCategory;
        this.leaveType = leaveType;
        this.leaveDescription = leaveDescription;
        this.leaveFromDate = leaveFromDate;
        this.leaveToDate = leaveToDate;
        this.totalDays = totalDays;
        this.leaveReason = leaveReason;
        this.serviceLength = serviceLength;
        this.approvedBy = approvedBy;
        this.dateApproved = dateApproved;
        AddedBy = addedBy;
        DateAdded = dateAdded;
        UpdatedBy = updatedBy;
        UpdatedDate = updatedDate;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getLeavePolicyID() {
        return leavePolicyID;
    }

    public void setLeavePolicyID(String leavePolicyID) {
        this.leavePolicyID = leavePolicyID;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPunchCardNo() {
        return punchCardNo;
    }

    public void setPunchCardNo(String punchCardNo) {
        this.punchCardNo = punchCardNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveDescription() {
        return leaveDescription;
    }

    public void setLeaveDescription(String leaveDescription) {
        this.leaveDescription = leaveDescription;
    }

    public Date getLeaveFromDate() {
        return leaveFromDate;
    }

    public void setLeaveFromDate(Date leaveFromDate) {
        this.leaveFromDate = leaveFromDate;
    }

    public Date getLeaveToDate() {
        return leaveToDate;
    }

    public void setLeaveToDate(Date leaveToDate) {
        this.leaveToDate = leaveToDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(String serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(String addedBy) {
        AddedBy = addedBy;
    }

    public Date getDateAdded() {
        return DateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        DateAdded = dateAdded;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        UpdatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }


    public LeaveReport(String employeeCode,
                       String employeeName,
                       String punchCardNo,
                       String unit,
                       String section,
                       String floor,
                       String line,
                       String department,
                       String designation,
                       String staffCategory,
                       Date doj,
                       String transactionID,
                       Date transactionDate,
                       Date leaveFromDate,
                       Date leaveToDate,
                       double totalDays,
                       String leaveReason,
                       String leavePolicyID,
                       String leaveType,
                       String leaveDescription) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.punchCardNo = punchCardNo;
        this.unit = unit;
        this.section = section;
        this.floor = floor;
        this.line = line;
        this.department = department;
        this.designation = designation;
        this.staffCategory = staffCategory;

        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.leaveFromDate = leaveFromDate;
        this.leaveToDate = leaveToDate;
        this.totalDays = (int) totalDays;
        this.leaveReason = leaveReason;

        this.leavePolicyID = leavePolicyID;
        this.leaveType = leaveType;
        this.leaveDescription = leaveDescription;
        this.serviceLength = generateServiceLength(doj, leaveFromDate);

    }

    private String generateServiceLength(Date doj, Date leaveDate) {
        String serviceLength="";
        int [] dateDiff = DateUtils.getDateDiffrece(doj,leaveDate);
        serviceLength += dateDiff[0];
        serviceLength += " Years ";
        serviceLength += dateDiff[1];
        serviceLength += " Months ";
        serviceLength += dateDiff[2];
        serviceLength += " Days ";

        return serviceLength;
    }
}

