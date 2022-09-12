package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Navid on 12/05/2018.
 */
public class CompanySettingsDTO {

    private int id;
    private String companyName;
    private String companyLogo;
    private String address;
    private String companyCity;
    private String companyState;
    private String zip;
    private String country;
    private String companyPhone;
    private String contactName;
    private String contactPhone;
    private String designation;
    private String contactEmail;
    private String linkedInInfoURL;
    private String facebookURL;
    private boolean isDefault;
    private boolean isActive;
    private boolean isDelete;

    public CompanySettingsDTO() {
    }

    public CompanySettingsDTO(int id, String companyName, String companyLogo, String address, String companyCity, String companyState, String zip, String country, String companyPhone, String contactName, String contactPhone, String designation, String contactEmail, String linkedInInfoURL, String facebookURL, boolean isDefault, boolean isActive, boolean isDelete) {
        this.id = id;
        this.companyName = companyName;
        this.companyLogo = companyLogo;
        this.address = address;
        this.companyCity = companyCity;
        this.companyState = companyState;
        this.zip = zip;
        this.country = country;
        this.companyPhone = companyPhone;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.designation = designation;
        this.contactEmail = contactEmail;
        this.linkedInInfoURL = linkedInInfoURL;
        this.facebookURL = facebookURL;
        this.isDefault = isDefault;
        this.isActive = isActive;
        this.isDelete = isDelete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public String getCompanyState() {
        return companyState;
    }

    public void setCompanyState(String companyState) {
        this.companyState = companyState;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLinkedInInfoURL() {
        return linkedInInfoURL;
    }

    public void setLinkedInInfoURL(String linkedInInfoURL) {
        this.linkedInInfoURL = linkedInInfoURL;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        isDelete = delete;
    }
}
