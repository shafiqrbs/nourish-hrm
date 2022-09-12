package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "EducationInfo" )
public class EducationInfo extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode",columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EducationInfo_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 200)
    @Column(name = "ExamName")
    private String ExamName;

    @Size(max = 200)
    @Column(name = "InstituteName")
    private String InstituteName;

    @Size(max = 100)
    @Column(name = "WhichGroup")
    private String WhichGroup;

    @Size(max = 100)
    @Column(name = "ExaminationRoll")
    private String ExaminationRoll;

    @Size(max = 100)
    @Column(name = "RegistrationNo")
    private String RegistrationNo;

    @Size(max = 50)
    @Column(name = "Result")
    private String Result;

    @Size(max = 100)
    @Column(name = "Country")
    private String Country;

    @Column(name = "ExamYear",columnDefinition = "INT CONSTRAINT DF_EducationInfo_ExamYear DEFAULT 0")
    private int ExamYear;

    @Size(max = 100)
    @Column(name = "Board")
    private String Board;

    @Size(max = 50)
    @Column(name = "CertNo")
    private String CertNo;

    @Column(name = "IsCGPA",nullable = true,columnDefinition = "BIT CONSTRAINT DF_EducationInfo_IsCGPA DEFAULT 0")
    private boolean IsCGPA;

    @Size(max = 50)
    @Column(name = "MarkAvail")
    private String MarkAvail;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getExamName() {
        return ExamName;
    }

    public void setExamName(String examName) {
        ExamName = examName;
    }

    public String getInstituteName() {
        return InstituteName;
    }

    public void setInstituteName(String instituteName) {
        InstituteName = instituteName;
    }

    public String getWhichGroup() {
        return WhichGroup;
    }

    public void setWhichGroup(String whichGroup) {
        WhichGroup = whichGroup;
    }

    public String getExaminationRoll() {
        return ExaminationRoll;
    }

    public void setExaminationRoll(String examinationRoll) {
        ExaminationRoll = examinationRoll;
    }

    public String getRegistrationNo() {
        return RegistrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        RegistrationNo = registrationNo;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getExamYear() {
        return ExamYear;
    }

    public void setExamYear(int examYear) {
        ExamYear = examYear;
    }

    public String getBoard() {
        return Board;
    }

    public void setBoard(String board) {
        Board = board;
    }

    public String getCertNo() {
        return CertNo;
    }

    public void setCertNo(String certNo) {
        CertNo = certNo;
    }

    public boolean isCGPA() {
        return IsCGPA;
    }

    public void setCGPA(boolean CGPA) {
        IsCGPA = CGPA;
    }

    public String getMarkAvail() {
        return MarkAvail;
    }

    public void setMarkAvail(String markAvail) {
        MarkAvail = markAvail;
    }
}
