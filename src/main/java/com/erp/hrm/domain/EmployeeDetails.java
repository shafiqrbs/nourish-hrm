package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 15/04/2018.
 */

@Entity(name = "EmployeeDetails")
@Table(name = "EmployeeDetails")
public class EmployeeDetails extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeDetails_Employee"), nullable = false)
    private Employee employee;

    @Size(max = 10)
    @Column(name = "Gender")
    private String Gender;

    @Size(max = 1000)
    @Column(name = "PresentAddress")
    private String PresentAddress;

    @Column(name = "PresentCityID")
    private Integer PresentCityID;

    @Size(max = 35)
    @Column(name = "PresentState")
    private String PresentState;

    @Size(max = 20)
    @Column(name = "PresentZipCode")
    private String PresentZipCode;

    @Size(max = 1000)
    @Column(name = "PermanentAddress")
    private String PermanentAddress;

    @Column(name = "PermanentCityID")
    private Integer PermanentCityID;

    @Size(max = 50)
    @Column(name = "PermanentState")
    private String PermanentState;

    @Size(max = 50)
    @Column(name = "PermanentZipCode")
    private String PermanentZipCode;

    @Size(max = 20)
    @Column(name = "Nationality")
    private String Nationality;

    @Size(max = 10)
    @Column(name = "MaritalStatus")
    private String MaritalStatus;

    @Size(max = 10)
    @Column(name = "EmpType")
    private String EmpType;

    @Column(name = "DOB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DOB;

    @Size(max = 10)
    @Column(name = "TypeOfGap")
    private String TypeOfGap;

    @Column(name = "TotDays")
    private double TotDays;

    @Size(max = 50)
    @Column(name = "RefPersonName")
    private String RefPersonName;

    @Size(max = 256)
    @Column(name = "RefAddress")
    private String RefAddress;

    @Size(max = 20)
    @Column(name = "BEPZACodeNo")
    private String BEPZACodeNo;

    @Size(max = 1)
    @Column(name = "Applied")
    private String Applied;

    @NotNull
    @Column(name = "OT")
    private boolean OT;

    @Column(name = "OTEntitledDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date OTEntitledDate;

    @NotNull
    @Column(name = "OffDayOT")
    private boolean OffDayOT;

    @NotNull
    @Column(name = "PF")
    private boolean PF;

    @Column(name = "PFEntitledDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date PFEntitledDate;

    @Size(max = 20)
    @Column(name = "PFAccNo")
    private String PFAccNo;

    @Size(max = 20)
    @Column(name = "BankAccNo")
    private String BankAccNo;

    @Size(max = 30)
    @Column(name = "BankID")
    private String BankID;

    @Size(max = 30)
    @Column(name = "BranchName")
    private String BranchName;

    @Size(max = 20)
    @Column(name = "PositionID")
    private String PositionID;

    @Size(max = 20)
    @Column(name = "SupvisorCode")
    private String SupvisorCode;

    @Size(max = 20)
    @Column(name = "AdminReportingPerson")
    private String AdminReportingPerson;

    @Size(max = 10)
    @Column(name = "BloodGroup")
    private String BloodGroup;

    @NotNull
    @Column(name = "IfThumbPic")
    private boolean IfThumbPic;

    @NotNull
    @Column(name = "IfPic")
    private boolean IfPic;

    @Size(max = 50)
    @Column(name = "Religion")
    private String Religion;

    @Size(max = 15)
    @Column(name = "EmployeeState")
    private String EmployeeState;

    @Column(name = "EntrySalary")
    private double EntrySalary;

    @Size(max = 10)
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @Size(max = 10)
    @Column(name = "MaternityLeaveRuleID")
    private String MaternityLeaveRuleID;

    @NotNull
    @Column(name = "HolydayBonus")
    private boolean HolydayBonus;

    @Size(max = 20)
    @Column(name = "WorkerType")
    private String WorkerType;

    @NotNull
    @Column(name = "IsInsuranceEntitled")
    private boolean IsInsuranceEntitled;

    @Size(max = 50)
    @Column(name = "InsuranceAccount")
    private String InsuranceAccount;

    @Column(name = "InsuranceCompanyID")
    private Integer InsuranceCompanyID;

    @Size(max = 20)
    @Column(name = "AttendancePaymentName")
    private String AttendancePaymentName;

    @Column(name = "CurrencyRuleId")
    private Integer CurrencyRuleId;

    @Size(max = 500)
    @Column(name = "SpecialMedicalNote")
    private String SpecialMedicalNote;

    @Size(max = 20)
    @Column(name = "DayWisePaymentRuleCode")
    private String DayWisePaymentRuleCode;

    @Column(name = "SRA")
    private boolean SRA;

    @Size(max = 20)
    @Column(name = "ShiftID")
    private String ShiftID;

    @Column(name = "ShiftRuleId")
    private Integer ShiftRuleId;

    @Column(name = "ShiftStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ShiftStartDate;

    @Size(max = 10)
    @Column(name = "LFARuleID")
    private String LFARuleID;

    @NotNull
    @Column(name = "IsRegular")
    private boolean IsRegular;

    @Size(max = 250)
    @Column(name = "Remarks")
    private String Remarks;

    @Size(max = 50)
    @Column(name = "Password")
    private String Password;

    @Size(max = 20)
    @Column(name = "GradeCode")
    private String GradeCode;

    @Size(max = 50)
    @Column(name = "NationalIDCardNo")
    private String NationalIDCardNo;

    @Size(max = 20)
    @Column(name = "BankRefEmployeeID")
    private String BankRefEmployeeID;

    @Size(max = 50)
    @Column(name = "CPR")
    private String CPR;

    @Column(name = "GovtDesignationID")
    private Integer GovtDesignationID;

    @Size(max = 100)
    @Column(name = "BioRegistrationNo")
    private String BioRegistrationNo;

    @Size(max = 50)
    @Column(name = "TemplatesID")
    private String TemplatesID;

    @Size(max = 20)
    @Column(name = "OperationCode")
    private String OperationCode;

    @Size(max = 20)
    @Column(name = "SkillCatCode")
    private String SkillCatCode;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(String PresentAddress) {
        this.PresentAddress = PresentAddress;
    }

    public Integer getPresentCityID() {
        return PresentCityID;
    }

    public void setPresentCityID(Integer PresentCityID) {
        this.PresentCityID = PresentCityID;
    }

    public String getPresentState() {
        return PresentState;
    }

    public void setPresentState(String PresentState) {
        this.PresentState = PresentState;
    }

    public String getPresentZipCode() {
        return PresentZipCode;
    }

    public void setPresentZipCode(String PresentZipCode) {
        this.PresentZipCode = PresentZipCode;
    }

    public String getPermanentAddress() {
        return PermanentAddress;
    }

    public void setPermanentAddress(String PermanentAddress) {
        this.PermanentAddress = PermanentAddress;
    }

    public Integer getPermanentCityID() {
        return PermanentCityID;
    }

    public void setPermanentCityID(Integer PermanentCityID) {
        this.PermanentCityID = PermanentCityID;
    }

    public String getPermanentState() {
        return PermanentState;
    }

    public void setPermanentState(String PermanentState) {
        this.PermanentState = PermanentState;
    }

    public String getPermanentZipCode() {
        return PermanentZipCode;
    }

    public void setPermanentZipCode(String PermanentZipCode) {
        this.PermanentZipCode = PermanentZipCode;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public String getEmpType() {
        return EmpType;
    }

    public void setEmpType(String EmpType) {
        this.EmpType = EmpType;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getTypeOfGap() {
        return TypeOfGap;
    }

    public void setTypeOfGap(String TypeOfGap) {
        this.TypeOfGap = TypeOfGap;
    }

    public double getTotDays() {
        return TotDays;
    }

    public void setTotDays(double TotDays) {
        this.TotDays = TotDays;
    }

    public String getRefPersonName() {
        return RefPersonName;
    }

    public void setRefPersonName(String RefPersonName) {
        this.RefPersonName = RefPersonName;
    }

    public String getRefAddress() {
        return RefAddress;
    }

    public void setRefAddress(String RefAddress) {
        this.RefAddress = RefAddress;
    }

    public String getBEPZACodeNo() {
        return BEPZACodeNo;
    }

    public void setBEPZACodeNo(String BEPZACodeNo) {
        this.BEPZACodeNo = BEPZACodeNo;
    }

    public String getApplied() {
        return Applied;
    }

    public void setApplied(String Applied) {
        this.Applied = Applied;
    }

    public boolean getOT() {
        return OT;
    }

    public void setOT(boolean OT) {
        this.OT = OT;
    }

    public Date getOTEntitledDate() {
        return OTEntitledDate;
    }

    public void setOTEntitledDate(Date OTEntitledDate) {
        this.OTEntitledDate = OTEntitledDate;
    }

    public boolean getOffDayOT(){
        return OffDayOT;
    }

    public void setOffDayOT(boolean OffDayOT){
        this.OffDayOT=OffDayOT;
    }

    public boolean getPF() {
        return PF;
    }

    public void setPF(boolean PF) {
        this.PF = PF;
    }

    public Date getPFEntitledDate() {
        return PFEntitledDate;
    }

    public void setPFEntitledDate(Date PFEntitledDate) {
        this.PFEntitledDate = PFEntitledDate;
    }

    public String getPFAccNo() {
        return PFAccNo;
    }

    public void setPFAccNo(String PFAccNo) {
        this.PFAccNo = PFAccNo;
    }

    public String getBankAccNo() {
        return BankAccNo;
    }

    public void setBankAccNo(String BankAccNo) {
        this.BankAccNo = BankAccNo;
    }

    public String getBankID() {
        return BankID;
    }

    public void setBankID(String BankID) {
        this.BankID = BankID;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String BranchName) {
        this.BranchName = BranchName;
    }

    public String getPositionID() {
        return PositionID;
    }

    public void setPositionID(String PositionID) {
        this.PositionID = PositionID;
    }

    public String getSupvisorCode() {
        return SupvisorCode;
    }

    public void setSupvisorCode(String SupvisorCode) {
        this.SupvisorCode = SupvisorCode;
    }

    public String getAdminReportingPerson() {
        return AdminReportingPerson;
    }

    public void setAdminReportingPerson(String AdminReportingPerson) {
        this.AdminReportingPerson = AdminReportingPerson;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    public boolean getIfThumbPic() {
        return IfThumbPic;
    }

    public void setIfThumbPic(boolean IfThumbPic) {
        this.IfThumbPic = IfThumbPic;
    }

    public boolean getIfPic() {
        return IfPic;
    }

    public void setIfPic(boolean IfPic) {
        this.IfPic = IfPic;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    public String getEmployeeState() {
        return EmployeeState;
    }

    public void setEmployeeState(String EmployeeState) {
        this.EmployeeState = EmployeeState;
    }

    public double getEntrySalary() {
        return EntrySalary;
    }

    public void setEntrySalary(double EntrySalary) {
        this.EntrySalary = EntrySalary;
    }

    public String getLeaveRuleID() {
        return LeaveRuleID;
    }

    public void setLeaveRuleID(String LeaveRuleID) {
        this.LeaveRuleID = LeaveRuleID;
    }

    public String getMaternityLeaveRuleID() {
        return MaternityLeaveRuleID;
    }

    public void setMaternityLeaveRuleID(String MaternityLeaveRuleID) {
        this.MaternityLeaveRuleID = MaternityLeaveRuleID;
    }

    public boolean getHolydayBonus() {
        return HolydayBonus;
    }

    public void setHolydayBonus(boolean HolydayBonus) {
        this.HolydayBonus = HolydayBonus;
    }

    public String getWorkerType() {
        return WorkerType;
    }

    public void setWorkerType(String WorkerType) {
        this.WorkerType = WorkerType;
    }

    public boolean getIsInsuranceEntitled() {
        return IsInsuranceEntitled;
    }

    public void setIsInsuranceEntitled(boolean IsInsuranceEntitled) {
        this.IsInsuranceEntitled = IsInsuranceEntitled;
    }

    public String getInsuranceAccount() {
        return InsuranceAccount;
    }

    public void setInsuranceAccount(String InsuranceAccount) {
        this.InsuranceAccount = InsuranceAccount;
    }

    public Integer getInsuranceCompanyID() {
        return InsuranceCompanyID;
    }

    public void setInsuranceCompanyID(Integer InsuranceCompanyID) {
        this.InsuranceCompanyID = InsuranceCompanyID;
    }

    public String getAttendancePaymentName() {
        return AttendancePaymentName;
    }

    public void setAttendancePaymentName(String AttendancePaymentName) {
        this.AttendancePaymentName = AttendancePaymentName;
    }

    public Integer getCurrencyRuleId() {
        return CurrencyRuleId;
    }

    public void setCurrencyRuleId(Integer CurrencyRuleId) {
        this.CurrencyRuleId = CurrencyRuleId;
    }

    public String getSpecialMedicalNote() {
        return SpecialMedicalNote;
    }

    public void setSpecialMedicalNote(String SpecialMedicalNote) {
        this.SpecialMedicalNote = SpecialMedicalNote;
    }

    public String getDayWisePaymentRuleCode() {
        return DayWisePaymentRuleCode;
    }

    public void setDayWisePaymentRuleCode(String DayWisePaymentRuleCode) {
        this.DayWisePaymentRuleCode = DayWisePaymentRuleCode;
    }

    public boolean getSRA() {
        return SRA;
    }

    public void setSRA(boolean SRA) {
        this.SRA = SRA;
    }

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String ShiftID) {
        this.ShiftID = ShiftID;
    }

    public Integer getShiftRuleId() {
        return ShiftRuleId;
    }

    public void setShiftRuleId(Integer ShiftRuleId) {
        this.ShiftRuleId = ShiftRuleId;
    }

    public Date getShiftStartDate() {
        return ShiftStartDate;
    }

    public void setShiftStartDate(Date ShiftStartDate) {
        this.ShiftStartDate = ShiftStartDate;
    }

    public String getLFARuleID() {
        return LFARuleID;
    }

    public void setLFARuleID(String LFARuleID) {
        this.LFARuleID = LFARuleID;
    }

    public boolean getIsRegular() {
        return IsRegular;
    }

    public void setIsRegular(boolean IsRegular) {
        this.IsRegular = IsRegular;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getGradeCode() {
        return GradeCode;
    }

    public void setGradeCode(String GradeCode) {
        this.GradeCode = GradeCode;
    }

    public String getNationalIDCardNo() {
        return NationalIDCardNo;
    }

    public void setNationalIDCardNo(String NationalIDCardNo) {
        this.NationalIDCardNo = NationalIDCardNo;
    }

    public String getBankRefEmployeeID() {
        return BankRefEmployeeID;
    }

    public void setBankRefEmployeeID(String BankRefEmployeeID) {
        this.BankRefEmployeeID = BankRefEmployeeID;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public Integer getGovtDesignationID() {
        return GovtDesignationID;
    }

    public void setGovtDesignationID(Integer GovtDesignationID) {
        this.GovtDesignationID = GovtDesignationID;
    }

    public String getBioRegistrationNo() {
        return BioRegistrationNo;
    }

    public void setBioRegistrationNo(String BioRegistrationNo) {
        this.BioRegistrationNo = BioRegistrationNo;
    }

    public String getTemplatesID() {
        return TemplatesID;
    }

    public void setTemplatesID(String TemplatesID) {
        this.TemplatesID = TemplatesID;
    }

    public String getOperationCode() {
        return OperationCode;
    }

    public void setOperationCode(String OperationCode) {
        this.OperationCode = OperationCode;
    }

    public String getSkillCatCode() {
        return SkillCatCode;
    }

    public void setSkillCatCode(String SkillCatCode) {
        this.SkillCatCode = SkillCatCode;
    }
}
