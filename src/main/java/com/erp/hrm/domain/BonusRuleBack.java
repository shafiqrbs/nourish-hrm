package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "BonusRuleBack" )
public class BonusRuleBack extends BaseEntity {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BonusRuleBackID")
    private double BonusRuleBackID;

    @Size(max = 20)
    @NotNull
    @Column(name = "BonusCode")
    private String BonusCode;

    @NotNull
    @Column(name = "BonusRuleID")
    private double BonusRuleID;

    @Size(max = 10)
    @Column(name = "sCriteria")
    private String sCriteria;

    @Size(max = 20)
    @Column(name = "ParentHeadID")
    private String ParentHeadID;

    @Column(name = "ParentHeadValue")
    private double ParentHeadValue;

    @Size(max = 20)
    @Column(name = "PartialHeadID")
    private String PartialHeadID;

    @Column(name = "PartialHeadValue")
    private double PartialHeadValue;

    @Column(name = "IsFixed")
    private boolean IsFixed;

    @Column(name = "IsHigher")
    private boolean IsHigher;

    @Size(max = 8000)
    @Column(name = "Formula1")
    private String Formula1;

    @Size(max = 8000)
    @Column(name = "Formula2")
    private String Formula2;

    public double getBonusRuleBackID() {
        return BonusRuleBackID;
    }

    public void setBonusRuleBackID(double BonusRuleBackID) {
        this.BonusRuleBackID = BonusRuleBackID;
    }

    public String getBonusCode() {
        return BonusCode;
    }

    public void setBonusCode(String BonusCode) {
        this.BonusCode = BonusCode;
    }

    public double getBonusRuleID() {
        return BonusRuleID;
    }

    public void setBonusRuleID(double BonusRuleID) {
        this.BonusRuleID = BonusRuleID;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public String getParentHeadID() {
        return ParentHeadID;
    }

    public void setParentHeadID(String ParentHeadID) {
        this.ParentHeadID = ParentHeadID;
    }

    public double getParentHeadValue() {
        return ParentHeadValue;
    }

    public void setParentHeadValue(double ParentHeadValue) {
        this.ParentHeadValue = ParentHeadValue;
    }

    public String getPartialHeadID() {
        return PartialHeadID;
    }

    public void setPartialHeadID(String PartialHeadID) {
        this.PartialHeadID = PartialHeadID;
    }

    public double getPartialHeadValue() {
        return PartialHeadValue;
    }

    public void setPartialHeadValue(double PartialHeadValue) {
        this.PartialHeadValue = PartialHeadValue;
    }

    public boolean getIsFixed() {
        return IsFixed;
    }

    public void setIsFixed(boolean IsFixed) {
        this.IsFixed = IsFixed;
    }

    public boolean getIsHigher() {
        return IsHigher;
    }

    public void setIsHigher(boolean IsHigher) {
        this.IsHigher = IsHigher;
    }

    public String getFormula1() {
        return Formula1;
    }

    public void setFormula1(String Formula1) {
        this.Formula1 = Formula1;
    }

    public String getFormula2() {
        return Formula2;
    }

    public void setFormula2(String Formula2) {
        this.Formula2 = Formula2;
    }
}
