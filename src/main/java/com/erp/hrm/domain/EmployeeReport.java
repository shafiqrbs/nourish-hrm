package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table( name = "EmployeeReport", uniqueConstraints = { @UniqueConstraint( name="UK_EmployeeReport",columnNames = { "EmployeeCode" } ) } )
public class EmployeeReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", columnDefinition = "BIGINT")
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @Size(max = 20)
    @Column(name = "DisplayEmployeeCode")
    private String displayEmployeeCode;

    @Size(max = 20)
    @Column(name = "PunchCardNo")
    private String punchCardNo;

    @Size(max = 256)
    @Column(name = "EmployeeName")
    private String employeeName;

    @Size(max = 10)
    @Column(name = "Salutation")
    private String salutation;

    @Size(max = 64)
    @Column(name = "FirstName")
    private String firstName;

    @Size(max = 64)
    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DOJ")
    private Date doj;

    @Column(name = "DOC")
    private Date doc;

    @Column(name = "DOS")
    private Date dos;

    @Column(name = "DOB")
    private Date dob;

    @Size(max = 24)
    @Column(name = "Email")
    private String email;

    @Size(max = 10)
    @Column(name = "Gender")
    private String gender;

    @Size(max = 512)
    @Column(name = "PresentAddress")
    private String presentAddress;

    @Size(max = 512)
    @Column(name = "PermanentAddress")
    private String permanentAddress;

    @Size(max = 20)
    @Column(name = "Nationality")
    private String nationality;

    @Size(max = 10)
    @Column(name = "MaritalStatus")
    private String maritalStatus;

    @Size(max = 10)
    @Column(name = "EmployeeType")
    private String employeeType;

    @Size(max = 10)
    @Column(name = "BloodGroup")
    private String bloodGroup;

    @Size(max = 50)
    @Column(name = "Religion")
    private String religion;

    @Size(max = 10)
    @Column(name = "LeaveRuleID")
    private String leaveRuleID;

    @Size(max = 10)
    @Column(name = "MaternityLeaveRuleID")
    private String maternityLeaveRuleID;

    @Size(max = 20)
    @Column(name = "ShiftID")
    private String shiftID;

    @Size(max = 15)
    @Column(name = "EmployeeStatus")
    private String employeeStatus;

    @Size(max = 50)
    @Column(name = "Unit")
    private String unit;

    @Size(max = 50)
    @Column(name = "Section")
    private String section;

    @Size(max = 50)
    @Column(name = "SubSection")
    private String subSection;

    @Size(max = 50)
    @Column(name = "Floor")
    private String floor;

    @Size(max = 50)
    @Column(name = "Line")
    private String line;

    @Size(max = 50)
    @Column(name = "Department")
    private String department;

    @Size(max = 50)
    @Column(name = "Designation")
    private String designation;

    @Size(max = 50)
    @Column(name = "StaffCategory")
    private String staffCategory;

    @Size(max = 50)
    @Column(name = "Grade")
    private String grade;

    @Size(max = 50)
    @Column(name = "Country")
    private String country;

    @Column(name = "GrossSalary")
    private float grossSalary;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Date getDoc() {
        return doc;
    }

    public void setDoc(Date doc) {
        this.doc = doc;
    }

    public Date getDos() {
        return dos;
    }

    public void setDos(Date dos) {
        this.dos = dos;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getLeaveRuleID() {
        return leaveRuleID;
    }

    public void setLeaveRuleID(String leaveRuleID) {
        this.leaveRuleID = leaveRuleID;
    }

    public String getMaternityLeaveRuleID() {
        return maternityLeaveRuleID;
    }

    public void setMaternityLeaveRuleID(String maternityLeaveRuleID) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
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

    public String getSubSection() {
        return subSection;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(float grossSalary) {
        this.grossSalary = grossSalary;
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

    public EmployeeReport() {
    }

    public EmployeeReport(String employeeCode,String displayEmployeeCode,String punchCardNo,
                          String salutation,String firstName,String lastName,
                          Date dob,String email,String gender,String presentAddress,
                          String permanentAddress,String nationality,String maritalStatus,
                          String employeeType,String bloodGroup,String religion,
                          String employeeStatus,String country,Date doj,Date doc,Date dos,
                          String unit,String section,String subSection,String floor,
                          String line,String department,String designation,String staffCategory,
                          String grade,String leaveRuleID,String maternityLeaveRuleID,String shiftID,float grossSalary) {
        this.employeeCode = employeeCode;
        this.displayEmployeeCode = displayEmployeeCode;
        this.punchCardNo = punchCardNo;
        this.employeeName =  generateEmployeeName(salutation,firstName);
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.presentAddress = presentAddress;
        this.permanentAddress = permanentAddress;
        this.nationality = nationality;
        this.maritalStatus = maritalStatus;
        this.employeeType = employeeType;
        this.bloodGroup = bloodGroup;
        this.religion = religion;
        this.employeeStatus = employeeStatus;
        this.country = country;

        this.doj = doj;
        this.doc = doc;
        this.dos = dos;
        this.unit = unit;
        this.section = section;
        this.subSection = subSection;
        this.floor = floor;
        this.line = line;
        this.department = department;
        this.designation = designation;
        this.staffCategory = staffCategory;
        this.grade = grade;

        this.leaveRuleID = leaveRuleID;
        this.maternityLeaveRuleID = maternityLeaveRuleID;
        this.shiftID = shiftID;

        this.grossSalary = grossSalary;

        this.setUpdatedDate(Calendar.getInstance().getTime());
    }

    private String generateEmployeeName(String salutation, String firstName) {
        String name = (salutation == null || salutation == "") ?"" : salutation + " " ;
        name += firstName;
        return name;
    }
}

