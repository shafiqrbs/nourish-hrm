package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "EmployeeImage" )
public class EmployeeImage extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeImage_Employee"))
    private Employee employee;

    @Size(max = 250)
    @Column(name = "EmpImage")
    private String EmpImage;

    @Size(max = 250)
    @Column(name = "EmpSignature")
    private String EmpSignature;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmpImage() {
        return EmpImage;
    }

    public void setEmpImage(String EmpImage) {
        this.EmpImage = EmpImage;
    }

    public String getEmpSignature() {
        return EmpSignature;
    }

    public void setEmpSignature(String EmpSignature) {
        this.EmpSignature = EmpSignature;
    }
}
