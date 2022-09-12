package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity(name = "EmployeeOfficeInfo")
@Table(name = "EmployeeOfficeInfo")
public class EmployeeOfficeInfo extends BaseEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeOfficeInfo_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 32)
    @Column(name = "Position")
    private String position;

    @Size(max = 32)
    @Column(name = "PositionName")
    private String positionName;

    @Size(max = 32)
    @Column(name = "GivenDesignation")
    private String givenDesignation;

    @Size(max = 10)
    @Column(name = "Unit")
    private String unit;

    @Size(max = 64)
    @Column(name = "Division")
    private String division;

    @Size(max = 64)
    @Column(name = "Department")
    private String department;

    @Size(max = 32)
    @Column(name = "Designation")
    private String designation;

    @Size(max = 64)
    @Column(name = "Section")
    private String section;

    @Size(max = 64)
    @Column(name = "SubSection")
    private String subSection;

    @Size(max = 64)
    @Column(name = "StaffCategory")
    private String staffCategory;

    @Size(max = 64)
    @Column(name = "JobLocation")
    private String jobLocation;

    @Size(max = 64)
    @Column(name = "SkillCategoryCode")
    private String skillCategoryName;

    @Size(max = 64)
    @Column(name = "OperationCode")
    private String operationCode;

    @Column(name = "DOJ")
    private Date doj;

    @Column(name = "DOC")
    private Date doc;

    @Column(name = "DOS")
    private Date dos;

    @Size(max = 32)
    @Column(name = "GovtDesignation")
    private String govtDesignation;

    @Size(max = 256)
    @Column(name = "CostCenter")
    private String costCenter;

    @Size(max = 256)
    @Column(name = "BioRegNo")
    private String bioRegNo;

    @Column(name = "IsOT",columnDefinition = "BIT DEFAULT 0")
    private boolean isOT;

    @Column(name = "OTEntitledDate")
    private Date otEntitledDate;

    @Column(name = "IsOffDayOT",columnDefinition = "BIT DEFAULT 0")
    private boolean isOffDayOT;

    @Column(name = "isHolidayBonus",columnDefinition = "BIT DEFAULT 0")
    private boolean isHolidayBonus;

    @Column(name = "IsPF",columnDefinition = "BIT DEFAULT 0")
    private boolean isPF;

    @Column(name = "PFEntitledDate")
    private Date pfEntitledDate;

    @Size(max = 20)
    @Column(name = "PFAccNo")
    private String pfAccNo;

    @Column(name = "IsInsuranceEntitled",columnDefinition = "BIT DEFAULT 0")
    private boolean isInsuranceEntitled;


    @Size(max = 256)
    @Column(name = "InsuranceCompany")
    private String insuranceCompany;


    @Size(max = 64)
    @Column(name = "InsuranceAccount")
    private String insuranceAccount;

    @Column(name = "IsConsiderServiceLength",columnDefinition = "BIT DEFAULT 0")
    private boolean isConsiderServiceLength;

    @Column(name = "ServiceLength",columnDefinition = "INT DEFAULT 0")
    private int serviceLength;

    @Size(max = 8)
    @Column(name = "YearMonth")
    private String yearMonth;

    @Column(name = "IsActiveSelfService",columnDefinition = "BIT DEFAULT 0")
    private boolean isActiveSelfService;

    @Size(max = 30)
    @Column(name = "Password")
    private String password;

    @Size(max = 256)
    @Column(name = "SpecialMedicalNote")
    private String specialMedicalNote;

    @Size(max = 64)
    @Column(name = "AdminReportingPerson")
    private String adminReportingPerson;

    @Size(max = 64)
    @Column(name = "FunctionalReportingPerson")
    private String functionalReportingPerson;


    @Size(max = 10)
    @Column(name = "Line")
    private String line;

    @Size(max = 10)
    @Column(name = "Floor")
    private String floor;

    @Size(max = 10)
    @Column(name = "Grade")
    private String grade;


    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getGivenDesignation() {
        return givenDesignation;
    }

    public void setGivenDesignation(String givenDesignation) {
        this.givenDesignation = givenDesignation;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
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

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getSkillCategoryName() {
        return skillCategoryName;
    }

    public void setSkillCategoryName(String skillCategoryName) {
        this.skillCategoryName = skillCategoryName;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
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

    public String getGovtDesignation() {
        return govtDesignation;
    }

    public void setGovtDesignation(String govtDesignation) {
        this.govtDesignation = govtDesignation;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getBioRegNo() {
        return bioRegNo;
    }

    public void setBioRegNo(String bioRegNo) {
        this.bioRegNo = bioRegNo;
    }

    public boolean isOT() {
        return isOT;
    }

    public void setOT(boolean OT) {
        isOT = OT;
    }

    public Date getOtEntitledDate() {
        return otEntitledDate;
    }

    public void setOtEntitledDate(Date otEntitledDate) {
        this.otEntitledDate = otEntitledDate;
    }

    public boolean isOffDayOT() {
        return isOffDayOT;
    }

    public void setOffDayOT(boolean offDayOT) {
        isOffDayOT = offDayOT;
    }

    public boolean isHolidayBonus() {
        return isHolidayBonus;
    }

    public void setHolidayBonus(boolean isHolidayBonus) {
        this.isHolidayBonus = isHolidayBonus;
    }

    public boolean isPF() {
        return isPF;
    }

    public void setPF(boolean PF) {
        isPF = PF;
    }

    public Date getPfEntitledDate() {
        return pfEntitledDate;
    }

    public void setPfEntitledDate(Date pfEntitledDate) {
        this.pfEntitledDate = pfEntitledDate;
    }

    public String getPfAccNo() {
        return pfAccNo;
    }

    public void setPfAccNo(String pfAccNo) {
        this.pfAccNo = pfAccNo;
    }

    public boolean isInsuranceEntitled() {
        return isInsuranceEntitled;
    }

    public void setInsuranceEntitled(boolean insuranceEntitled) {
        isInsuranceEntitled = insuranceEntitled;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getInsuranceAccount() {
        return insuranceAccount;
    }

    public void setInsuranceAccount(String insuranceAccount) {
        this.insuranceAccount = insuranceAccount;
    }

    public boolean isConsiderServiceLength() {
        return isConsiderServiceLength;
    }

    public void setConsiderServiceLength(boolean considerServiceLength) {
        isConsiderServiceLength = considerServiceLength;
    }

    public int getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(int serviceLength) {
        this.serviceLength = serviceLength;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public boolean isActiveSelfService() {
        return isActiveSelfService;
    }

    public void setActiveSelfService(boolean activeSelfService) {
        isActiveSelfService = activeSelfService;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpecialMedicalNote() {
        return specialMedicalNote;
    }

    public void setSpecialMedicalNote(String specialMedicalNote) {
        this.specialMedicalNote = specialMedicalNote;
    }

    public String getAdminReportingPerson() {
        return adminReportingPerson;
    }

    public void setAdminReportingPerson(String adminReportingPerson) {
        this.adminReportingPerson = adminReportingPerson;
    }

    public String getFunctionalReportingPerson() {
        return functionalReportingPerson;
    }

    public void setFunctionalReportingPerson(String functionalReportingPerson) {
        this.functionalReportingPerson = functionalReportingPerson;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
