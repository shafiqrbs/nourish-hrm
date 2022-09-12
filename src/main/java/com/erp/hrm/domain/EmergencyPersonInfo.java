package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "EmergencyPersonInfo" )
public class EmergencyPersonInfo extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmergencyPersonInfo_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 50)
    @Column(name = "Name")
    private String Name;

    @Size(max = 200)
    @Column(name = "Address")
    private String Address;

    @Size(max = 20)
    @Column(name = "Phone")
    private String Phone;

    @Size(max = 50)
    @Column(name = "Email")
    private String Email;

    @Size(max = 50)
    @Column(name = "Relationship")
    private String Relationship;

    @Column(name = "Sequence", nullable = true, columnDefinition = "INT CONSTRAINT DF_EmergencyPersonInfo_Sequence DEFAULT 0")
    private int Sequence;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getRelationship() {
        return Relationship;
    }

    public void setRelationship(String Relationship) {
        this.Relationship = Relationship;
    }

    public int getSequenceNo(){
        return Sequence;
    }

    public void setSequenceNo(int Sequence){
        this.Sequence=Sequence;
    }
}
