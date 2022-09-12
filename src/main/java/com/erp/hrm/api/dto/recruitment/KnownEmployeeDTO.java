package com.erp.hrm.api.dto.recruitment;


public class KnownEmployeeDTO {

    private String employeeTempCode;
    private String knownEmployeeCode;
    private String name;
    private String section;
    private String position;
    private String phone;

    public KnownEmployeeDTO() {
    }

    public String getEmployeeTempCode() {
        return employeeTempCode;
    }

    public void setEmployeeTempCode(String employeeTempCode) {
        this.employeeTempCode = employeeTempCode;
    }

    public String getKnownEmployeeCode() {
        return knownEmployeeCode;
    }

    public void setKnownEmployeeCode(String knownEmployeeCode) {
        this.knownEmployeeCode = knownEmployeeCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
