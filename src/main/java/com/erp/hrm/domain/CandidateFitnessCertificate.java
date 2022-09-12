package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 29/12/2018.
 */
@Entity
@Table( name = "CandidateFitnessCertificate" )
public class CandidateFitnessCertificate extends BaseIntEntity {

    @Column(name = "CertificateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date certificateDate;

    @Size(max = 50)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

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
