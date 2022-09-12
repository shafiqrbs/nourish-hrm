package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 27/01/2019.
 */
@Entity
@Table( name = "CandidateJobVerificationReport" )
public class CandidateJobVerificationReport extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Size(max = 4)
    @Column(name = "IsContactedWithLastCompany")
    private String isContactedWithLastCompany;

    @Size(max = 10)
    @Column(name = "CommunicationMediaWithLastCompany")
    private String communicationMediaWithLastCompany;

    @Size(max = 100)
    @Column(name = "LastCompanyName")
    private String lastCompanyName;

    @Size(max = 256)
    @Column(name = "LastCompanyAddress")
    private String lastCompanyAddress;

    @Size(max = 32)
    @Column(name = "LastCompanyDesignation")
    private String lastCompanyDesignation;

    @Size(max = 20)
    @Column(name = "LastSection")
    private String lastSection;

    @Size(max = 20)
    @Column(name = "LastJobPeriod")
    private String lastJobPeriod;

    @Size(max = 16)
    @Column(name = "LastEmploymentResult")
    private String lastEmploymentResult;

    @Size(max = 4)
    @Column(name = "IsContactedWithReference")
    private String isContactedWithReference;

    @Size(max = 10)
    @Column(name = "CommunicationMediaWithReference")
    private String communicationMediaWithReference;

    @Size(max = 64)
    @Column(name = "ReferenceInfoProviderName")
    private String referenceInfoProviderName;

    @Size(max = 32)
    @Column(name = "ReferencePosition")
    private String referencePosition;

    @Size(max = 20)
    @Column(name = "ReferenceMobileNo")
    private String referenceMobileNo;

    @Size(max = 16)
    @Column(name = "ReferenceResult")
    private String referenceResult;

    @Size(max = 4)
    @Column(name = "IsContactedForCriminalBackground")
    private String isContactedForCriminalBackground;

    @Size(max = 10)
    @Column(name = "CommunicationMediaWithPolice")
    private String communicationMediaWithPolice;

    @Size(max = 64)
    @Column(name = "CriminalInfoProviderName")
    private String criminalInfoProviderName;

    @Size(max = 32)
    @Column(name = "CriminalInfoProviderPosition")
    private String criminalInfoProviderPosition;

    @Column(name = "CriminalInfoProvidingDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date criminalInfoProvidingDate;

    @Size(max = 16)
    @Column(name = "CriminalInfoProvidingResult")
    private String criminalInfoProvidingResult;

    @Size(max = 4)
    @Column(name = "IsContactedForReferenceCheck")
    private String isContactedForReferenceCheck;

    @Size(max = 10)
    @Column(name = "CommunicationMediaForReferenceCheck")
    private String communicationMediaForReferenceCheck;

    @Size(max = 64)
    @Column(name = "ReferenceCheckInfoProviderName")
    private String referenceCheckInfoProviderName;

    @Size(max = 256)
    @Column(name = "ReferenceCheckInfoProviderAddress")
    private String referenceCheckInfoProviderAddress;

    @Size(max = 20)
    @Column(name = "ReferenceCheckInfoProviderMobile")
    private String referenceCheckInfoProviderMobile;

    @Size(max = 16)
    @Column(name = "ReferenceCheckInfoProvidingResult")
    private String referenceCheckInfoProvidingResult;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getIsContactedWithLastCompany() {
        return isContactedWithLastCompany;
    }

    public void setIsContactedWithLastCompany(String isContactedWithLastCompany) {
        this.isContactedWithLastCompany = isContactedWithLastCompany;
    }

    public String getCommunicationMediaWithLastCompany() {
        return communicationMediaWithLastCompany;
    }

    public void setCommunicationMediaWithLastCompany(String communicationMediaWithLastCompany) {
        this.communicationMediaWithLastCompany = communicationMediaWithLastCompany;
    }

    public String getLastCompanyName() {
        return lastCompanyName;
    }

    public void setLastCompanyName(String lastCompanyName) {
        this.lastCompanyName = lastCompanyName;
    }

    public String getLastCompanyAddress() {
        return lastCompanyAddress;
    }

    public void setLastCompanyAddress(String lastCompanyAddress) {
        this.lastCompanyAddress = lastCompanyAddress;
    }

    public String getLastCompanyDesignation() {
        return lastCompanyDesignation;
    }

    public void setLastCompanyDesignation(String lastCompanyDesignation) {
        this.lastCompanyDesignation = lastCompanyDesignation;
    }

    public String getLastSection() {
        return lastSection;
    }

    public void setLastSection(String lastSection) {
        this.lastSection = lastSection;
    }

    public String getLastJobPeriod() {
        return lastJobPeriod;
    }

    public void setLastJobPeriod(String lastJobPeriod) {
        this.lastJobPeriod = lastJobPeriod;
    }

    public String getLastEmploymentResult() {
        return lastEmploymentResult;
    }

    public void setLastEmploymentResult(String lastEmploymentResult) {
        this.lastEmploymentResult = lastEmploymentResult;
    }

    public String getIsContactedWithReference() {
        return isContactedWithReference;
    }

    public void setIsContactedWithReference(String isContactedWithReference) {
        this.isContactedWithReference = isContactedWithReference;
    }

    public String getCommunicationMediaWithReference() {
        return communicationMediaWithReference;
    }

    public void setCommunicationMediaWithReference(String communicationMediaWithReference) {
        this.communicationMediaWithReference = communicationMediaWithReference;
    }

    public String getReferenceInfoProviderName() {
        return referenceInfoProviderName;
    }

    public void setReferenceInfoProviderName(String referenceInfoProviderName) {
        this.referenceInfoProviderName = referenceInfoProviderName;
    }

    public String getReferencePosition() {
        return referencePosition;
    }

    public void setReferencePosition(String referencePosition) {
        this.referencePosition = referencePosition;
    }

    public String getReferenceMobileNo() {
        return referenceMobileNo;
    }

    public void setReferenceMobileNo(String referenceMobileNo) {
        this.referenceMobileNo = referenceMobileNo;
    }

    public String getReferenceResult() {
        return referenceResult;
    }

    public void setReferenceResult(String referenceResult) {
        this.referenceResult = referenceResult;
    }

    public String getIsContactedForCriminalBackground() {
        return isContactedForCriminalBackground;
    }

    public void setIsContactedForCriminalBackground(String isContactedForCriminalBackground) {
        this.isContactedForCriminalBackground = isContactedForCriminalBackground;
    }

    public String getCommunicationMediaWithPolice() {
        return communicationMediaWithPolice;
    }

    public void setCommunicationMediaWithPolice(String communicationMediaWithPolice) {
        this.communicationMediaWithPolice = communicationMediaWithPolice;
    }

    public String getCriminalInfoProviderName() {
        return criminalInfoProviderName;
    }

    public void setCriminalInfoProviderName(String criminalInfoProviderName) {
        this.criminalInfoProviderName = criminalInfoProviderName;
    }

    public String getCriminalInfoProviderPosition() {
        return criminalInfoProviderPosition;
    }

    public void setCriminalInfoProviderPosition(String criminalInfoProviderPosition) {
        this.criminalInfoProviderPosition = criminalInfoProviderPosition;
    }

    public Date getCriminalInfoProvidingDate() {
        return criminalInfoProvidingDate;
    }

    public void setCriminalInfoProvidingDate(Date criminalInfoProvidingDate) {
        this.criminalInfoProvidingDate = criminalInfoProvidingDate;
    }

    public String getCriminalInfoProvidingResult() {
        return criminalInfoProvidingResult;
    }

    public void setCriminalInfoProvidingResult(String criminalInfoProvidingResult) {
        this.criminalInfoProvidingResult = criminalInfoProvidingResult;
    }

    public String getIsContactedForReferenceCheck() {
        return isContactedForReferenceCheck;
    }

    public void setIsContactedForReferenceCheck(String isContactedForReferenceCheck) {
        this.isContactedForReferenceCheck = isContactedForReferenceCheck;
    }

    public String getCommunicationMediaForReferenceCheck() {
        return communicationMediaForReferenceCheck;
    }

    public void setCommunicationMediaForReferenceCheck(String communicationMediaForReferenceCheck) {
        this.communicationMediaForReferenceCheck = communicationMediaForReferenceCheck;
    }

    public String getReferenceCheckInfoProviderName() {
        return referenceCheckInfoProviderName;
    }

    public void setReferenceCheckInfoProviderName(String referenceCheckInfoProviderName) {
        this.referenceCheckInfoProviderName = referenceCheckInfoProviderName;
    }

    public String getReferenceCheckInfoProviderAddress() {
        return referenceCheckInfoProviderAddress;
    }

    public void setReferenceCheckInfoProviderAddress(String referenceCheckInfoProviderAddress) {
        this.referenceCheckInfoProviderAddress = referenceCheckInfoProviderAddress;
    }

    public String getReferenceCheckInfoProviderMobile() {
        return referenceCheckInfoProviderMobile;
    }

    public void setReferenceCheckInfoProviderMobile(String referenceCheckInfoProviderMobile) {
        this.referenceCheckInfoProviderMobile = referenceCheckInfoProviderMobile;
    }

    public String getReferenceCheckInfoProvidingResult() {
        return referenceCheckInfoProvidingResult;
    }

    public void setReferenceCheckInfoProvidingResult(String referenceCheckInfoProvidingResult) {
        this.referenceCheckInfoProvidingResult = referenceCheckInfoProvidingResult;
    }
}
