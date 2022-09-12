package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 12/05/2018.
 */
public class FloorDTO {

    private int id;
    private String floorCode;
    private String floorName;
    private int sequence;
    private String buildingName;
    private String notes;
    private boolean isDefault;

    public FloorDTO() {
    }

    public FloorDTO(int id, String floorCode, String floorName, int sequence, String buildingName, String notes, boolean isDefault) {
        this.id = id;
        this.floorCode = floorCode;
        this.floorName = floorName;
        this.sequence = sequence;
        this.buildingName = buildingName;
        this.notes = notes;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFloorCode() {
        return floorCode;
    }

    public void setFloorCode(String floorCode) {
        this.floorCode = floorCode;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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
