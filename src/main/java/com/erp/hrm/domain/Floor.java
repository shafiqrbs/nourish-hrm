package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "Floor" )
public class Floor extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "FloorCode")
    private String floorCode;

    @Size(max = 150)
    @Column(name = "FloorName")
    private String floorName;

    @Column(name = "Sequence")
    private int sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BuildingId", columnDefinition = "INT", foreignKey = @ForeignKey(name = "FK_Floor_Building"), nullable = false)
    private Building building;

    @Size(max = 250)
    @Column(name = "Notes")
    private String notes;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
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
