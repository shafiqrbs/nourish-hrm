package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "Building" )
public class Building extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "BuildingCode")
    private String BuildingCode;

    @Size(max = 150)
    @Column(name = "BuildingName")
    private String BuildingName;

    @Column(name = "Sequence")
    private int Sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CompanyId", columnDefinition = "INT", foreignKey = @ForeignKey(name = "FK_Building_CompanySettings"), nullable = false)
    private CompanySettings companySettings;

    @Size(max = 250)
    @Column(name = "Address")
    private String Address;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Floor> floors;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

    public String getBuildingCode() {
        return BuildingCode;
    }

    public void setBuildingCode(String BuildingCode) {
        this.BuildingCode = BuildingCode;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public void setBuildingName(String BuildingName) {
        this.BuildingName = BuildingName;
    }

    public int getSequence() {
        return Sequence;
    }

    public void setSequence(int Sequence) {
        this.Sequence = Sequence;
    }

    public CompanySettings getCompanySettings() {
        return companySettings;
    }

    public void setCompanySettings(CompanySettings companySettings) {
        this.companySettings = companySettings;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Set<Floor> getFloors() {
        return floors;
    }

    public void setFloors(Set<Floor> floors) {
        this.floors = floors;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
