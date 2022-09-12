package com.erp.hrm.api.dto.recruitment;

import java.util.Date;

/**
 * Created by Sohag on 29/12/2018.
 */
public class CandidateFitnessCertificateDTO {
    private int id;
    private Date certificateDate;
    private String employeeCode;
    private String candidateName;
    private String candidateFatherName;
    private String candidateSpouseName;
    private String doctorsOpinion;
    private String nurseOpinion;

    public CandidateFitnessCertificateDTO() {
    }

    public CandidateFitnessCertificateDTO(int id,Date certificateDate, String employeeCode, String candidateName, String candidateFatherName, String candidateSpouseName, String doctorsOpinion, String nurseOpinion) {
        this.id = id;
        this.certificateDate = certificateDate;
        this.employeeCode = employeeCode;
        this.candidateName = candidateName;
        this.candidateFatherName = candidateFatherName;
        this.candidateSpouseName = candidateSpouseName;
        this.doctorsOpinion = doctorsOpinion;
        this.nurseOpinion = nurseOpinion;
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

    public String getDoctorsOpinion() {
        return doctorsOpinion;
    }

    public void setDoctorsOpinion(String doctorsOpinion) {
        this.doctorsOpinion = doctorsOpinion;
    }

    public String getNurseOpinion() {
        return nurseOpinion;
    }

    public void setNurseOpinion(String nurseOpinion) {
        this.nurseOpinion = nurseOpinion;
    }
}
