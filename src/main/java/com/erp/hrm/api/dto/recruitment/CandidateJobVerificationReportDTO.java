package com.erp.hrm.api.dto.recruitment;

import java.util.Date;

/**
 * Created by Sohag on 27/01/2019.
 */
public class CandidateJobVerificationReportDTO {

    private int id;
    private String employeeCode;
    private String candidateName;
    private String candidateCardNo;
    private String candidateDesignation;
    private String candidateBranch;
    private Date candidateJoiningDate;
    private String candidateLine;
    private String mobileNo;

    private String permanentCO;
    private String permanentVillage;
    private String permanentPO;
    private String permanentPS;
    private String permanentDistrict;

    private String presentCO;
    private String presentVillage;
    private String presentPO;
    private String presentPS;
    private String presentDistrict;

    private String isContactedWithLastCompany;
    private String communicationMediaWithLastCompany;
    private String lastCompanyName;
    private String lastCompanyAddress;
    private String lastCompanyDesignation;
    private String lastSection;
    private String lastJobPeriod;
    private String lastEmploymentResult;
    private String isContactedWithReference;
    private String communicationMediaWithReference;
    private String referenceInfoProviderName;
    private String referencePosition;
    private String referenceMobileNo;
    private String referenceResult;
    private String isContactedForCriminalBackground;
    private String communicationMediaWithPolice;
    private String criminalInfoProviderName;
    private String criminalInfoProviderPosition;
    private Date criminalInfoProvidingDate;
    private String criminalInfoProvidingResult;
    private String isContactedForReferenceCheck;
    private String communicationMediaForReferenceCheck;
    private String referenceCheckInfoProviderName;
    private String referenceCheckInfoProviderAddress;
    private String referenceCheckInfoProviderMobile;
    private String referenceCheckInfoProvidingResult;

    public CandidateJobVerificationReportDTO() {
    }

    public CandidateJobVerificationReportDTO(int id, String employeeCode, String candidateName, String candidateCardNo, String candidateDesignation, String candidateBranch, Date candidateJoiningDate, String candidateLine, String mobileNo, String permanentCO, String permanentVillage, String permanentPO, String permanentPS, String permanentDistrict, String presentCO, String presentVillage, String presentPO, String presentPS, String presentDistrict, String isContactedWithLastCompany, String communicationMediaWithLastCompany, String lastCompanyName, String lastCompanyAddress, String lastCompanyDesignation, String lastSection, String lastJobPeriod, String lastEmploymentResult, String isContactedWithReference, String communicationMediaWithReference, String referenceInfoProviderName, String referencePosition, String referenceMobileNo, String referenceResult, String isContactedForCriminalBackground, String communicationMediaWithPolice, String criminalInfoProviderName, String criminalInfoProviderPosition, Date criminalInfoProvidingDate, String criminalInfoProvidingResult, String isContactedForReferenceCheck, String communicationMediaForReferenceCheck, String referenceCheckInfoProviderName, String referenceCheckInfoProviderAddress, String referenceCheckInfoProviderMobile, String referenceCheckInfoProvidingResult) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.candidateName = candidateName;
        this.candidateCardNo = candidateCardNo;
        this.candidateDesignation = candidateDesignation;
        this.candidateBranch = candidateBranch;
        this.candidateJoiningDate = candidateJoiningDate;
        this.candidateLine = candidateLine;
        this.mobileNo = mobileNo;
        this.permanentCO = permanentCO;
        this.permanentVillage = permanentVillage;
        this.permanentPO = permanentPO;
        this.permanentPS = permanentPS;
        this.permanentDistrict = permanentDistrict;
        this.presentCO = presentCO;
        this.presentVillage = presentVillage;
        this.presentPO = presentPO;
        this.presentPS = presentPS;
        this.presentDistrict = presentDistrict;
        this.isContactedWithLastCompany = isContactedWithLastCompany;
        this.communicationMediaWithLastCompany = communicationMediaWithLastCompany;
        this.lastCompanyName = lastCompanyName;
        this.lastCompanyAddress = lastCompanyAddress;
        this.lastCompanyDesignation = lastCompanyDesignation;
        this.lastSection = lastSection;
        this.lastJobPeriod = lastJobPeriod;
        this.lastEmploymentResult = lastEmploymentResult;
        this.isContactedWithReference = isContactedWithReference;
        this.communicationMediaWithReference = communicationMediaWithReference;
        this.referenceInfoProviderName = referenceInfoProviderName;
        this.referencePosition = referencePosition;
        this.referenceMobileNo = referenceMobileNo;
        this.referenceResult = referenceResult;
        this.isContactedForCriminalBackground = isContactedForCriminalBackground;
        this.communicationMediaWithPolice = communicationMediaWithPolice;
        this.criminalInfoProviderName = criminalInfoProviderName;
        this.criminalInfoProviderPosition = criminalInfoProviderPosition;
        this.criminalInfoProvidingDate = criminalInfoProvidingDate;
        this.criminalInfoProvidingResult = criminalInfoProvidingResult;
        this.isContactedForReferenceCheck = isContactedForReferenceCheck;
        this.communicationMediaForReferenceCheck = communicationMediaForReferenceCheck;
        this.referenceCheckInfoProviderName = referenceCheckInfoProviderName;
        this.referenceCheckInfoProviderAddress = referenceCheckInfoProviderAddress;
        this.referenceCheckInfoProviderMobile = referenceCheckInfoProviderMobile;
        this.referenceCheckInfoProvidingResult = referenceCheckInfoProvidingResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateCardNo() {
        return candidateCardNo;
    }

    public void setCandidateCardNo(String candidateCardNo) {
        this.candidateCardNo = candidateCardNo;
    }

    public String getCandidateDesignation() {
        return candidateDesignation;
    }

    public void setCandidateDesignation(String candidateDesignation) {
        this.candidateDesignation = candidateDesignation;
    }

    public String getCandidateBranch() {
        return candidateBranch;
    }

    public void setCandidateBranch(String candidateBranch) {
        this.candidateBranch = candidateBranch;
    }

    public Date getCandidateJoiningDate() {
        return candidateJoiningDate;
    }

    public void setCandidateJoiningDate(Date candidateJoiningDate) {
        this.candidateJoiningDate = candidateJoiningDate;
    }

    public String getCandidateLine() {
        return candidateLine;
    }

    public void setCandidateLine(String candidateLine) {
        this.candidateLine = candidateLine;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getPermanentCO() {
        return permanentCO;
    }

    public void setPermanentCO(String permanentCO) {
        this.permanentCO = permanentCO;
    }

    public String getPermanentVillage() {
        return permanentVillage;
    }

    public void setPermanentVillage(String permanentVillage) {
        this.permanentVillage = permanentVillage;
    }

    public String getPermanentPO() {
        return permanentPO;
    }

    public void setPermanentPO(String permanentPO) {
        this.permanentPO = permanentPO;
    }

    public String getPermanentPS() {
        return permanentPS;
    }

    public void setPermanentPS(String permanentPS) {
        this.permanentPS = permanentPS;
    }

    public String getPermanentDistrict() {
        return permanentDistrict;
    }

    public void setPermanentDistrict(String permanentDistrict) {
        this.permanentDistrict = permanentDistrict;
    }

    public String getPresentCO() {
        return presentCO;
    }

    public void setPresentCO(String presentCO) {
        this.presentCO = presentCO;
    }

    public String getPresentVillage() {
        return presentVillage;
    }

    public void setPresentVillage(String presentVillage) {
        this.presentVillage = presentVillage;
    }

    public String getPresentPO() {
        return presentPO;
    }

    public void setPresentPO(String presentPO) {
        this.presentPO = presentPO;
    }

    public String getPresentPS() {
        return presentPS;
    }

    public void setPresentPS(String presentPS) {
        this.presentPS = presentPS;
    }

    public String getPresentDistrict() {
        return presentDistrict;
    }

    public void setPresentDistrict(String presentDistrict) {
        this.presentDistrict = presentDistrict;
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
