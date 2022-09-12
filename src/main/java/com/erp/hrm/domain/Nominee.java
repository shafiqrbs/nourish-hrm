package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "Nominee" )
public class Nominee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_Nominee_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 50)
    @Column(name = "NomineeName")
    private String NomineeName;

    @Size(max = 50)
    @Column(name = "FatherName")
    private String FatherName;

    @Size(max = 50)
    @Column(name = "MotherName")
    private String MotherName;

    @Size(max = 50)
    @Column(name = "Relationship")
    private String Relationship;

    @Size(max = 256)
    @Column(name = "Address")
    private String Address;

    @Size(max = 50)
    @Column(name = "Phone")
    private String Phone;

    @Size(max = 50)
    @Column(name = "Email")
    private String Email;

    @Size(max = 256)
    @Column(name = "NomineeImage")
    private String NomineeImage;

    @Size(max = 256)
    @Column(name = "SignImage")
    private String SignImage;


    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getNomineeName() {
        return NomineeName;
    }

    public void setNomineeName(String nomineeName) {
        NomineeName = nomineeName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getMotherName() {
        return MotherName;
    }

    public void setMotherName(String motherName) {
        MotherName = motherName;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String relationship) {
        Relationship = relationship;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNomineeImage() {
        return NomineeImage;
    }

    public void setNomineeImage(String nomineeImage) {
        NomineeImage = nomineeImage;
    }

    public String getSignImage() {
        return SignImage;
    }

    public void setSignImage(String signImage) {
        SignImage = signImage;
    }
}
