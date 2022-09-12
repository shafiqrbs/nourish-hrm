package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 19/05/2018.
 */
public class SubSectionDTO {

    private int id;
    private String subSectionCode;
    private String subSectionName;
    private int sequence;
    private String sectionName;
    private String notes;
    private boolean isDefault;

    public SubSectionDTO() {
    }

    public SubSectionDTO(int id, String subSectionCode, String subSectionName, int sequence, String sectionName, String notes, boolean isDefault) {
        this.id = id;
        this.subSectionCode = subSectionCode;
        this.subSectionName = subSectionName;
        this.sequence = sequence;
        this.sectionName = sectionName;
        this.notes = notes;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubSectionCode() {
        return subSectionCode;
    }

    public void setSubSectionCode(String subSectionCode) {
        this.subSectionCode = subSectionCode;
    }

    public String getSubSectionName() {
        return subSectionName;
    }

    public void setSubSectionName(String subSectionName) {
        this.subSectionName = subSectionName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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
