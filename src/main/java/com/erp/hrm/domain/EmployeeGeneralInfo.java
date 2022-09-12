package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "employeeGeneralInfo" )
public class EmployeeGeneralInfo extends BaseEntity {

    @Size(max = 256)
    @Column(name = "EmployeePhoto")
    private String EmployeePhoto;

    @Size(max = 20)
    @Column(name = "FirstName")
    private String FirstName;

    @Size(max = 20)
    @Column(name = "MiddleName")
    private String MiddleName;

    @Size(max = 20)
    @Column(name = "LastName")
    private String LastName;

    @Size(max = 20)
    @Column(name = "NickName")
    private String NickName;

    @Size(max = 50)
    @Column(name = "Salutation")
    private String Salutation;

    @Size(max = 50)
    @Column(name = "Status")
    private String Status;

    @Size(max = 50)
    @Column(name = "NID")
    private String NID;

    @Size(max = 20)
    @Column(name = "DisplayCode")
    private String DisplayCode;

    @Size(max = 50)
    @Column(name = "PunchCardNo")
    private String PunchCardNo;

    @Size(max = 50)
    @Column(name = "EmployeeType")
    private String EmployeeType;

    @Size(max = 50)
    @Column(name = "Employment")
    private String Employment;

    @Size(max = 250)
    @Column(name = "PresentAddress")
    private String PresentAddress;

    @Size(max = 50)
    @Column(name = "PresentAddressPS")
    private String PresentAddressPS;

    @Size(max = 50)
    @Column(name = "PresentAddressZIPCode")
    private String PresentAddressZIPCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "PresentAddressCountry")
    private String PresentAddressCountry;

    @Size(max = 50)
    @Column(name = "PresentAddressDistrict")
    private String PresentAddressDistrict;

    @Size(max = 250)
    @Column(name = "ParmanentAddress")
    private String ParmanentAddress;

    @Size(max = 50)
    @Column(name = "ParmanentAddressPS")
    private String ParmanentAddressPS;

    @Size(max = 50)
    @Column(name = "ParmanentAddressZIPCode")
    private String ParmanentAddressZIPCode;

    @Size(max = 50)
    @Column(name = "ParmanentAddressCountry")
    private String ParmanentAddressCountry;

    @Size(max = 50)
    @Column(name = "ParmanentAddressDistrict")
    private String ParmanentAddressDistrict;

    @Size(max = 20)
    @Column(name = "MaritalStatus")
    private String MaritalStatus;

    @Size(max = 50)
    @Column(name = "SpouseName")
    private String SpouseName;

    @Size(max = 50)
    @Column(name = "SpouseOccupation")
    private String SpouseOccupation;

    @Size(max = 20)
    @Column(name = "NoOfChildren")
    private String NoOfChildren;

    @Column(name = "DateofBirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateofBirth;

    @Size(max = 20)
    @Column(name = "Gender")
    private String Gender;

    @Size(max = 50)
    @Column(name = "Religion")
    private String Religion;

    @Size(max = 50)
    @Column(name = "Nationality")
    private String Nationality;

    @Size(max = 20)
    @Column(name = "BloodGroup")
    private String BloodGroup;

    @Size(max = 50)
    @Column(name = "Phone")
    private String Phone;

    @Size(max = 100)
    @Column(name = "Email")
    private String Email;

    @Size(max = 250)
    @Column(name = "ReferenceAddress")
    private String ReferenceAddress;

    @Size(max = 100)
    @Column(name = "PersonalRemarks")
    private String PersonalRemarks;

    @Size(max = 256)
    @Column(name = "EmployeeSign")
    private String EmployeeSign;

    public String getEmployeePhoto() {
        return EmployeePhoto;
    }

    public void setEmployeePhoto(String EmployeePhoto) {
        this.EmployeePhoto = EmployeePhoto;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public String getSalutation() {
        return Salutation;
    }

    public void setSalutation(String Salutation) {
        this.Salutation = Salutation;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public String getDisplayCode() {
        return DisplayCode;
    }

    public void setDisplayCode(String DisplayCode) {
        this.DisplayCode = DisplayCode;
    }

    public String getPunchCardNo() {
        return PunchCardNo;
    }

    public void setPunchCardNo(String PunchCardNo) {
        this.PunchCardNo = PunchCardNo;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String EmployeeType) {
        this.EmployeeType = EmployeeType;
    }

    public String getEmployment() {
        return Employment;
    }

    public void setEmployment(String Employment) {
        this.Employment = Employment;
    }

    public String getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(String PresentAddress) {
        this.PresentAddress = PresentAddress;
    }

    public String getPresentAddressPS() {
        return PresentAddressPS;
    }

    public void setPresentAddressPS(String PresentAddressPS) {
        this.PresentAddressPS = PresentAddressPS;
    }

    public String getPresentAddressZIPCode() {
        return PresentAddressZIPCode;
    }

    public void setPresentAddressZIPCode(String PresentAddressZIPCode) {
        this.PresentAddressZIPCode = PresentAddressZIPCode;
    }

    public String getPresentAddressCountry() {
        return PresentAddressCountry;
    }

    public void setPresentAddressCountry(String PresentAddressCountry) {
        this.PresentAddressCountry = PresentAddressCountry;
    }

    public String getPresentAddressDistrict() {
        return PresentAddressDistrict;
    }

    public void setPresentAddressDistrict(String PresentAddressDistrict) {
        this.PresentAddressDistrict = PresentAddressDistrict;
    }

    public String getParmanentAddress() {
        return ParmanentAddress;
    }

    public void setParmanentAddress(String ParmanentAddress) {
        this.ParmanentAddress = ParmanentAddress;
    }

    public String getParmanentAddressPS() {
        return ParmanentAddressPS;
    }

    public void setParmanentAddressPS(String ParmanentAddressPS) {
        this.ParmanentAddressPS = ParmanentAddressPS;
    }

    public String getParmanentAddressZIPCode() {
        return ParmanentAddressZIPCode;
    }

    public void setParmanentAddressZIPCode(String ParmanentAddressZIPCode) {
        this.ParmanentAddressZIPCode = ParmanentAddressZIPCode;
    }

    public String getParmanentAddressCountry() {
        return ParmanentAddressCountry;
    }

    public void setParmanentAddressCountry(String ParmanentAddressCountry) {
        this.ParmanentAddressCountry = ParmanentAddressCountry;
    }

    public String getParmanentAddressDistrict() {
        return ParmanentAddressDistrict;
    }

    public void setParmanentAddressDistrict(String ParmanentAddressDistrict) {
        this.ParmanentAddressDistrict = ParmanentAddressDistrict;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public String getSpouseName() {
        return SpouseName;
    }

    public void setSpouseName(String SpouseName) {
        this.SpouseName = SpouseName;
    }

    public String getSpouseOccupation() {
        return SpouseOccupation;
    }

    public void setSpouseOccupation(String SpouseOccupation) {
        this.SpouseOccupation = SpouseOccupation;
    }

    public String getNoOfChildren() {
        return NoOfChildren;
    }

    public void setNoOfChildren(String NoOfChildren) {
        this.NoOfChildren = NoOfChildren;
    }

    public Date getDateofBirth() {
        return DateofBirth;
    }

    public void setDateofBirth(Date DateofBirth) {
        this.DateofBirth = DateofBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String Nationality) {
        this.Nationality = Nationality;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public void setBloodGroup(String BloodGroup) {
        this.BloodGroup = BloodGroup;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getReferenceAddress() {
        return ReferenceAddress;
    }

    public void setReferenceAddress(String ReferenceAddress) {
        this.ReferenceAddress = ReferenceAddress;
    }

    public String getPersonalRemarks() {
        return PersonalRemarks;
    }

    public void setPersonalRemarks(String PersonalRemarks) {
        this.PersonalRemarks = PersonalRemarks;
    }

    public String getEmployeeSign() {
        return EmployeeSign;
    }

    public void setEmployeeSign(String EmployeeSign) {
        this.EmployeeSign = EmployeeSign;
    }
}
