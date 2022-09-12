package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 29/12/2018.
 */
@Entity
@Table( name = "CandidateAddictionCertificate" )
public class CandidateAddictionCertificate extends BaseIntEntity {

    @Column(name = "CertificateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date certificateDate;

    @Size(max = 50)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Column(name = "isCheckTeethAndGum",columnDefinition = "BIT DEFAULT 0")
    private boolean isCheckTeethAndGum;

    @Column(name = "isCheckTongueAndLip",columnDefinition = "BIT DEFAULT 0")
    private boolean isCheckTongueAndLip;

    @Column(name = "isCheckEye",columnDefinition = "BIT DEFAULT 0")
    private boolean isCheckEye;

    @Column(name = "isOtherSign",columnDefinition = "BIT DEFAULT 0")
    private boolean isOtherSign;

    @Size(max = 256)
    @Column(name = "doctorsOpinion")
    private String doctorsOpinion;

    @Size(max = 256)
    @Column(name = "nurseOpinion")
    private String nurseOpinion;

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
