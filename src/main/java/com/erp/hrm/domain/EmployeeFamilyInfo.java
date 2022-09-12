package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity( name = "EmployeeFamilyInfo" )
@Table( name = "EmployeeFamilyInfo" )
public class EmployeeFamilyInfo extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeFamilyInfo_Employee"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Column(name = "FamilyMembers",nullable = true,columnDefinition = "INT CONSTRAINT DF_EmployeeFamilyInfo_FamilyMembers DEFAULT 0")
    private int FamilyMembers;

    @Size(max = 256)
    @Column(name = "Address")
    private String Address;

    @Size(max = 100)
    @Column(name = "Country")
    private String Country;

    @Size(max = 100)
    @Column(name = "City")
    private String City;

    @Size(max = 20)
    @Column(name = "Phone")
    private String Phone;

    @Column(name = "FamilyIncome",nullable = true,columnDefinition = "INT CONSTRAINT DF_EmployeeFamilyInfo_FamilyIncome DEFAULT 0")
    private int FamilyIncome;

    @Column(name = "FamilyExpense",nullable = true,columnDefinition = "INT CONSTRAINT DF_EmployeeFamilyInfo_FamilyExpense DEFAULT 0")
    private int FamilyExpense;

    @Column(name = "CapablePerson",nullable = true,columnDefinition = "INT CONSTRAINT DF_EmployeeFamilyInfo_CapablePerson DEFAULT 0")
    private int CapablePerson;


    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public int getFamilyMembers() {
        return FamilyMembers;
    }

    public void setFamilyMembers(int familyMembers) {
        this.FamilyMembers = familyMembers;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = city;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public int getFamilyIncome() {
        return FamilyIncome;
    }

    public void setFamilyIncome(int familyIncome) {
        this.FamilyIncome = familyIncome;
    }

    public int getFamilyExpense() {
        return FamilyExpense;
    }

    public void setFamilyExpense(int familyExpense) {
        this.FamilyExpense = familyExpense;
    }

    public int getCapablePerson() {
        return CapablePerson;
    }

    public void setCapablePerson(int capablePerson) {
        this.CapablePerson = capablePerson;
    }
}
