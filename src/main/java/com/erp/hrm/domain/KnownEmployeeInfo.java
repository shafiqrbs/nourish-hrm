package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "KnownEmployeeInfo" )
public class KnownEmployeeInfo extends BaseEntity {


    @Size(max = 20)
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Size(max = 20)
    @Column(name = "KnownEmployeeCode")
    private String knownEmployeeCode;

    @Size(max = 200)
    @Column(name = "Name")
    private String name;

    @Size(max = 200)
    @Column(name = "Section")
    private String section;

    @Size(max = 200)
    @Column(name = "Position")
    private String position;

    @Size(max = 20)
    @Column(name = "Phone")
    private String phone;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeInfo) {
        this.employeeCode = employeeInfo;
    }

    public String getKnownEmployeeCode() {
        return knownEmployeeCode;
    }

    public void setKnownEmployeeCode(String knownEmployeeCode) {
        this.knownEmployeeCode = knownEmployeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
