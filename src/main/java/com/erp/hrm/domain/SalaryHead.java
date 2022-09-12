package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "SalaryHead", uniqueConstraints = { @UniqueConstraint( name = "UK_SalaryHead",columnNames = { "SalaryHeadID" } ) } )
public class SalaryHead extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryHeadID")
    private String SalaryHeadID;

    @Size(max = 50)
    @Column(name = "Descriptions")
    private String Descriptions;

    @Size(max = 5)
    @Column(name = "HeadType")
    private String HeadType;

    @Column(name = "SequenceNo")
    private int SequenceNo;

    @NotNull
    @Column(name = "IsVisible",nullable = false, columnDefinition = "BIT CONSTRAINT DF_SalaryHead_IsVisible DEFAULT 1")
    private boolean IsVisible;

    @NotNull
    @Column(name = "IsDisburse",nullable = false, columnDefinition = "BIT CONSTRAINT DF_SalaryHead_IsDisburse DEFAULT 0")
    private boolean IsDisburse;

    @NotNull
    @Column(name = "IsPerquisite",nullable = false, columnDefinition = "BIT CONSTRAINT DF_SalaryHead_IsPerquisite DEFAULT 0")
    private boolean IsPerquisite;

    @Size(max = 20)
    @Column(name = "SalaryHeadShortName")
    private String SalaryHeadShortName;

    public String getSalaryHeadID() {
        return SalaryHeadID;
    }

    public void setSalaryHeadID(String SalaryHeadID) {
        this.SalaryHeadID = SalaryHeadID;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String Descriptions) {
        this.Descriptions = Descriptions;
    }

    public String getHeadType() {
        return HeadType;
    }

    public void setHeadType(String HeadType) {
        this.HeadType = HeadType;
    }

    public int getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(int SequenceNo) {
        this.SequenceNo = SequenceNo;
    }

    public boolean getIsVisible() {
        return IsVisible;
    }

    public void setIsVisible(boolean IsVisible) {
        this.IsVisible = IsVisible;
    }

    public boolean getIsDisburse() {
        return IsDisburse;
    }

    public void setIsDisburse(boolean IsDisburse) {
        this.IsDisburse = IsDisburse;
    }

    public boolean getIsPerquisite() {
        return IsPerquisite;
    }

    public void setIsPerquisite(boolean IsPerquisite) {
        this.IsPerquisite = IsPerquisite;
    }

    public String getSalaryHeadShortName(){
        return SalaryHeadShortName;
    }

    public void setSalaryHeadShortName(String SalaryHeadShortName){
        this.SalaryHeadShortName=SalaryHeadShortName;
    }
}
