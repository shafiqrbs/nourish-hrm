package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "PFNominee" )
public class PFNominee extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_PFNominee_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 50)
    @Column(name = "NomineeName")
    private String NomineeName;

    @Size(max = 50)
    @Column(name = "Relationship")
    private String Relationship;

    @Size(max = 256)
    @Column(name = "Address")
    private String Address;

    @Column(name = "Distribution")
    private double Distribution;

    @Column(name = "SequenceNo",nullable = true,columnDefinition = "INT DEFAULT 0")
    private int SequenceNo;

    @Size(max = 256)
    @Column(name = "NomineeImage")
    private String NomineeImage;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getNomineeName() {
        return NomineeName;
    }

    public void setNomineeName(String NomineeName) {
        this.NomineeName = NomineeName;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public double getDistribution() {
        return Distribution;
    }

    public void setDistribution(double Distribution) {
        this.Distribution = Distribution;
    }

    public int getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(int SequenceNo) {
        this.SequenceNo = SequenceNo;
    }

    public String getNomineeImage() {
        return NomineeImage;
    }

    public void setNomineeImage(String NomineeImage) {
        this.NomineeImage = NomineeImage;
    }
}
