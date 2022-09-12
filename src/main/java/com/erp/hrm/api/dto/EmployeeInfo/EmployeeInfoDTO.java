package com.erp.hrm.api.dto.EmployeeInfo;

import java.util.Date;

/**
 * Created by WS
 */
public class EmployeeInfoDTO {

    private String employeeCode;
    private String displayEmployeeCode;
    private String employeeType;
    private String employeeStatus;
    private String employeeImage;
    private String punchCardNo;
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String gender;
    private String nid;
    private String nationality;
    private String unit;
    private Date dateOfBirth;
    private Date dateOfJoin;
    private Date dateOfConfirmation;
    private String department;
    private String designation;
    private String staffCategory;
    private Date doc;
    private Date doj;
    private String shiftID;
    private String shiftType;
    private String shiftRuleCode;
    private String leaveRuleID;
    private String salaryRuleCode;
    private String checkInTime;
    private String checkOutTime;
    private String tiffinInTime;
    private String tiffinOutTime;
    private Date editedEntryDateTime;

    public EmployeeInfoDTO() {
    }

    public EmployeeInfoDTO(String employeeCode, String displayEmployeeCode, String employeeType,
                           String employeeStatus, String employeeImage, String punchCardNo,
                           String salutation, String firstName, String middleName, String lastName,
                           String nickName, String gender, String nid, String nationality, String unit,
                           Date dateOfBirth, Date dateOfJoin, Date dateOfConfirmation, String department,
                           String designation, String staffCategory, Date doj, Date doc, String shiftID,
                           String shiftType, String shiftRuleCode, String leaveRuleID, String salaryRuleCode,
                           String checkInTime, String checkOutTime, String tiffinInTime,
                           String tiffinOutTime,Date editedEntryDateTime) {
        this.employeeCode = employeeCode;
        this.displayEmployeeCode = displayEmployeeCode;
        this.employeeType = employeeType;
        this.employeeStatus = employeeStatus;
        this.employeeImage = employeeImage;
        this.punchCardNo = punchCardNo;
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.gender = gender;
        this.nid = nid;
        this.nationality = nationality;
        this.unit = unit;
        this.dateOfBirth = dateOfBirth;
        this.dateOfJoin = dateOfJoin;
        this.dateOfConfirmation = dateOfConfirmation;
        this.department = department;
        this.designation = designation;
        this.staffCategory = staffCategory;
        this.doj = doj;
        this.doc = doc;
        this.shiftID = shiftID;
        this.shiftType = shiftType;
        this.shiftRuleCode = shiftRuleCode;
        this.leaveRuleID = leaveRuleID;
        this.salaryRuleCode = salaryRuleCode;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.tiffinInTime = tiffinInTime;
        this.tiffinOutTime = tiffinOutTime;
        this.editedEntryDateTime = editedEntryDateTime;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDisplayEmployeeCode() {
        return displayEmployeeCode;
    }

    public void setDisplayEmployeeCode(String displayEmployeeCode) {
        this.displayEmployeeCode = displayEmployeeCode;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getPunchCardNo() {
        return punchCardNo;
    }

    public void setPunchCardNo(String punchCardNo) {
        this.punchCardNo = punchCardNo;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Date getDateOfConfirmation() {
        return dateOfConfirmation;
    }

    public void setDateOfConfirmation(Date dateOfConfirmation) {
        this.dateOfConfirmation = dateOfConfirmation;
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

    public Date getDoc() {
        return doc;
    }

    public void setDoc(Date doc) {
        this.doc = doc;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
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

    public String getShiftRuleCode() {
        return shiftRuleCode;
    }

    public void setShiftRuleCode(String shiftRuleCode) {
        this.shiftRuleCode = shiftRuleCode;
    }

    public String getLeaveRuleID() {
        return leaveRuleID;
    }

    public void setLeaveRuleID(String leaveRuleID) {
        this.leaveRuleID = leaveRuleID;
    }

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getTiffinInTime() {
        return tiffinInTime;
    }

    public void setTiffinInTime(String tiffinInTime) {
        this.tiffinInTime = tiffinInTime;
    }

    public String getTiffinOutTime() {
        return tiffinOutTime;
    }

    public void setTiffinOutTime(String tiffinOutTime) {
        this.tiffinOutTime = tiffinOutTime;
    }

    public Date getEditedEntryDateTime() {
        return editedEntryDateTime;
    }

    public void setEditedEntryDateTime(Date editedEntryDateTime) {
        this.editedEntryDateTime = editedEntryDateTime;
    }
}
