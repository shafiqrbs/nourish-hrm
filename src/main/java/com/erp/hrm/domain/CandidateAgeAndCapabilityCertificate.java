package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 29/12/2018.
 */
@Entity
@Table( name = "CandidateAgeAndCapabilityCertificate" )
public class CandidateAgeAndCapabilityCertificate extends BaseIntEntity {

    @Column(name = "CertificateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date certificateDate;

    @Size(max = 50)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Size(max = 20)
    @Column(name = "CandidateHeight")
    private String candidateHeight;

    @Size(max = 20)
    @Column(name = "candidateWeight")
    private String candidateWeight;

    @Size(max = 20)
    @Column(name = "candidateAge")
    private String candidateAge;

    @Size(max = 100)
    @Column(name = "CandidateDentalStructure")
    private String candidateDentalStructure;

    @Size(max = 100)
    @Column(name = "candidatePeriodForWomen")
    private String candidatePeriodForWomen;

    @Size(max = 100)
    @Column(name = "candidateBeardForBoy")
    private String candidateBeardForBoy;

    @Size(max = 32)
    @Column(name = "candidateOthersInfo")
    private String candidateOthersInfo;

    @Size(max = 256)
    @Column(name = "doctorsOpinion")
    private String doctorsOpinion;

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
