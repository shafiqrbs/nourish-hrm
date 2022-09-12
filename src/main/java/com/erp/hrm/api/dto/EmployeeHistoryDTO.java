package com.erp.hrm.api.dto;

import java.util.Date;

public class EmployeeHistoryDTO {
    private String EmployeeCode;

    private String CompanyName;
    private String Designation;
    private String LocationCountry;
    private String City;
    private String Address;
    private String Phone;
    private String ResignCause;
    private Date StartDate;
    private Date EndDate;
    private double StartingSalary;
    private double ClosingSalary;
    private String Currency;
    private String JobResponsibility;

    public EmployeeHistoryDTO(String employeeCode, String companyName, String designation, String locationCountry, String city, String address, String phone, String resignCause, Date startDate, Date endDate, double startingSalary, double closingSalary, String currency, String jobResponsibility) {
        EmployeeCode = employeeCode;
        CompanyName = companyName;
        Designation = designation;
        LocationCountry = locationCountry;
        City = city;
        Address = address;
        Phone = phone;
        ResignCause = resignCause;
        StartDate = startDate;
        EndDate = endDate;
        StartingSalary = startingSalary;
        ClosingSalary = closingSalary;
        Currency = currency;
        JobResponsibility = jobResponsibility;
    }


    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getLocationCountry() {
        return LocationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        LocationCountry = locationCountry;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
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

    public String getResignCause() {
        return ResignCause;
    }

    public void setResignCause(String resignCause) {
        ResignCause = resignCause;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public double getStartingSalary() {
        return StartingSalary;
    }

    public void setStartingSalary(double startingSalary) {
        StartingSalary = startingSalary;
    }

    public double getClosingSalary() {
        return ClosingSalary;
    }

    public void setClosingSalary(double closingSalary) {
        ClosingSalary = closingSalary;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getJobResponsibility() {
        return JobResponsibility;
    }

    public void setJobResponsibility(String jobResponsibility) {
        JobResponsibility = jobResponsibility;
    }
}
