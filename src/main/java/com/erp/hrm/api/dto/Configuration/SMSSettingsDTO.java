package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 12/05/2018.
 */
public class SMSSettingsDTO {

    private int Id;
    private String SectionCode;
    private String SectionName;
    private String Sequence;
    private String CompanyName;
    private String Branch;
    private String Notes;

    public SMSSettingsDTO() {
    }

    public SMSSettingsDTO(int Id, String SectionCode, String SectionName, String Sequence, String CompanyName, String Branch, String Notes)
    {
        this.Id = Id;
        this.SectionCode = SectionCode;
        this.SectionName = SectionName;
        this.Sequence = Sequence;
        this.CompanyName = CompanyName;
        this.Branch = Branch;
        this.Notes = Notes;
    }

    public int getId(){
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSectionCode() {
        return SectionCode;
    }

    public void setSectionCode(String SectionCode) {
        this.SectionCode = SectionCode;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String Sequence) {
        this.Sequence = Sequence;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
}
