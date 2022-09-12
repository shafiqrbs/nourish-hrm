package com.erp.hrm.api.dto.recruitment;

import com.erp.hrm.domain.BaseIntEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 29/12/2018.
 */
public class CandidateAddictionCertificateDTO extends BaseIntEntity {
    private int id;
    private Date certificateDate;
    private String employeeCode;
    private String candidateName;
    private String candidateFatherName;
    private String candidateSpouseName;
    private boolean isCheckTeethAndGum;
    private boolean isCheckTongueAndLip;
    private boolean isCheckEye;
    private boolean isOtherSign;
    private String doctorsOpinion;
    private String nurseOpinion;

    public CandidateAddictionCertificateDTO() {
    }

    public CandidateAddictionCertificateDTO(int id,Date certificateDate, String employeeCode, String candidateName, String candidateFatherName, String candidateSpouseName, boolean isCheckTeethAndGum, boolean isCheckTongueAndLip, boolean isCheckEye, boolean isOtherSign, String doctorsOpinion, String nurseOpinion) {
        this.id = id;
        this.certificateDate = certificateDate;
        this.employeeCode = employeeCode;
        this.candidateName = candidateName;
        this.candidateFatherName = candidateFatherName;
        this.candidateSpouseName = candidateSpouseName;
        this.isCheckTeethAndGum = isCheckTeethAndGum;
        this.isCheckTongueAndLip = isCheckTongueAndLip;
        this.isCheckEye = isCheckEye;
        this.isOtherSign = isOtherSign;
        this.doctorsOpinion = doctorsOpinion;
        this.nurseOpinion = nurseOpinion;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
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

    public boolean isCheckTeethAndGum() {
        return isCheckTeethAndGum;
    }

    public void setCheckTeethAndGum(boolean checkTeethAndGum) {
        isCheckTeethAndGum = checkTeethAndGum;
    }

    public boolean isCheckTongueAndLip() {
        return isCheckTongueAndLip;
    }

    public void setCheckTongueAndLip(boolean checkTongueAndLip) {
        isCheckTongueAndLip = checkTongueAndLip;
    }

    public boolean isCheckEye() {
        return isCheckEye;
    }

    public void setCheckEye(boolean checkEye) {
        isCheckEye = checkEye;
    }

    public boolean isOtherSign() {
        return isOtherSign;
    }

    public void setOtherSign(boolean otherSign) {
        isOtherSign = otherSign;
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
