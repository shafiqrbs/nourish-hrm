package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 19/05/2018.
 */
public class SubGroupDTO {

    private int id;
    private String subGroupCode;
    private String subGroupName;
    private int sequence;
    private String groupName;
    private String notes;
    private boolean isDefault;

    public SubGroupDTO() {
    }

    public SubGroupDTO(int id, String subGroupCode, String subGroupName, int sequence, String groupName, String notes, boolean isDefault) {
        this.id = id;
        this.subGroupCode = subGroupCode;
        this.subGroupName = subGroupName;
        this.sequence = sequence;
        this.groupName = groupName;
        this.notes = notes;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
