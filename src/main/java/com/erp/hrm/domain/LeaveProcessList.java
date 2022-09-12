package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 30/04/2018.
 */
@Entity
@Table( name = "LeaveProcessList" )
public class LeaveProcessList extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "Forwarding")
    private String Forwarding;

    @Size(max = 20)
    @NotNull
    @Column(name = "Recomendor")
    private String Recomendor;

    @Size(max = 20)
    @NotNull
    @Column(name = "Approval")
    private String Approval;

    @Column(name = "FDefault")
    private boolean FDefault;

    @Column(name = "RDefault")
    private boolean RDefault;

    @Column(name = "ADefault")
    private boolean ADefault;

    @Size(max = 100)
    @Column(name = "FEmail")
    private String FEmail;

    @Size(max = 100)
    @Column(name = "REmail")
    private String REmail;

    @Size(max = 100)
    @Column(name = "AEmail")
    private String AEmail;

    @Size(max = 40)
    @Column(name = "ForwarderName")
    private String ForwarderName;

    @Size(max = 40)
    @Column(name = "RecomendorName")
    private String RecomendorName;

    @Size(max = 40)
    @Column(name = "ApprovalName")
    private String ApprovalName;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getForwarding() {
        return Forwarding;
    }

    public void setForwarding(String Forwarding) {
        this.Forwarding = Forwarding;
    }

    public String getRecomendor() {
        return Recomendor;
    }

    public void setRecomendor(String Recomendor) {
        this.Recomendor = Recomendor;
    }

    public String getApproval() {
        return Approval;
    }

    public void setApproval(String Approval) {
        this.Approval = Approval;
    }

    public boolean getFDefault() {
        return FDefault;
    }

    public void setFDefault(boolean FDefault) {
        this.FDefault = FDefault;
    }

    public boolean getRDefault() {
        return RDefault;
    }

    public void setRDefault(boolean RDefault) {
        this.RDefault = RDefault;
    }

    public boolean getADefault() {
        return ADefault;
    }

    public void setADefault(boolean ADefault) {
        this.ADefault = ADefault;
    }

    public String getFEmail() {
        return FEmail;
    }

    public void setFEmail(String FEmail) {
        this.FEmail = FEmail;
    }

    public String getREmail() {
        return REmail;
    }

    public void setREmail(String REmail) {
        this.REmail = REmail;
    }

    public String getAEmail() {
        return AEmail;
    }

    public void setAEmail(String AEmail) {
        this.AEmail = AEmail;
    }

    public String getForwarderName() {
        return ForwarderName;
    }

    public void setForwarderName(String ForwarderName) {
        this.ForwarderName = ForwarderName;
    }

    public String getRecomendorName() {
        return RecomendorName;
    }

    public void setRecomendorName(String RecomendorName) {
        this.RecomendorName = RecomendorName;
    }

    public String getApprovalName() {
        return ApprovalName;
    }

    public void setApprovalName(String ApprovalName) {
        this.ApprovalName = ApprovalName;
    }
}
