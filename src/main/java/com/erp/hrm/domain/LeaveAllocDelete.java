package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveAllocDelete" )
public class LeaveAllocDelete extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }
}
