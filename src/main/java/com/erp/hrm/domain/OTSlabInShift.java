package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by WS on 09/05/2018.
 */
@Entity
@Table( name = "OTSlabInShift", uniqueConstraints = { @UniqueConstraint( name = "UK_OTSlabInShift",columnNames = { "ShiftID","SlabType" } ) } )
public class OTSlabInShift extends BaseEntity {

    @NotNull
    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String shiftID;

    @Size(max = 20)
    @Column(name = "SlabType",nullable = false)
    private String slabType;

    @Column(name = "Rate", columnDefinition = "NUMERIC(18,4)")
    private double rate;

    @Column(name = "Duration", columnDefinition = "NUMERIC(18,2)")
    private double duration;

    @Column(name = "SequenceNo")
    private int sequenceNo;

    @Size(max = 50)
    @Column(name = "SalaryHeadID")
    private String salaryHeadID;

    @Column(name = "IsEffected")
    private boolean isEffected;

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getSlabType() {
        return slabType;
    }

    public void setSlabType(String slabType) {
        this.slabType = slabType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public boolean isEffected() {
        return isEffected;
    }

    public void setEffected(boolean effected) {
        this.isEffected = effected;
    }
}
