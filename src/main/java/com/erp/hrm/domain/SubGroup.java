package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "SubGroup" )
public class SubGroup extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "SubGroupCode")
    private String subGroupCode;

    @Size(max = 150)
    @Column(name = "SubGroupName")
    private String subGroupName;

    @Column(name = "Sequence")
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId", columnDefinition = "INT", foreignKey = @ForeignKey(name = "FK_SubGroups_Groups"), nullable = false)
    private Groups groups;

    @Size(max = 250)
    @Column(name = "Notes")
    private String notes;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

    public String getSubGroupCode() {
        return subGroupCode;
    }

    public void setSubGroupCode(String subGroupCode) {
        this.subGroupCode = subGroupCode;
    }

    public String getSubGroupName() {
        return subGroupName;
    }

    public void setSubGroupName(String subGroupName) {
        this.subGroupName = subGroupName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
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
