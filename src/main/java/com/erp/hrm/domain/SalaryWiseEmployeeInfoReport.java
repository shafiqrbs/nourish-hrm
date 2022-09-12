package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table( name = "SalaryWiseEmployeeInfoReport", uniqueConstraints = { @UniqueConstraint( name="UK_SalaryWiseEmpInfo",columnNames = { "EmployeeCode", "SalaryProcID" } ) } )
public class SalaryWiseEmployeeInfoReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id", columnDefinition = "BIGINT")
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryProcID",nullable = false)
    private String salaryProcID;

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;


    @Size(max = 20)
    @Column(name = "PunchCardNo")
    private String punchCardNo;

    @Size(max = 256)
    @Column(name = "EmployeeName")
    private String employeeName;

    @Size(max = 10)
    @Column(name = "Saluation")
    private String saluation;

    @Size(max = 250)
    @Column(name = "FirstName")
    private String firstName;

    @Size(max = 250)
    @Column(name = "LastName")
    private String lastName;

    @Column(name = "DOJ")
    private Date doj;

    @Column(name = "DOC")
    private Date doc;

    @Column(name = "DOB")
    private Date dob;

    @Size(max = 100)
    @Column(name = "Email")
    private String email;

    @Size(max = 10)
    @Column(name = "Gender")
    private String gender;

    @Size(max = 512)
    @Column(name = "PresentAddress")
    private String presentAddress;

    @Size(max = 20)
    @Column(name = "PresentZipCode")
    private String presentZipCode;

    @Size(max = 512)
    @Column(name = "PermanentAddress")
    private String permanentAddress;

    @Size(max = 50)
    @Column(name = "PermanentZipCode")
    private String permanentZipCode;

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

    @Size(max = 10)
    @Column(name = "Religion")
    private String religion;

    @Size(max = 10)
    @Column(name = "EmployeeState")
    private String employeeState;

    @Size(max = 20)
    @Column(name = "WorkerType")
    private String workerType;

    @Size(max = 20)
    @Column(name = "AttendancePaymentName")
    private String attendancePaymentName;

    @Size(max = 20)
    @Column(name = "SalaryRuleCode")
    private String salaryRuleCode;

    @Size(max = 10)
    @Column(name = "LeaveRuleID")
    private String leaveRuleID;

    @Size(max = 10)
    @Column(name = "MaternityLeaveRuleID")
    private String maternityLeaveRuleID;

    @Size(max = 20)
    @Column(name = "ShiftID")
    private String shiftID;

    @Size(max = 20)
    @Column(name = "ShiftRuleCode")
    private String shiftRuleCode;

    @Column(name = "ShiftStartDate")
    private Date ShiftStartDate;

    @Size(max = 15)
    @Column(name = "EmployeeStatus")
    private String employeeStatus;

    @Column(name = "TransactionEffective")
    private boolean transactionEffective;

    @Size(max = 50)
    @Column(name = "Unit")
    private String unit;

    @Size(max = 50)
    @Column(name = "Department")
    private String department;

    @Size(max = 50)
    @Column(name = "GradeInfo")
    private String gradeInfo;

    @Size(max = 50)
    @Column(name = "Country")
    private String country;

    @Size(max = 50)
    @Column(name = "City")
    private String City;

    @Size(max = 50)
    @Column(name = "Designation")
    private String designation;

    @Size(max = 50)
    @Column(name = "StaffCategory")
    private String staffCategory;

    @Size(max = 50)
    @Column(name = "SectionInfo")
    private String sectionInfo;

    @Size(max = 50)
    @Column(name = "LineInfo")
    private String lineInfo;

    @Size(max = 50)
    @Column(name = "FloorInfo")
    private String floorInfo;

    @Size(max = 50)
    @Column(name = "SubSection")
    private String subSection;

    @Size(max = 50)
    @Column(name = "TinNumber")
    private String tinNumber;

    @Size(max = 50)
    @Column(name = "BankName")
    private String bankName;

    @Size(max = 50)
    @Column(name = "BankAccNo")
    private String bankAccNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSalaryProcID() {
        return salaryProcID;
    }

    public void setSalaryProcID(String salaryProcID) {
        this.salaryProcID = salaryProcID;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
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

    public String getSaluation() {
        return saluation;
    }

    public void setSaluation(String saluation) {
        this.saluation = saluation;
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

    public String getPresentZipCode() {
        return presentZipCode;
    }

    public void setPresentZipCode(String presentZipCode) {
        this.presentZipCode = presentZipCode;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentZipCode() {
        return permanentZipCode;
    }

    public void setPermanentZipCode(String permanentZipCode) {
        this.permanentZipCode = permanentZipCode;
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

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public String getWorkerType() {
        return workerType;
    }

    public void setWorkerType(String workerType) {
        this.workerType = workerType;
    }

    public String getAttendancePaymentName() {
        return attendancePaymentName;
    }

    public void setAttendancePaymentName(String attendancePaymentName) {
        this.attendancePaymentName = attendancePaymentName;
    }

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
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

    public String getShiftRuleCode() {
        return shiftRuleCode;
    }

    public void setShiftRuleCode(String shiftRuleCode) {
        this.shiftRuleCode = shiftRuleCode;
    }

    public Date getShiftStartDate() {
        return ShiftStartDate;
    }

    public void setShiftStartDate(Date shiftStartDate) {
        ShiftStartDate = shiftStartDate;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public boolean isTransactionEffective() {
        return transactionEffective;
    }

    public void setTransactionEffective(boolean transactionEffective) {
        this.transactionEffective = transactionEffective;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGradeInfo() {
        return gradeInfo;
    }

    public void setGradeInfo(String gradeInfo) {
        this.gradeInfo = gradeInfo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
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

    public String getSectionInfo() {
        return sectionInfo;
    }

    public void setSectionInfo(String sectionInfo) {
        this.sectionInfo = sectionInfo;
    }

    public String getLineInfo() {
        return lineInfo;
    }

    public void setLineInfo(String lineInfo) {
        this.lineInfo = lineInfo;
    }

    public String getFloorInfo() {
        return floorInfo;
    }

    public void setFloorInfo(String floorInfo) {
        this.floorInfo = floorInfo;
    }

    public String getSubSection() {
        return subSection;
    }

    public void setSubSection(String subSection) {
        this.subSection = subSection;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccNo() {
        return bankAccNo;
    }

    public void setBankAccNo(String bankAccNo) {
        this.bankAccNo = bankAccNo;
    }

    public SalaryWiseEmployeeInfoReport() {
    }

    public SalaryWiseEmployeeInfoReport( @NotNull String employeeCode, @NotNull String salaryProcID, EmployeeReport er,String permanentZipCode, String presentZipCode,
                                        String employeeState, String attendancePaymentName, String salaryRuleCode,
                                        String shiftRuleCode, boolean transactionEffective,
                                        String city, String tinNumber, String bankName, String bankAccNo) {
        this.salaryProcID = salaryProcID;
        this.employeeCode = employeeCode;
        this.punchCardNo = er.getPunchCardNo();
        this.employeeName = er.getEmployeeName();
        this.saluation = er.getSalutation();
        this.firstName = er.getFirstName();
        this.lastName = er.getLastName();
        this.doj = er.getDoj();
        this.doc = er.getDoc();
        this.dob = er.getDob();
        this.email = er.getEmail();
        this.gender = er.getGender();
        this.presentAddress = er.getPresentAddress();
        this.presentZipCode = presentZipCode;
        this.permanentAddress = er.getPermanentAddress();
        this.permanentZipCode = permanentZipCode;
        this.nationality = er.getNationality();
        this.maritalStatus = er.getMaritalStatus();
        this.employeeType = er.getEmployeeType();
        this.bloodGroup = er.getBloodGroup();
        this.religion = er.getReligion();
        this.employeeState = employeeState;
        this.workerType = er.getEmployeeType();
        this.attendancePaymentName = attendancePaymentName;
        this.salaryRuleCode = salaryRuleCode;
        this.leaveRuleID = er.getLeaveRuleID();
        this.maternityLeaveRuleID = er.getMaternityLeaveRuleID();
        this.shiftID = er.getShiftID();
        this.shiftRuleCode = shiftRuleCode;
        ShiftStartDate = null; //shiftStartDate;
        this.employeeStatus = er.getEmployeeStatus();
        this.transactionEffective = transactionEffective;
        this.unit = er.getUnit();
        this.department = er.getDepartment();
        this.gradeInfo = er.getGrade();
        this.country = er.getCountry();
        this.City = city;
        this.designation = er.getDesignation();
        this.staffCategory = er.getStaffCategory();
        this.sectionInfo = er.getSection();
        this.lineInfo = er.getLine();
        this.floorInfo = er.getFloor();
        this.subSection = er.getSubSection();
        this.tinNumber = tinNumber;
        this.bankName = bankName;
        this.bankAccNo = bankAccNo;
    }

}

