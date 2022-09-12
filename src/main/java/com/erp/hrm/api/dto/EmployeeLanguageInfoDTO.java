package com.erp.hrm.api.dto;

public class EmployeeLanguageInfoDTO {
    private String EmployeeCode;
    private String Language;
    private String Listening;
    private String Reading;
    private String Writing;
    private String Speaking;
    private String Notes;

    public EmployeeLanguageInfoDTO() {

    }

    public EmployeeLanguageInfoDTO(String employeeCode, String language, String listening, String reading, String writing, String speaking, String notes) {
        EmployeeCode = employeeCode;
        Language = language;
        Listening = listening;
        Reading = reading;
        Writing = writing;
        Speaking = speaking;
        Notes = notes;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getListening() {
        return Listening;
    }

    public void setListening(String listening) {
        Listening = listening;
    }

    public String getReading() {
        return Reading;
    }

    public void setReading(String reading) {
        Reading = reading;
    }

    public String getWriting() {
        return Writing;
    }

    public void setWriting(String writing) {
        Writing = writing;
    }

    public String getSpeaking() {
        return Speaking;
    }

    public void setSpeaking(String speaking) {
        Speaking = speaking;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
