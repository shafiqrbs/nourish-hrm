package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Entity(name = "EmployeeInfo")
@Table( name = "EmployeeInfo", uniqueConstraints = { @UniqueConstraint( columnNames = { "EmployeeCode" } ) } )
public class EmployeeInfo {

    @Id
    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Size(max = 256)
    @Column(name = "FirstName")
    private String firstName;

    @Size(max = 256)
    @Column(name = "MiddleName")
    private String middleName;

    @Size(max = 256)
    @Column(name = "LastName")
    private String lastName;

    @Size(max = 256)
    @Column(name = "NickName")
    private String nickName;

    @Size(max = 10)
    @Column(name = "Salutation")
    private String salutation;

    @Size(max = 256)
    @Column(name = "FathersName")
    private String fathersName;

    @Size(max = 256)
    @Column(name = "MothersName")
    private String mothersName;

    @Size(max = 15)
    @Column(name = "EmployeeStatus")
    private String employeeStatus;

    @Size(max = 32)
    @Column(name = "NID")
    private String nid;

    @Size(max = 20)
    @Column(name = "DisplayEmployeeCode")
    private String displayEmployeeCode;

    @Size(max = 20)
    @Column(name = "PunchCardNo")
    private String punchCardNo;

    @Size(max = 10)
    @Column(name = "EmployeeType")
    private String employeeType;

    @Size(max = 64)
    @Column(name = "WorkerEmploymentType")
    private String workerEmploymentType;

    @Size(max = 256)
    @Column(name = "PresentAddress")
    private String presentAddress;

    @Size(max = 64)
    @Column(name = "PresentPS")
    private String presentPS;

    @Size(max = 64)
    @Column(name = "PresentZIPCode")
    private String presentZIPCode;

    @Size(max = 64)
    @Column(name = "PresentDistrict")
    private String presentDistrict;

    @Size(max = 64)
    @Column(name = "PresentCountry")
    private String presentCountry;

    @Size(max = 100)
    @Column(name = "HouseOwnerName")
    private String houseOwnerName;

    @Size(max = 20)
    @Column(name = "HouseOwnerMobile")
    private String houseOwnerMobile;

    @Column(name = "IsPermanentSame",columnDefinition = "BIT DEFAULT 0")
    private boolean isPermanentSame;

    @Size(max = 256)
    @Column(name = "PermanentAddress")
    private String permanentAddress;

    @Size(max = 64)
    @Column(name = "PermanentPS")
    private String permanentPS;

    @Size(max = 64)
    @Column(name = "PermanentZIPCode")
    private String permanentZIPCode;

    @Size(max = 64)
    @Column(name = "PermanentDistrict")
    private String permanentDistrict;

    @Size(max = 64)
    @Column(name = "PermanentCountry")
    private String permanentCountry;

    @Size(max = 16)
    @Column(name = "MaritalStatus")
    private String maritalStatus;

    @Size(max = 64)
    @Column(name = "SpouseName")
    private String spouseName;

    @Size(max = 64)
    @Column(name = "SpouseOccupation")
    private String spouseOccupation;

    @Column(name = "NoOfChildren",columnDefinition = "INT DEFAULT 0")
    private int noOfChildren;

    @Column(name = "DOB")
    private Date dob;

    @Size(max = 8)
    @Column(name = "Gender")
    private String gender;

    @Size(max = 16)
    @Column(name = "Religion")
    private String religion;

    @Size(max = 64)
    @Column(name = "Nationality")
    private String nationality;

    @Size(max = 8)
    @Column(name = "BloodGroup")
    private String bloodGroup;

    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;

    @Size(max = 64)
    @Column(name = "Email")
    private String email;

    @Size(max = 256)
    @Column(name = "ReferenceAddress")
    private String referenceAddress;

    @Size(max = 256)
    @Column(name = "PersonalRemarks")
    private String personalRemarks;

    @Size(max = 256)
    @Column(name = "EmpImage")
    private String empImage;

    @Size(max = 256)
    @Column(name = "EmpSignature")
    private String empSignature;

    @Column(name = "IsDelete")
    private boolean isDelete;

    @Size(max = 20)
    @Column(name = "AddedBy", length = 20)
    private String addedBy;

    @Column(name = "DateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    @Size(max = 20)
    @Column(name = "UpdatedBy", length = 20)
    private String updatedBy;

    @Column(name = "UpdatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Size(max = 100)
    @Column(name = "IdentityMark")
    private String identityMark;

    @Column(name = "IsCandidate",columnDefinition = "BIT DEFAULT 0")
    private boolean isCandidate;

    @Column(name = "InterviewDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date interviewDate;

    @Size(max = 256)
    @Column(name = "candidateOtherInfo", length = 20)
    private String candidateOtherInfo;

    @Size(max = 256)
    @Column(name = "candidateBehaviour", length = 20)
    private String candidateBehaviour;

    @Column(name = "IsSubmitNID",columnDefinition = "BIT DEFAULT 0")
    private boolean isSubmitNID;

    @Size(max = 256)
    @Column(name = "NationalIDCopy")
    private String nidCard;

    @Column(name = "IsSubmitBirthDateCertificate",columnDefinition = "BIT DEFAULT 0")
    private boolean isSubmitBirthDateCertificate;

    @Size(max = 256)
    @Column(name = "BirthDateCertificate")
    private String birthDateCertificate;

    @Column(name = "IsSubmitChairmanCertificate",columnDefinition = "BIT DEFAULT 0")
    private boolean isSubmitChairmanCertificate;

    @Size(max = 256)
    @Column(name = "ChairmanCertificate")
    private String chairmanCertificate;

    @Size(max = 256)
    @Column(name = "applyForPosition")
    private String applyForPosition;


    @Column(name = "IsWentToJailForCrime",columnDefinition = "BIT DEFAULT 0")
    private boolean isWentToJailForCrime;

    @Column(name = "IsCreateLoginUser",nullable = false,columnDefinition = "BIT CONSTRAINT DF_EmployeeInfo_IsCreateLoginUser DEFAULT 0")
    private boolean isCreateLoginUser;

    @Column(name = "HaveKnownWorker",nullable = false,columnDefinition = "BIT CONSTRAINT DF_EmployeeInfo_HaveKnownWorker DEFAULT 0")
    private boolean haveKnownWorker;

    @Column(name = "IsProcessed",nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmployeeInfo_IsProcessed DEFAULT 0")
    private boolean isProcessed;



    @OneToOne(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private EmployeeOfficeInfo employeeOfficeInfo;

    @OneToOne(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private EmployeeRuleInfo employeeRuleInfo;

    @OneToOne(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private EmployeeFamilyInfo employeeFamilyInfo;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmergencyPersonInfo> emergencyPersonInfo;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EducationInfo> educationInfo;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProfessionalQualification> professionalQualifications;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmploymentHistory> employmentHistories;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Language> languages;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Skills> skills;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Promotion> promotions;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DisciplinaryAction> disciplinaryActions;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Separation> separations;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Transfer> transfers;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmployeeSalary> employeeSalaries;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LeaveTransInfo> leaveTransInfos;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmployeeLeaveMaster> employeeLeaveMasters;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmpLeaveTransactionApplied> empLeaveTransactionApplieds;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MaternityLeavePayment> maternityLeavePayments;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BonusTransaction> bonusTransactions;

    @OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CandidateSkillMatrixSection> candidateSkillMatrixSections;

    @OneToOne(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private EmployeeRuleTag employeeRuleTag;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
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

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getWorkerEmploymentType() {
        return workerEmploymentType;
    }

    public void setWorkerEmploymentType(String workerEmploymentType) {
        this.workerEmploymentType = workerEmploymentType;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPresentPS() {
        return presentPS;
    }

    public void setPresentPS(String presentPS) {
        this.presentPS = presentPS;
    }

    public String getPresentZIPCode() {
        return presentZIPCode;
    }

    public void setPresentZIPCode(String presentZIPCode) {
        this.presentZIPCode = presentZIPCode;
    }

    public String getPresentDistrict() {
        return presentDistrict;
    }

    public void setPresentDistrict(String presentDistrict) {
        this.presentDistrict = presentDistrict;
    }

    public String getPresentCountry() {
        return presentCountry;
    }

    public void setPresentCountry(String presentCountry) {
        this.presentCountry = presentCountry;
    }

    public String getHouseOwnerName() {
        return houseOwnerName;
    }

    public void setHouseOwnerName(String houseOwnerName) {
        this.houseOwnerName = houseOwnerName;
    }

    public String getHouseOwnerMobile() {
        return houseOwnerMobile;
    }

    public void setHouseOwnerMobile(String houseOwnerMobile) {
        this.houseOwnerMobile = houseOwnerMobile;
    }

    public boolean isPermanentSame() {
        return isPermanentSame;
    }

    public void setPermanentSame(boolean permanentSame) {
        isPermanentSame = permanentSame;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public String getPermanentPS() {
        return permanentPS;
    }

    public void setPermanentPS(String permanentPS) {
        this.permanentPS = permanentPS;
    }

    public String getPermanentZIPCode() {
        return permanentZIPCode;
    }

    public void setPermanentZIPCode(String permanentZIPCode) {
        this.permanentZIPCode = permanentZIPCode;
    }

    public String getPermanentDistrict() {
        return permanentDistrict;
    }

    public void setPermanentDistrict(String permanentDistrict) {
        this.permanentDistrict = permanentDistrict;
    }

    public String getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(String permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseOccupation() {
        return spouseOccupation;
    }

    public void setSpouseOccupation(String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReferenceAddress() {
        return referenceAddress;
    }

    public void setReferenceAddress(String referenceAddress) {
        this.referenceAddress = referenceAddress;
    }

    public String getPersonalRemarks() {
        return personalRemarks;
    }

    public void setPersonalRemarks(String personalRemarks) {
        this.personalRemarks = personalRemarks;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }

    public String getEmpSignature() {
        return empSignature;
    }

    public void setEmpSignature(String empSignature) {
        this.empSignature = empSignature;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIdentityMark() {
        return identityMark;
    }

    public void setIdentityMark(String identityMark) {
        this.identityMark = identityMark;
    }

    public boolean isCandidate() {
        return isCandidate;
    }

    public void setCandidate(boolean candidate) {
        isCandidate = candidate;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getCandidateOtherInfo() {
        return candidateOtherInfo;
    }

    public void setCandidateOtherInfo(String candidateOtherInfo) {
        this.candidateOtherInfo = candidateOtherInfo;
    }

    public String getCandidateBehaviour() {
        return candidateBehaviour;
    }

    public void setCandidateBehaviour(String candidateBehaviour) {
        this.candidateBehaviour = candidateBehaviour;
    }

    public boolean isSubmitNID() {
        return isSubmitNID;
    }

    public void setSubmitNID(boolean submitNID) {
        isSubmitNID = submitNID;
    }

    public String getNidCard() {
        return nidCard;
    }

    public void setNidCard(String nidCard) {
        this.nidCard = nidCard;
    }

    public boolean isSubmitBirthDateCertificate() {
        return isSubmitBirthDateCertificate;
    }

    public void setSubmitBirthDateCertificate(boolean submitBirthDateCertificate) {
        isSubmitBirthDateCertificate = submitBirthDateCertificate;
    }

    public String getBirthDateCertificate() {
        return birthDateCertificate;
    }

    public void setBirthDateCertificate(String birthDateCertificate) {
        this.birthDateCertificate = birthDateCertificate;
    }

    public boolean isSubmitChairmanCertificate() {
        return isSubmitChairmanCertificate;
    }

    public void setSubmitChairmanCertificate(boolean submitChairmanCertificate) {
        isSubmitChairmanCertificate = submitChairmanCertificate;
    }

    public String getChairmanCertificate() {
        return chairmanCertificate;
    }

    public void setChairmanCertificate(String chairmanCertificate) {
        this.chairmanCertificate = chairmanCertificate;
    }

    public String getApplyForPosition() {
        return applyForPosition;
    }

    public void setApplyForPosition(String applyForPosition) {
        this.applyForPosition = applyForPosition;
    }

    public boolean isCreateLoginUser() {
        return isCreateLoginUser;
    }

    public void setCreateLoginUser(boolean createLoginUser) {
        isCreateLoginUser = createLoginUser;
    }

    public Set<EmergencyPersonInfo> getEmergencyPersonInfo() {
        return emergencyPersonInfo;
    }

    public void setEmergencyPersonInfo(Set<EmergencyPersonInfo> emergencyPersonInfo) {
        this.emergencyPersonInfo = emergencyPersonInfo;
    }

    public Set<EducationInfo> getEducationInfo() {
        return educationInfo;
    }

    public void setEducationInfo(Set<EducationInfo> educationInfo) {
        this.educationInfo = educationInfo;
    }

    public Set<ProfessionalQualification> getProfessionalQualifications() {
        return professionalQualifications;
    }

    public void setProfessionalQualifications(Set<ProfessionalQualification> professionalQualifications) {
        this.professionalQualifications = professionalQualifications;
    }

    public Set<EmploymentHistory> getEmploymentHistories() {
        return employmentHistories;
    }

    public void setEmploymentHistories(Set<EmploymentHistory> employmentHistories) {
        this.employmentHistories = employmentHistories;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<DisciplinaryAction> getDisciplinaryActions() {
        return disciplinaryActions;
    }

    public void setDisciplinaryActions(Set<DisciplinaryAction> disciplinaryActions) {
        this.disciplinaryActions = disciplinaryActions;
    }

    public EmployeeOfficeInfo getEmployeeOfficeInfo() {
        return employeeOfficeInfo;
    }

    public void setEmployeeOfficeInfo(EmployeeOfficeInfo employeeOfficeInfo) {
        this.employeeOfficeInfo = employeeOfficeInfo;
    }

    public EmployeeRuleInfo getEmployeeRuleInfo() {
        return employeeRuleInfo;
    }

    public void setEmployeeRuleInfo(EmployeeRuleInfo employeeRuleInfo) {
        this.employeeRuleInfo = employeeRuleInfo;
    }

    public EmployeeFamilyInfo getEmployeeFamilyInfo() {
        return employeeFamilyInfo;
    }

    public void setEmployeeFamilyInfo(EmployeeFamilyInfo employeeFamilyInfo) {
        this.employeeFamilyInfo = employeeFamilyInfo;
    }

    public Set<Skills> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skills> skills) {
        this.skills = skills;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Set<Separation> getSeparations() {
        return separations;
    }

    public void setSeparations(Set<Separation> separations) {
        this.separations = separations;
    }

    public Set<Transfer> getTransfers() {
        return transfers;
    }

    public void setTransfers(Set<Transfer> transfers) {
        this.transfers = transfers;
    }

    public Set<EmployeeSalary> getEmployeeSalaries() {
        return employeeSalaries;
    }

    public void setEmployeeSalaries(Set<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }

    public Set<LeaveTransInfo> getLeaveTransInfos() {
        return leaveTransInfos;
    }

    public void setLeaveTransInfos(Set<LeaveTransInfo> leaveTransInfos) {
        this.leaveTransInfos = leaveTransInfos;
    }

    public Set<EmployeeLeaveMaster> getEmployeeLeaveMasters() {
        return employeeLeaveMasters;
    }

    public void setEmployeeLeaveMasters(Set<EmployeeLeaveMaster> employeeLeaveMasters) {
        this.employeeLeaveMasters = employeeLeaveMasters;
    }

    public Set<EmpLeaveTransactionApplied> getEmpLeaveTransactionApplieds() {
        return empLeaveTransactionApplieds;
    }

    public void setEmpLeaveTransactionApplieds(Set<EmpLeaveTransactionApplied> empLeaveTransactionApplieds) {
        this.empLeaveTransactionApplieds = empLeaveTransactionApplieds;
    }

    public Set<MaternityLeavePayment> getMaternityLeavePayments() {
        return maternityLeavePayments;
    }

    public void setMaternityLeavePayments(Set<MaternityLeavePayment> maternityLeavePayments) {
        this.maternityLeavePayments = maternityLeavePayments;
    }

    public Set<BonusTransaction> getBonusTransactions() {
        return bonusTransactions;
    }

    public void setBonusTransactions(Set<BonusTransaction> bonusTransactions) {
        this.bonusTransactions = bonusTransactions;
    }

    public Set<CandidateSkillMatrixSection> getCandidateSkillMatrixSections() {
        return candidateSkillMatrixSections;
    }

    public void setCandidateSkillMatrixSections(Set<CandidateSkillMatrixSection> candidateSkillMatrixSections) {
        this.candidateSkillMatrixSections = candidateSkillMatrixSections;
    }

    public EmployeeRuleTag getEmployeeRuleTag() {
        return employeeRuleTag;
    }

    public void setEmployeeRuleTag(EmployeeRuleTag employeeRuleTag) {
        this.employeeRuleTag = employeeRuleTag;
    }

    public boolean isWentToJailForCrime() {
        return isWentToJailForCrime;
    }

    public void setWentToJailForCrime(boolean wentToJailForCrime) {
        isWentToJailForCrime = wentToJailForCrime;
    }

    public boolean isHaveKnownWorker() {
        return haveKnownWorker;
    }

    public void setHaveKnownWorker(boolean haveKnownWorker) {
        this.haveKnownWorker = haveKnownWorker;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}
