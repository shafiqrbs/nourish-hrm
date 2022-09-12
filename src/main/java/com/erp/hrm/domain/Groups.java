package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "Groups" )
public class Groups extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "GroupCode")
    private String groupCode;

    @Size(max = 150)
    @Column(name = "GroupName")
    private String groupName;

    @Column(name = "Sequence")
    private int sequence;

    @Size(max = 250)
    @Column(name = "Notes")
    private String notes;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
