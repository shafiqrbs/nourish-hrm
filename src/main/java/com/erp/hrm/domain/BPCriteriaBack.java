package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "BPCriteriaBack" )
public class BPCriteriaBack extends BaseEntity {

    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BPCriteriaBackID")
    private double BPCriteriaBackID;

    @Size(max = 20)
    @Column(name = "BPCriteriaID")
    private String BPCriteriaID;

    @Size(max = 20)
    @Column(name = "SalaryHeadID")
    private String SalaryHeadID;

    @Size(max = 5)
    @Column(name = "Condition")
    private String Condition;

    @Column(name = "Percentage")
    private double Percentage;

    @Column(name = "CompareAmount")
    private double CompareAmount;

    @Size(max = 5)
    @Column(name = "RelationalCondition")
    private String RelationalCondition;

    @Column(name = "Sequence")
    private Integer Sequence;

    @Size(max = 20)
    @Column(name = "BonusCode")
    private String BonusCode;

    public double getBPCriteriaBackID() {
        return BPCriteriaBackID;
    }

    public void setBPCriteriaBackID(double BPCriteriaBackID) {
        this.BPCriteriaBackID = BPCriteriaBackID;
    }

    public String getBPCriteriaID() {
        return BPCriteriaID;
    }

    public void setBPCriteriaID(String BPCriteriaID) {
        this.BPCriteriaID = BPCriteriaID;
    }

    public String getSalaryHeadID() {
        return SalaryHeadID;
    }

    public void setSalaryHeadID(String SalaryHeadID) {
        this.SalaryHeadID = SalaryHeadID;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String Condition) {
        this.Condition = Condition;
    }

    public double getPercentage() {
        return Percentage;
    }

    public void setPercentage(double Percentage) {
        this.Percentage = Percentage;
    }

    public double getCompareAmount() {
        return CompareAmount;
    }

    public void setCompareAmount(double CompareAmount) {
        this.CompareAmount = CompareAmount;
    }

    public String getRelationalCondition() {
        return RelationalCondition;
    }

    public void setRelationalCondition(String RelationalCondition) {
        this.RelationalCondition = RelationalCondition;
    }

    public Integer getSequence(){
        return Sequence;
    }

    public void setSequence(Integer Sequence){
        this.Sequence=Sequence;
    }

    public String getBonusCode() {
        return BonusCode;
    }

    public void setBonusCode(String BonusCode) {
        this.BonusCode = BonusCode;
    }
}