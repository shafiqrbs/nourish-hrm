package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity(name = "Employee")
@Table( name = "Employee", uniqueConstraints = { @UniqueConstraint( columnNames = { "EmployeeCode" } ) } )
public class Employee {

    @Id
    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @Size(max = 20)
    @Column(name = "DisplayEmployeeCode")
    private String DisplayEmployeeCode;

    @Size(max = 10)
    @Column(name = "Salutation")
    private String Salutation;

    @Size(max = 256)
    @Column(name = "Fname")
    private String Fname;

    @Size(max = 256)
    @Column(name = "Mname")
    private String Mname;

    @Size(max = 256)
    @Column(name = "Lname")
    private String Lname;

    @Size(max = 256)
    @Column(name = "Nick")
    private String Nick;

    @Size(max = 256)
    @Column(name = "PunchCardNo")
    private String PunchCardNo;

    @Size(max = 256)
    @Column(name = "EMail")
    private String EMail;

    @Column(name = "DOJ")
    private Date DOJ;

    @Column(name = "DOC")
    private Date DOC;

    @Column(name = "DOS")
    private Date DOS;

    @Size(max = 15)
    @Column(name = "EmployeeStatus")
    private String EmployeeStatus;


    @Column(nullable=true, name = "DesignationID")
    private Integer DesignationID;

    @Size(max = 20)
    @Column(name = "StepCode")
    private String StepCode;

    @Size(max = 20)
    @Column(name = "SalaryRuleCode")
    private String SalaryRuleCode;

    @Column(name = "TransactionEffective")
    private boolean TransactionEffective;

    @Column(name = "SuspensionDate")
    private Date SuspensionDate;

    @Column(name = "ReDOJ")
    private Date ReDOJ;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private EmployeeDetails employeeDetails;
/*
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private EmployeeImage employeeImage;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private EmergencyPersonInfo emergencyPersonInfo;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EducationInfo> educationInfo;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProfessionalQualification> professionalQualifications;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmploymentHistory> employmentHistories;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MedicalNominee> medicalNominees;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<PFNominee> pfNominees;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<InsuranceNominee> insuranceNominees;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GratuityNominee> gratuityNominees;
*/
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

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getDisplayEmployeeCode() {
        return DisplayEmployeeCode;
    }

    public void setDisplayEmployeeCode(String DisplayEmployeeCode) {
        this.DisplayEmployeeCode = DisplayEmployeeCode;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String Salutation) {
        this.Salutation = Salutation;
    }

    public String getFname(){
        return Fname;
    }

    public void setFname(String Fname){
        this.Fname=Fname;
    }

    public String getMname(){
        return Mname;
    }

    public void setMname(String Mname){
        this.Mname=Mname;
    }

    public String getLname(){
        return Lname;
    }

    public void setLname(String Lname){
        this.Lname=Lname;
    }

    public String getNick(){
        return Nick;
    }

    public void setNick(String Nick){
        this.Nick=Nick;
    }

    public String getPunchCardNo(){
        return PunchCardNo;
    }

    public void setPunchCardNo(String PunchCardNo){
        this.PunchCardNo=PunchCardNo;
    }

    public String getEMail(){
        return EMail;
    }

    public void setEMail(String EMail){
        this.EMail=EMail;
    }

    public Date getDOJ(){
        return DOJ;
    }

    public void setDOJ(Date DOJ){
        this.DOJ=DOJ;
    }

    public Date getDOC(){
        return DOC;
    }

    public void setDOC(Date DOC){
        this.DOC=DOC;
    }

    public Date getDOS(){
        return DOS;
    }

    public void setDOS(Date DOS){
        this.DOS=DOS;
    }

    public String getEmployeeStatus(){
        return EmployeeStatus;
    }

    public void setEmployeeStatus(String EmployeeStatus){
        this.EmployeeStatus=EmployeeStatus;
    }

    public int getDesignationID(){
        return DesignationID;
    }

    public void setDesignationID(int DesignationID){
        this.DesignationID=DesignationID;
    }

    public String getStepCode(){
        return StepCode;
    }

    public void setStepCode(String StepCode){
        this.StepCode=StepCode;
    }

    public String getSalaryRuleCode(){
        return SalaryRuleCode;
    }

    public void setSalaryRuleCode(String SalaryRuleCode){
        this.SalaryRuleCode=SalaryRuleCode;
    }

    public boolean getTransactionEffective(){
        return TransactionEffective;
    }

    public void setTransactionEffective(boolean TransactionEffective){
        this.TransactionEffective=TransactionEffective;
    }

    public Date getSuspensionDate(){
        return SuspensionDate;
    }

    public void setSuspensionDate(Date SuspensionDate){
        this.SuspensionDate=SuspensionDate;
    }

    public Date getReDOJ(){
        return ReDOJ;
    }

    public void setReDOJ(Date ReDOJ){
        this.ReDOJ=ReDOJ;
    }

    public EmployeeDetails getEmployeeDetails(){
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails){
        this.employeeDetails = employeeDetails;
        employeeDetails.setEmployee(this);
    }
/*
    public EmployeeImage getEmployeeImage(){
        return employeeImage;
    }

    public void setEmployeeImage(EmployeeImage employeeImage){
        this.employeeImage = employeeImage;
        employeeImage.setEmployeeInfo(this);
    }

    public EmergencyPersonInfo getEmergencyPersonInfo(){
        return emergencyPersonInfo;
    }

    public void setEmergencyPersonInfo(EmergencyPersonInfo emergencyPersonInfo){
        this.emergencyPersonInfo = emergencyPersonInfo;
        emergencyPersonInfo.setEmployeeInfo(this);
    }

    public Set<EducationInfo> getEducationInfo(){
        return educationInfo;
    }

    public void setEducationInfo(Set<EducationInfo> educationInfo){
        this.educationInfo = educationInfo;
    }

    public Set<ProfessionalQualification> getProfessionalQualifications(){
        return professionalQualifications;
    }

    public void setProfessionalQualifications(Set<ProfessionalQualification> professionalQualifications){
        this.professionalQualifications = professionalQualifications;
    }

    public Set<EmploymentHistory> getEmploymentHistories(){
        return employmentHistories;
    }

    public void setEmploymentHistories(Set<EmploymentHistory> employmentHistories){
        this.employmentHistories = employmentHistories;
    }

    public Set<MedicalNominee> getMedicalNominees(){
        return medicalNominees;
    }

    public void setMedicalNominees(Set<MedicalNominee> medicalNominees){
        this.medicalNominees = medicalNominees;
    }

    public Set<PFNominee> getPfNominees(){
        return pfNominees;
    }

    public void setPfNominees(Set<PFNominee> pfNominees){
        this.pfNominees = pfNominees;
    }

    public Set<InsuranceNominee> getInsuranceNominees(){
        return insuranceNominees;
    }

    public void setInsuranceNominees(Set<InsuranceNominee> insuranceNominees){
        this.insuranceNominees = insuranceNominees;
    }

    public Set<GratuityNominee> getGratuityNominees(){
        return gratuityNominees;
    }

    public void setGratuityNominees(Set<GratuityNominee> gratuityNominees){
        this.gratuityNominees = gratuityNominees;
    }
*/
    public String getAddedBy() {
        return AddedBy;
    }

    public void setAddedBy(String AddedBy) {
        this.AddedBy = AddedBy;
    }

    public Date getCreatedAt() {
        return DateAdded;
    }

    public void setDateAdded(Date DateAdded) {
        this.DateAdded = DateAdded;
    }

    public String getUpdatedBy() {
        return UpdatedBy;
    }

    public void setUpdatedBy(String UpdatedBy) {
        this.UpdatedBy = UpdatedBy;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date UpdatedDate) {
        this.UpdatedDate = UpdatedDate;
    }

    @PrePersist   public void setUpdatedDate() {
        this.UpdatedDate = new Date();
    }

    @PreUpdate
    public void setDateAdded() {
        this.DateAdded = new Date();
    }

}
