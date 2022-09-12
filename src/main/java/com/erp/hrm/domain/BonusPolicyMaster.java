package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "BonusPolicyMaster" )
public class BonusPolicyMaster extends BaseByOnEntity {

    @Id
    @Size(max = 50)
    @NotNull
    @Column(name = "BonusCode",nullable = false)
    private String bonusCode;

    @Size(max = 500)
    @Column(name = "Description")
    private String description;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive;

    @Size(max = 50)
    @Column(name = "AvailFrom",nullable = false)
    private String availFrom;

    @Column(name = "CalculationAfter",nullable = false, columnDefinition = "INT CONSTRAINT DF_BonusPolicyMaster_CalculationAfter  DEFAULT 0")
    private int calculationAfter;

    @Column(name = "IsProcessApproved",nullable = false)
    private boolean isProcessApproved;

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getAvailFrom() {
        return availFrom;
    }

    public void setAvailFrom(String availFrom) {
        this.availFrom = availFrom;
    }

    public int getCalculationAfter() {
        return calculationAfter;
    }

    public void setCalculationAfter(int calculationAfter) {
        this.calculationAfter = calculationAfter;
    }

    public boolean isProcessApproved() {
        return isProcessApproved;
    }

    public void setProcessApproved(boolean processApproved) {
        this.isProcessApproved = processApproved;
    }
}
