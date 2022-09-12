package com.erp.hrm.api.dto;

import java.util.Date;

public class EmployeeOfficialInfoDTO {
    private String EmployeeCode;
    private String Position;
    private String TemplateId;
    private String Unit;
    private String Department;
    private String Building;
    private String Line;
    private String Group;
    private String SubGroup;
    private String StaffCategory;
    private String SkillCategory;
    private Date DOJ;
    private String GvtDesignation;
    private String SkillSet;
    private Date DOS;
    private String PositionName;
    private String GvnDesignation;
    private String Division;
    private String Designation;
    private String Floor;
    private String Section;
    private String SubSection;
    private String JobLocation;
    private String OperationId;
    private Date DOC;

    private String CostCenter;
    private String BioRegNo;
    private boolean IsOvertime;
    private String Overtime;
    private boolean Offday;
    private boolean Holiday;
    private boolean ProvidentFund;
    private Date PFEntitledDate;
    private String AccNominee;
    private boolean Insurance;
    private String CompanyName;
    private String BranchName;
    private String InsuranceAccCo;
    private boolean ConsiderInServiceLength;
    private String ServiceLength;
    private String SpecialMedialNote;
    private String ReportingFn;
    private String ReportingAdmin;

    public boolean isOvertime() {
        return IsOvertime;
    }

    public void setOvertime(boolean overtime) {
        IsOvertime = overtime;
    }

    public String getOvertime() {
        return Overtime;
    }

    public void setOvertime(String overtime) {
        Overtime = overtime;
    }

    public boolean isOffday() {
        return Offday;
    }

    public void setOffday(boolean offday) {
        Offday = offday;
    }

    public boolean isHoliday() {
        return Holiday;
    }

    public void setHoliday(boolean holiday) {
        Holiday = holiday;
    }

    public boolean isProvidentFund() {
        return ProvidentFund;
    }

    public void setProvidentFund(boolean providentFund) {
        ProvidentFund = providentFund;
    }

    public Date getPFEntitledDate() {
        return PFEntitledDate;
    }

    public void setPFEntitledDate(Date PFEntitledDate) {
        this.PFEntitledDate = PFEntitledDate;
    }

    public String getAccNominee() {
        return AccNominee;
    }

    public void setAccNominee(String accNominee) {
        AccNominee = accNominee;
    }

    public boolean isInsurance() {
        return Insurance;
    }

    public void setInsurance(boolean insurance) {
        Insurance = insurance;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getInsuranceAccCo() {
        return InsuranceAccCo;
    }

    public void setInsuranceAccCo(String insuranceAccCo) {
        InsuranceAccCo = insuranceAccCo;
    }

    public boolean isConsiderInServiceLength() {
        return ConsiderInServiceLength;
    }

    public void setConsiderInServiceLength(boolean considerInServiceLength) {
        ConsiderInServiceLength = considerInServiceLength;
    }

    public String getServiceLength() {
        return ServiceLength;
    }

    public void setServiceLength(String serviceLength) {
        ServiceLength = serviceLength;
    }

    public String getSpecialMedialNote() {
        return SpecialMedialNote;
    }

    public void setSpecialMedialNote(String specialMedialNote) {
        SpecialMedialNote = specialMedialNote;
    }

    public String getReportingFn() {
        return ReportingFn;
    }

    public void setReportingFn(String reportingFn) {
        ReportingFn = reportingFn;
    }

    public String getReportingAdmin() {
        return ReportingAdmin;
    }

    public void setReportingAdmin(String reportingAdmin) {
        ReportingAdmin = reportingAdmin;
    }

    public EmployeeOfficialInfoDTO() {
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getTemplateId() {
        return TemplateId;
    }

    public void setTemplateId(String templateId) {
        TemplateId = templateId;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getStaffCategory() {
        return StaffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        StaffCategory = staffCategory;
    }

    public Date getDOJ() {
        return DOJ;
    }

    public void setDOJ(Date DOJ) {
        this.DOJ = DOJ;
    }

    public String getGvtDesignation() {
        return GvtDesignation;
    }

    public void setGvtDesignation(String gvtDesignation) {
        GvtDesignation = gvtDesignation;
    }

    public String getSkillSet() {
        return SkillSet;
    }

    public void setSkillSet(String skillSet) {
        this.SkillSet = skillSet;
    }

    public Date getDOS() {
        return DOS;
    }

    public void setDOS(Date DOS) {
        this.DOS = DOS;
    }

    public String getPositionName() {
        return PositionName;
    }

    public void setPositionName(String positionName) {
        this.PositionName = positionName;
    }

    public String getGvnDesignation() {
        return GvnDesignation;
    }

    public void setGvnDesignation(String gvnDesignation) {
        GvnDesignation = gvnDesignation;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getSubSection() {
        return SubSection;
    }

    public void setSubSection(String subSection) {
        SubSection = subSection;
    }

    public String getJobLocation() {
        return JobLocation;
    }

    public void setJobLocation(String jobLocation) {
        JobLocation = jobLocation;
    }

    public String getOperationId() {
        return OperationId;
    }

    public void setOperationId(String operationId) {
        OperationId = operationId;
    }

    public Date getDOC() {
        return DOC;
    }

    public void setDOC(Date DOC) {
        this.DOC = DOC;
    }

    public String getCostCenter() {
        return CostCenter;
    }

    public void setCostCenter(String costCenter) {
        CostCenter = costCenter;
    }

    public String getBioRegNo() {
        return BioRegNo;
    }

    public void setBioRegNo(String bioRegNo) {
        BioRegNo = bioRegNo;
    }
}
