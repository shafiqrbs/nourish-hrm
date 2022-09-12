package com.erp.hrm.api.dto;

public class EmployeeFamilyInfoDTO {
    private Long id;
    private String employeeCode;
    private int noOfFamilyMember;
    private String address;
    private String country;


    private String city;
    private String phone;
    private int familyIncome;
    private int familyExpense;
    private int earningCapablePerson;

    public EmployeeFamilyInfoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public int getNoOfFamilyMember() {
        return noOfFamilyMember;
    }

    public void setNoOfFamilyMember(int noOfFamilyMember) {
        this.noOfFamilyMember = noOfFamilyMember;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFamilyIncome() {
        return familyIncome;
    }

    public void setFamilyIncome(int familyIncome) {
        this.familyIncome = familyIncome;
    }

    public int getFamilyExpense() {
        return familyExpense;
    }

    public void setFamilyExpense(int familyExpense) {
        this.familyExpense = familyExpense;
    }

    public int getEarningCapablePerson() {
        return earningCapablePerson;
    }

    public void setEarningCapablePerson(int earningCapablePerson) {
        this.earningCapablePerson = earningCapablePerson;
    }
}
