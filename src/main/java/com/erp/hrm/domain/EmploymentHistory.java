package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "EmploymentHistory" )
public class EmploymentHistory extends BaseEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmploymentHistory_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 20)
    @Column(name = "ResumeCode")
    private String ResumeCode;

    @Size(max = 255)
    @Column(name = "CompanyName")
    private String CompanyName;

    @Size(max = 250)
    @Column(name = "Designation")
    private String Designations;

    @Size(max = 255)
    @Column(name = "JobResponsibility")
    private String JobResponsibility;

    @Size(max = 255)
    @Column(name = "Country")
    private String Country;

    @Size(max = 255)
    @Column(name = "City")
    private String City;

    @Size(max = 255)
    @Column(name = "Address")
    private String Address;

    @Column(name = "StartDate")
    private Date StartDate;

    @Column(name = "EndDate")
    private Date EndDate;

    @Column(name = "StartSalary", columnDefinition = "NUMERIC(18, 4)  CONSTRAINT DF_EmploymentHistory_StartSalary DEFAULT 0" )
    private BigDecimal StartSalary;

    @Column(name = "EndSalary", columnDefinition = "NUMERIC(18, 4)  CONSTRAINT DF_EmploymentHistory_EndSalary DEFAULT 0")
    private BigDecimal EndSalary;

    @Size(max = 50)
    @Column(name = "Currency")
    private String Currency;

    @Size(max = 50)
    @Column(name = "Mobile")
    private String Mobile;

    @Size(max = 500)
    @Column(name = "ResignCause")
    private String ResignCause;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getResumeCode() {
        return ResumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.ResumeCode = resumeCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getDesignations() {
        return Designations;
    }

    public void setDesignations(String designations) {
        this.Designations = designations;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        this.StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        this.EndDate = endDate;
    }

    public String getJobResponsibility() {
        return JobResponsibility;
    }

    public void setJobResponsibility(String jobResponsibility) {
        this.JobResponsibility = jobResponsibility;
    }

    public BigDecimal getStartSalary() {
        return StartSalary;
    }

    public void setStartSalary(BigDecimal startSalary) {
        this.StartSalary = startSalary;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

    public BigDecimal getEndSalary() {
        return EndSalary;
    }

    public void setEndSalary(BigDecimal endSalary) {
        this.EndSalary = endSalary;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }

    public String getResignCause() {
        return ResignCause;
    }

    public void setResignCause(String resignCause) {
        this.ResignCause = resignCause;
    }
}
