package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by WS on 05/06/2018.
 */
@Entity
@Table( name = "ShiftType", uniqueConstraints = { @UniqueConstraint( name ="UK_ShiftType",columnNames = { "ShiftTypeName" } ) } )

public class ShiftType extends BaseIntEntity {

    @Size(max = 20)
    @Column(name = "ShiftTypeName",nullable = false)
    private String ShiftTypeName;

    public String getShiftTypeName() {
        return ShiftTypeName;
    }

    public void setShiftTypeName(String ShiftTypeName) {
        this.ShiftTypeName = ShiftTypeName;
    }
}
