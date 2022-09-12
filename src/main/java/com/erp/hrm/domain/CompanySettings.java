package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Navid on 03/05/2018.
 */
@Entity
@Table( name = "CompanySettings" )
public class CompanySettings extends BaseIntEntity {

    @Size(max = 150)
    @Column(name = "CompanyName")
    private String companyName;

    @Size(max = 256)
    @Column(name = "CompanyLogo")
    private String companyLogo;

    @Size(max = 256)
    @Column(name = "Address")
    private String address;

    @Size(max = 50)
    @Column(name = "CompanyCity")
    private String CompanyCity;

    @Size(max = 50)
    @Column(name = "CompanyState")
    private String companyState;

    @Size(max = 20)
    @Column(name = "Zip")
    private String zip;

    @Size(max = 50)
    @Column(name = "Country")
    private String country;

    @Size(max = 20)
    @Column(name = "CompanyPhone")
    private String companyPhone;

    @Size(max = 50)
    @Column(name = "ContactName")
    private String contactName;

    @Size(max = 20)
    @Column(name = "ContactPhone")
    private String contactPhone;

    @Size(max = 50)
    @Column(name = "Designation")
    private String designation;

    @Size(max = 50)
    @Column(name = "ContactEmail")
    private String contactEmail;

    @Size(max = 200)
    @Column(name = "LinkedInInfoURL")
    private String linkedInInfoURL;

    @Size(max = 200)
    @Column(name = "FacebookURL")
    private String facebookURL;

    @Column(name = "isDefault", nullable = true)
    private boolean isDefault;

    @Column(name = "IsActive", nullable = true)
    private boolean isActive;

    @Column(name = "IsDelete", nullable = true)
    private boolean isDelete;

    @OneToMany(mappedBy = "companySettings", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Building> buildings;

    @OneToMany(mappedBy = "companySettings", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SMSSettings> smsSettings;

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
        return CompanyCity;
    }

    public void setCompanyCity(String companyCity) {
        CompanyCity = companyCity;
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
        this.isActive = active;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean delete) {
        this.isDelete = delete;
    }

    public Set<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Set<Building> buildings) {
        this.buildings = buildings;
    }

    public Set<SMSSettings> getSmsSettings() {
        return smsSettings;
    }

    public void setSmsSettings(Set<SMSSettings> smsSettings) {
        this.smsSettings = smsSettings;
    }
}
