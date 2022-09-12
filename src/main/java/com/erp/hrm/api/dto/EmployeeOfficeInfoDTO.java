package com.erp.hrm.api.dto;
import java.util.Date;

public class EmployeeOfficeInfoDTO {

    private Long id;
    private String employeeCode;
    private String position;
    private String positionName;
    private String givenDesignation;
    private String unit;
    private String division;
    private String department;
    private String designation;
    private String section;
    private String subSection;
    private String staffCategory;
    private String jobLocation;
    private String skillCategoryName;
    private String operationCode;
    private Date doj;
    private Date dos;
    private Date doc;
    private String govtDesignation;
    private String costCenter;
    private String bioRegNo;
    private boolean isOT;
    private Date otEntitledDate;
    private boolean isOffDayOT;
    private boolean isHolidayBonus;
    private boolean isPF;
    private Date pfEntitledDate;
    private String pfAccNo;
    private boolean isInsuranceEntitled;
    private String insuranceCompany;
    private String insuranceAccount;
    private boolean isConsiderServiceLength;
    private int serviceLength;
    private String yearMonth;
    private boolean isActiveSelfService;
    private String password;
    private String specialMedicalNote;
    private String adminReportingPerson;
    private String functionalReportingPerson;

    public EmployeeOfficeInfoDTO() {
    }

    public EmployeeOfficeInfoDTO(Long id, String employeeCode, String position, String positionName, String givenDesignation, String unit, String division, String department, String designation, String section, String subSection, String staffCategory, String jobLocation, String skillCategoryName, String operationCode, Date doj, Date dos, Date doc, String govtDesignation, String costCenter, String bioRegNo, boolean isOT, Date otEntitledDate, boolean isOffDayOT, boolean isHolidayBonus, boolean isPF, Date pfEntitledDate, String pfAccNo, boolean isInsuranceEntitled, String insuranceCompany, String insuranceAccount, boolean isConsiderServiceLength, int serviceLength, String yearMonth, boolean isActiveSelfService, String password, String specialMedicalNote, String adminReportingPerson, String functionalReportingPerson) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.position = position;
        this.positionName = positionName;
        this.givenDesignation = givenDesignation;
        this.unit = unit;
        this.division = division;
        this.department = department;
        this.designation = designation;
        this.section = section;
        this.subSection = subSection;
        this.staffCategory = staffCategory;
        this.jobLocation = jobLocation;
        this.skillCategoryName = skillCategoryName;
        this.operationCode = operationCode;
        this.doj = doj;
        this.dos = dos;
        this.doc = doc;
        this.govtDesignation = govtDesignation;
        this.costCenter = costCenter;
        this.bioRegNo = bioRegNo;
        this.isOT = isOT;
        this.otEntitledDate = otEntitledDate;
        this.isOffDayOT = isOffDayOT;
        this.isHolidayBonus = isHolidayBonus;
        this.isPF = isPF;
        this.pfEntitledDate = pfEntitledDate;
        this.pfAccNo = pfAccNo;
        this.isInsuranceEntitled = isInsuranceEntitled;
        this.insuranceCompany = insuranceCompany;
        this.insuranceAccount = insuranceAccount;
        this.isConsiderServiceLength = isConsiderServiceLength;
        this.serviceLength = serviceLength;
        this.yearMonth = yearMonth;
        this.isActiveSelfService = isActiveSelfService;
        this.password = password;
        this.specialMedicalNote = specialMedicalNote;
        this.adminReportingPerson = adminReportingPerson;
        this.functionalReportingPerson = functionalReportingPerson;
    }

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

    public Date getDos() {
        return dos;
    }

    public void setDos(Date dos) {
        this.dos = dos;
    }

    public Date getDoc() {
        return doc;
    }

    public void setDoc(Date doc) {
        this.doc = doc;
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

    public boolean getIsOT() {
        return isOT;
    }

    public void setIsOT(boolean isOT) {
        this.isOT = isOT;
    }

    public Date getIsOtEntitledDate() {
        return otEntitledDate;
    }

    public void setIsOtEntitledDate(Date isOtEntitledDate) {
        this.otEntitledDate = isOtEntitledDate;
    }

    public boolean getIsOffDayOT() {
        return isOffDayOT;
    }

    public void setIsOffDayOT(boolean isOffDayOT) {
        this.isOffDayOT = isOffDayOT;
    }

    public boolean getIsHolidayBonus() {
        return isHolidayBonus;
    }

    public void setIsHolidayBonus(boolean isHolidayBonus) {
        this.isHolidayBonus = isHolidayBonus;
    }

    public boolean getIsPF() {
        return isPF;
    }

    public void setIsPF(boolean isPF) {
        this.isPF = isPF;
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

    public boolean getIsInsuranceEntitled() {
        return isInsuranceEntitled;
    }

    public void setInsuranceEntitled(boolean isInsuranceEntitled) {
        this.isInsuranceEntitled = isInsuranceEntitled;
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
}
