package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 12/05/2018.
 */
public class SectionDTO {

    private int id;
    private String sectionCode;
    private String sectionName;
    private int sequence;
    private String notes;
    private boolean isDefault;

    public SectionDTO() {
    }

    public SectionDTO(int id, String sectionCode, String sectionName, int sequence, String notes, boolean isDefault) {
        this.id = id;
        this.sectionCode = sectionCode;
        this.sectionName = sectionName;
        this.sequence = sequence;
        this.notes = notes;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(String sectionCode) {
        this.sectionCode = sectionCode;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
