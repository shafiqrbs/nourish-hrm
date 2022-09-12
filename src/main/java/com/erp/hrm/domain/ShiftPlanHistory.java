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
@Table( name = "ShiftPlanHistory", uniqueConstraints = { @UniqueConstraint( name ="UK_ShiftPlanHistory",columnNames = { "EmployeeCode","ShiftID","FromDate" } ) } )

public class ShiftPlanHistory extends BaseEntity {

    @Size(max = 20)
    @Column(name = "EmployeeCode",nullable = false)
    private String EmployeeCode;

    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String ShiftID;

    @Column(name = "FromDate",nullable = true)
    private Date FromDate;

    @Column(name = "ToDate", nullable = true)
    private Date ToDate;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String shiftID) {
        ShiftID = shiftID;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        ToDate = toDate;
    }
}
