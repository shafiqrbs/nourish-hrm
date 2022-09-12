package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 17/05/2018.
 */
public class LineDTO {

    private int id;
    private String lineCode;
    private String lineName;
    private int sequence;
    private String floorName;
    private String notes;
    private boolean isDefault;

    public LineDTO() {
    }

    public LineDTO(int id, String lineCode, String lineName, int sequence, String floorName, String notes, boolean isDefault) {
        this.id = id;
        this.lineCode = lineCode;
        this.lineName = lineName;
        this.sequence = sequence;
        this.floorName = floorName;
        this.notes = notes;
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
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
