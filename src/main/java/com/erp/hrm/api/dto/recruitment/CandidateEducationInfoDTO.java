package com.erp.hrm.api.dto.recruitment;

public class CandidateEducationInfoDTO {
    private Long id;
    private String employeeCode;
    private String examName;
    private String instituteName;
    private String whichGroup;
    private String examinationRoll;
    private String registrationNo;
    private String result;
    private String country;
    private int examYear;

   /* private String Board;
    private String CertNo;
    private boolean IsCGPA;
    private String MarkAvail;*/

    public CandidateEducationInfoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getWhichGroup() {
        return whichGroup;
    }

    public void setWhichGroup(String whichGroup) {
        this.whichGroup = whichGroup;
    }

    public String getExaminationRoll() {
        return examinationRoll;
    }

    public void setExaminationRoll(String examinationRoll) {
        this.examinationRoll = examinationRoll;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getExamYear() {
        return examYear;
    }

    public void setExamYear(int examYear) {
        this.examYear = examYear;
    }
}
