package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "SubSection" )
public class SubSection extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "SubSectionCode")
    private String subSectionCode;

    @Size(max = 150)
    @Column(name = "SubSectionName")
    private String subSectionName;

    @Column(name = "Sequence")
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionId", columnDefinition = "INT", foreignKey = @ForeignKey(name = "FK_Subsection_Section"), nullable = false)
    private Section section;

    @Size(max = 250)
    @Column(name = "Notes")
    private String notes;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

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

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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
