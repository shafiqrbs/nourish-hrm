package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ShiftRuleDetail" )
public class ShiftRuleDetail extends BaseEntity {

    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String ShiftID;

    @Size(max = 20)
    @Column(name = "ShiftType")
    private String ShiftType;

    @Size(max = 50)
    @Column(name = "ShiftRuleCode",nullable = false)
    private String ShiftRuleCode;

    @Size(max = 50)
    @Column(name = "Alias",nullable = false)
    private String Alias;

    @Column(name = "Days", nullable = false)
    private int Days;

    @Column(name = "SequenceNo", nullable = false)
    private int SequenceNo;

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String shiftID) {
        ShiftID = shiftID;
    }

    public String getShiftType() {
        return ShiftType;
    }

    public void setShiftType(String shiftType) {
        ShiftType = shiftType;
    }

    public String getShiftRuleCode() {
        return ShiftRuleCode;
    }

    public void setShiftRuleCode(String shiftRuleCode) {
        ShiftRuleCode = shiftRuleCode;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        this.Alias = alias;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int days) {
        Days = days;
    }

    public int getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        SequenceNo = sequenceNo;
    }
}
