package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ProfessionalQualification" )
public class ProfessionalQualification extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_ProfessionalQualification_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 200)
    @Column(name = "CertificationName")
    private String CertificationName;

    @Size(max = 100)
    @Column(name = "InstituteName")
    private String InstituteName;

    @Size(max = 64)
    @Column(name = "CertificationNo")
    private String CertificationNo;

    @Size(max = 100)
    @Column(name = "CourseDuration")
    private String CourseDuration;

    @Size(max = 100)
    @Column(name = "IssuedBy")
    private String IssuedBy;

    @Size(max = 100)
    @Column(name = "Country")
    private String Country;

    @Column(name = "CertifiedDate")
    private Date CertifiedDate;

    @Column(name = "ExpiryDate")
    private Date ExpiryDate;

    @Column(name = "PassingYear",nullable = true,columnDefinition = "INT CONSTRAINT DF_ProfessionalQualification_PassingYear DEFAULT 0")
    private int PassingYear;

    @Size(max = 100)
    @Column(name = "Notes")
    private String Notes;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getCertificationName() {
        return CertificationName;
    }

    public void setCertificationName(String certificationName) {
        CertificationName = certificationName;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public void setInstituteName(String instituteName) {
        InstituteName = instituteName;
    }

    public String getCertificationNo() {
        return CertificationNo;
    }

    public void setCertificationNo(String certificationNo) {
        CertificationNo = certificationNo;
    }

    public String getCourseDuration() {
        return CourseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        CourseDuration = courseDuration;
    }

    public String getIssuedBy() {
        return IssuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        IssuedBy = issuedBy;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Date getCertifiedDate() {
        return CertifiedDate;
    }

    public void setCertifiedDate(Date certifiedDate) {
        CertifiedDate = certifiedDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        ExpiryDate = expiryDate;
    }

    public int getPassingYear() {
        return PassingYear;
    }

    public void setPassingYear(int passingYear) {
        PassingYear = passingYear;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
