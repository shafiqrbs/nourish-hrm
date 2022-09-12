package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "PunchMachine", uniqueConstraints = { @UniqueConstraint( columnNames = { "MachineCode" } ) } )
public class PunchMachine extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "MachineCode")
    private String machineCode;

    @Size(max = 100)
    @Column(name = "MachineCompanyName")
    private String machineCompanyName;

    @Size(max = 50)
    @Column(name = "ModelNo")
    private String modelNo;

    @NotNull
    @Column(name = "Active", nullable = false)
    private boolean isActive;

    @Size(max = 800)
    @Column(name = "SampleData")
    private String sampleData;

    @Size(max = 50)
    @Column(name = "DocumentType")
    private String documentType;

    @Size(max = 50)
    @Column(name = "Password")
    private String password;

    @NotNull
    @Column(name = "HaveIdentityCode", nullable = false)
    private boolean haveIdentityCode;

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getMachineCompanyName() {
        return machineCompanyName;
    }

    public void setMachineCompanyName(String machineCompanyName) {
        this.machineCompanyName = machineCompanyName;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getSampleData() {
        return sampleData;
    }

    public void setSampleData(String sampleData) {
        this.sampleData = sampleData;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHaveIdentityCode() {
        return haveIdentityCode;
    }

    public void setHaveIdentityCode(boolean haveIdentityCode) {
        this.haveIdentityCode = haveIdentityCode;
    }
}
