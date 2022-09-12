package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "Section" )
public class Section extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "SectionCode")
    private String sectionCode;

    @Size(max = 150)
    @Column(name = "SectionName")
    private String sectionName;

    @Column(name = "Sequence")
    private int sequence;

    @Size(max = 250)
    @Column(name = "Notes")
    private String notes;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

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
