package com.erp.hrm.api.dto.recruitment;
import java.util.Date;

/**
 * Created by Sohag on 29/12/2018.
 */
public class CandidateAgeAndCapabilityCertificateDTO {

    private int id;
    private Date certificateDate;
    private String employeeCode;
    private String candidateName;
    private String candidateFatherName;
    private String candidateSpouseName;
    private String candidatePresentAddress;
    private String candidateCardNo;
    private String candidateDesignation;
    private Date candidateDOB;
    private String candidateHeight;
    private String candidateWeight;
    private String candidateAge;
    private String candidateDentalStructure;
    private String candidatePeriodForWomen;
    private String candidateBeardForBoy;
    private String candidateOthersInfo;
    private String doctorsOpinion;

    public CandidateAgeAndCapabilityCertificateDTO() {
    }

    public CandidateAgeAndCapabilityCertificateDTO(int id,Date certificateDate, String employeeCode, String candidateName, String candidateFatherName, String candidateSpouseName, String candidatePresentAddress, String candidateCardNo, String candidateDesignation, Date candidateDOB, String candidateHeight, String candidateWeight, String candidateAge, String candidateDentalStructure, String candidatePeriodForWomen, String candidateBeardForBoy, String candidateOthersInfo, String doctorsOpinion) {
        this.id = id;
        this.certificateDate = certificateDate;
        this.employeeCode = employeeCode;
        this.candidateName = candidateName;
        this.candidateFatherName = candidateFatherName;
        this.candidateSpouseName = candidateSpouseName;
        this.candidatePresentAddress = candidatePresentAddress;
        this.candidateCardNo = candidateCardNo;
        this.candidateDesignation = candidateDesignation;
        this.candidateDOB = candidateDOB;
        this.candidateHeight = candidateHeight;
        this.candidateWeight = candidateWeight;
        this.candidateAge = candidateAge;
        this.candidateDentalStructure = candidateDentalStructure;
        this.candidatePeriodForWomen = candidatePeriodForWomen;
        this.candidateBeardForBoy = candidateBeardForBoy;
        this.candidateOthersInfo = candidateOthersInfo;
        this.doctorsOpinion = doctorsOpinion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
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

    public String getCandidateFatherName() {
        return candidateFatherName;
    }

    public void setCandidateFatherName(String candidateFatherName) {
        this.candidateFatherName = candidateFatherName;
    }

    public String getCandidateSpouseName() {
        return candidateSpouseName;
    }

    public void setCandidateSpouseName(String candidateSpouseName) {
        this.candidateSpouseName = candidateSpouseName;
    }

    public String getCandidatePresentAddress() {
        return candidatePresentAddress;
    }

    public void setCandidatePresentAddress(String candidatePresentAddress) {
        this.candidatePresentAddress = candidatePresentAddress;
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

    public Date getCandidateDOB() {
        return candidateDOB;
    }

    public void setCandidateDOB(Date candidateDOB) {
        this.candidateDOB = candidateDOB;
    }

    public String getCandidateHeight() {
        return candidateHeight;
    }

    public void setCandidateHeight(String candidateHeight) {
        this.candidateHeight = candidateHeight;
    }

    public String getCandidateWeight() {
        return candidateWeight;
    }

    public void setCandidateWeight(String candidateWeight) {
        this.candidateWeight = candidateWeight;
    }

    public String getCandidateAge() {
        return candidateAge;
    }

    public void setCandidateAge(String candidateAge) {
        this.candidateAge = candidateAge;
    }

    public String getCandidateDentalStructure() {
        return candidateDentalStructure;
    }

    public void setCandidateDentalStructure(String candidateDentalStructure) {
        this.candidateDentalStructure = candidateDentalStructure;
    }

    public String getCandidatePeriodForWomen() {
        return candidatePeriodForWomen;
    }

    public void setCandidatePeriodForWomen(String candidatePeriodForWomen) {
        this.candidatePeriodForWomen = candidatePeriodForWomen;
    }

    public String getCandidateBeardForBoy() {
        return candidateBeardForBoy;
    }

    public void setCandidateBeardForBoy(String candidateBeardForBoy) {
        this.candidateBeardForBoy = candidateBeardForBoy;
    }

    public String getCandidateOthersInfo() {
        return candidateOthersInfo;
    }

    public void setCandidateOthersInfo(String candidateOthersInfo) {
        this.candidateOthersInfo = candidateOthersInfo;
    }

    public String getDoctorsOpinion() {
        return doctorsOpinion;
    }

    public void setDoctorsOpinion(String doctorsOpinion) {
        this.doctorsOpinion = doctorsOpinion;
    }
}
