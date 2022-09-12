package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 12/05/2018.
 */
public class GroupsDTO {

    private int id;
    private String groupCode;
    private String groupName;
    private int sequence;
    private String notes;
    private boolean isDefault;

    public GroupsDTO() {
    }

    public GroupsDTO(int id, String groupCode, String groupName, int sequence, String notes, boolean isDefault) {
        this.id = id;
        this.groupCode = groupCode;
        this.groupName = groupName;
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
