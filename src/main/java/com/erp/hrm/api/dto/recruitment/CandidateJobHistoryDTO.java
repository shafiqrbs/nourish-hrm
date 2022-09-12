package com.erp.hrm.api.dto.recruitment;

import java.math.BigDecimal;
import java.util.Date;

public class CandidateJobHistoryDTO {
    private Long Id;
    private String employeeCode;
    private String companyName;
    private String designation;
    private String jobResponsibility;
    private String country;
    private String city;
    private String address;
    private BigDecimal startingSalary;
    private BigDecimal closingSalary;
    private String currency;
 //   private String ResumeCode;
 //   private String Country;
    private Date startDate;
    private Date endDate;
    private String phone;
    private String resignCause;

    public CandidateJobHistoryDTO() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getStartingSalary() {
        return startingSalary;
    }

    public void setStartingSalary(BigDecimal startingSalary) {
        this.startingSalary = startingSalary;
    }

    public BigDecimal getClosingSalary() {
        return closingSalary;
    }

    public void setClosingSalary(BigDecimal closingSalary) {
        this.closingSalary = closingSalary;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobResponsibility() {
        return jobResponsibility;
    }

    public void setJobResponsibility(String jobResponsibility) {
        this.jobResponsibility = jobResponsibility;
    }

    public String getResignCause() {
        return resignCause;
    }

    public void setResignCause(String resignCause) {
        this.resignCause = resignCause;
    }
}
