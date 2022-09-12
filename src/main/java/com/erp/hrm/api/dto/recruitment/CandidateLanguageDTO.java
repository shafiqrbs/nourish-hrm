package com.erp.hrm.api.dto.recruitment;

public class CandidateLanguageDTO {
    private Long Id;
    private String employeeCode;
    private String languageName;
    private String writing;
    private String reading;
    private String spoken;
    private String listening;
    private boolean motherLanguage;
    private String notes;

    public CandidateLanguageDTO() {
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getSpoken() {
        return spoken;
    }

    public void setSpoken(String spoken) {
        this.spoken = spoken;
    }

    public String getListening() {
        return listening;
    }

    public void setListening(String listening) {
        this.listening = listening;
    }

    public boolean isMotherLanguage() {
        return motherLanguage;
    }

    public void setMotherLanguage(boolean motherLanguage) {
        this.motherLanguage = motherLanguage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
