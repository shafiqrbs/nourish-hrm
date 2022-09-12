package com.erp.hrm.api.dto.recruitment;
import java.util.Date;

public class CandidateApplicationFormDTO {
    private String employeeCode;
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;
    private String salutation;
    private String fathersName;
    private String mothersName;
    private String employeeStatus;
    private String nid;
    private String displayEmployeeCode;
    private String punchCardNo;
    private String employeeType;
    private String workerEmploymentType;
    private String presentAddress;
    private String presentPS;
    private String presentZIPCode;
    private String presentDistrict;
    private String presentCountry;
    private String houseOwnerName;
    private String houseOwnerMobile;
    private boolean isPermanentSame;
    private String permanentAddress;
    private String permanentPS;
    private String permanentZIPCode;
    private String permanentDistrict;
    private String permanentCountry;
    private String maritalStatus;
    private String spouseName;
    private String spouseOccupation;
    private int noOfChildren;
    private Date dob;
    private String gender;
    private String religion;
    private String nationality;
    private String bloodGroup;
    private String phone;
    private String email;
    private String referenceAddress;
    private String personalRemarks;
    private String empImage;
    private String empSignature;
    private boolean isDelete;
    private boolean isCandidate;
    private String identityMark;

    public CandidateApplicationFormDTO(){
    }

    public CandidateApplicationFormDTO(String employeeCode, String firstName, String middleName, String lastName, String nickName, String salutation, String fathersName, String mothersName, String employeeStatus, String nid, String displayEmployeeCode, String punchCardNo, String employeeType, String workerEmploymentType, String presentAddress, String presentPS, String presentZIPCode, String presentDistrict, String presentCountry, String houseOwnerName, String houseOwnerMobile, boolean isPermanentSame, String permanentAddress, String permanentPS, String permanentZIPCode, String permanentDistrict, String permanentCountry, String maritalStatus, String spouseName, String spouseOccupation, int noOfChildren, Date dob, String gender, String religion, String nationality, String bloodGroup, String phone, String email, String referenceAddress, String personalRemarks, String empImage, String empSignature, boolean isDelete, boolean isCandidate, String identityMark) {
        this.employeeCode = employeeCode;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.salutation = salutation;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.employeeStatus = employeeStatus;
        this.nid = nid;
        this.displayEmployeeCode = displayEmployeeCode;
        this.punchCardNo = punchCardNo;
        this.employeeType = employeeType;
        this.workerEmploymentType = workerEmploymentType;
        this.presentAddress = presentAddress;
        this.presentPS = presentPS;
        this.presentZIPCode = presentZIPCode;
        this.presentDistrict = presentDistrict;
        this.presentCountry = presentCountry;
        this.houseOwnerName = houseOwnerName;
        this.houseOwnerMobile = houseOwnerMobile;
        this.isPermanentSame = isPermanentSame;
        this.permanentAddress = permanentAddress;
        this.permanentPS = permanentPS;
        this.permanentZIPCode = permanentZIPCode;
        this.permanentDistrict = permanentDistrict;
        this.permanentCountry = permanentCountry;
        this.maritalStatus = maritalStatus;
        this.spouseName = spouseName;
        this.spouseOccupation = spouseOccupation;
        this.noOfChildren = noOfChildren;
        this.dob = dob;
        this.gender = gender;
        this.religion = religion;
        this.nationality = nationality;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.email = email;
        this.referenceAddress = referenceAddress;
        this.personalRemarks = personalRemarks;
        this.empImage = empImage;
        this.empSignature = empSignature;
        this.isDelete = isDelete;
        this.isCandidate = isCandidate;
        this.identityMark = identityMark;
    }

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

    public boolean isCandidate() {
        return isCandidate;
    }

    public void setCandidate(boolean candidate) {
        isCandidate = candidate;
    }

    public String getIdentityMark() {
        return identityMark;
    }

    public void setIdentityMark(String identityMark) {
        this.identityMark = identityMark;
    }
}
