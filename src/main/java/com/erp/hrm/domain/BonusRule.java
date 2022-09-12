package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "BonusRule" )
public class BonusRule extends BaseEntity {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BonusRuleID")
    private double BonusRuleID;

    @Size(max = 20)
    @NotNull
    @Column(name = "BonusCode")
    private String BonusCode;

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

    @Column(name = "IsHigher")
    private boolean IsHigher;

    @Size(max = 8000)
    @Column(name = "Formula1")
    private String Formula1;

    @Size(max = 8000)
    @Column(name = "Formula2")
    private String Formula2;

    @Column(name = "MinServiceLen")
    private double MinServiceLen;

    @Column(name = "MaxServiceLen")
    private double MaxServiceLen;

    @Column(name = "HKEntryID")
    private double HKEntryID;

    @Column(name = "MenuID")
    private double MenuID;

    @Size(max = 50)
    @Column(name = "CriteriaName")
    private String CriteriaName;

    @Size(max = 50)
    @Column(name = "CriteriaValue")
    private String CriteriaValue;

    @Column(name = "IsProportionate")
    private boolean IsProportionate;

    public double getBonusRuleID() {
        return BonusRuleID;
    }

    public void setBonusRuleID(double BonusRuleID) {
        this.BonusRuleID = BonusRuleID;
    }

    public String getBonusCode() {
        return BonusCode;
    }

    public void setBonusCode(String BonusCode) {
        this.BonusCode = BonusCode;
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

    public double getMinServiceLen() {
        return MinServiceLen;
    }

    public void setMinServiceLen(double MinServiceLen) {
        this.MinServiceLen = MinServiceLen;
    }

    public double getMaxServiceLen() {
        return MaxServiceLen;
    }

    public void setMaxServiceLen(double MaxServiceLen) {
        this.MaxServiceLen = MaxServiceLen;
    }

    public double getHKEntryID() {
        return HKEntryID;
    }

    public void setHKEntryID(double HKEntryID) {
        this.HKEntryID = HKEntryID;
    }

    public double getMenuID() {
        return MenuID;
    }

    public void setMenuID(double MenuID) {
        this.MenuID = MenuID;
    }

    public String getCriteriaName() {
        return CriteriaName;
    }

    public void setCriteriaName(String CriteriaName) {
        this.CriteriaName = CriteriaName;
    }

    public String getCriteriaValue() {
        return CriteriaValue;
    }

    public void setCriteriaValue(String CriteriaValue) {
        this.CriteriaValue = CriteriaValue;
    }

    public boolean getIsProportionate(){
        return IsProportionate;
    }

    public void setIsProportionate(boolean IsProportionate){
        this.IsProportionate=IsProportionate;
    }
}
