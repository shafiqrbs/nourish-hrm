package com.erp.hrm.api.dto.recruitment;


import java.util.Date;

public class InterviewCardDTO {

    private Date interviewDate;
    private String employeeTempCode;
    private String candidateName;
    private boolean isGivenFN;
    private String fatherName;
    private String spouseName;
    private String applyForPosition;
    private Date dateOfBirth;
    private boolean isNIDSubmit;
    private boolean isBirthDateCertSubmit;
    private boolean isChairmanCertSubmit;
    private String others;
    private String behave;

    public InterviewCardDTO() {
    }

    public InterviewCardDTO(Date interviewDate,String employeeTempCode, String candidateName, boolean isGivenFN, String fatherName, String spouseName, String applyForPosition, Date dateOfBirth, boolean isNIDSubmit, boolean isBirthDateCertSubmit, boolean isChairmanCertSubmit, String others, String behave) {
        this.interviewDate = interviewDate;
        this.employeeTempCode = employeeTempCode;
        this.candidateName = candidateName;
        this.isGivenFN = isGivenFN;
        this.fatherName = fatherName;
        this.spouseName = spouseName;
        this.applyForPosition = applyForPosition;
        this.dateOfBirth = dateOfBirth;
        this.isNIDSubmit = isNIDSubmit;
        this.isBirthDateCertSubmit = isBirthDateCertSubmit;
        this.isChairmanCertSubmit = isChairmanCertSubmit;
        this.others = others;
        this.behave = behave;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public String getEmployeeTempCode() {
        return employeeTempCode;
    }

    public void setEmployeeTempCode(String employeeTempCode) {
        this.employeeTempCode = employeeTempCode;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public boolean isGivenFN() {
        return isGivenFN;
    }

    public void setGivenFN(boolean givenFN) {
        this.isGivenFN = givenFN;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getApplyForPosition() {
        return applyForPosition;
    }

    public void setApplyForPosition(String applyForPosition) {
        this.applyForPosition = applyForPosition;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isNIDSubmit() {
        return isNIDSubmit;
    }

    public void setNIDSubmit(boolean NIDSubmit) {
        this.isNIDSubmit = NIDSubmit;
    }

    public boolean isBirthDateCertSubmit() {
        return isBirthDateCertSubmit;
    }

    public void setBirthDateCertSubmit(boolean birthDateCertSubmit) {
        this.isBirthDateCertSubmit = birthDateCertSubmit;
    }

    public boolean isChairmanCertSubmit() {
        return isChairmanCertSubmit;
    }

    public void setChairmanCertSubmit(boolean chairmanCertSubmit) {
        this.isChairmanCertSubmit = chairmanCertSubmit;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getBehave() {
        return behave;
    }

    public void setBehave(String behave) {
        this.behave = behave;
    }
}
