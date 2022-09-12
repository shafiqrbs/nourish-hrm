package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "Language" )
public class Language extends BaseEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_Language_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 60)
    @NotNull
    @Column(name = "LanguageName")
    private String LanguageName;

    @Size(max = 50)
    @Column(name = "Writing")
    private String Writing;

    @Size(max = 50)
    @Column(name = "Reading")
    private String Reading;

    @Size(max = 50)
    @Column(name = "Spoken")
    private String Spoken;

    @Size(max = 50)
    @Column(name = "Listening")
    private String Listening;

    @Column(name = "IsMotherLanguage",columnDefinition = "BIT DEFAULT 0")
    private boolean IsMotherLanguage;

    @Size(max = 512)
    @Column(name = "Notes")
    private String Notes;

    @Column(name = "Sequence")
    private Integer Sequence;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getLanguageName() {
        return LanguageName;
    }

    public void setLanguageName(String LanguageName) {
        this.LanguageName = LanguageName;
    }

    public String getWriting() {
        return Writing;
    }

    public void setWriting(String Writing) {
        this.Writing = Writing;
    }

    public String getReading() {
        return Reading;
    }

    public void setReading(String Reading) {
        this.Reading = Reading;
    }

    public String getSpoken() {
        return Spoken;
    }

    public void setSpoken(String Spoken) {
        this.Spoken = Spoken;
    }

    public String getListening() {
        return Listening;
    }

    public void setListening(String listening) {
        Listening = listening;
    }

    public boolean isMotherLanguage() {
        return IsMotherLanguage;
    }

    public void setMotherLanguage(boolean motherLanguage) {
        IsMotherLanguage = motherLanguage;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Integer getSequence(){
        return Sequence;
    }

    public void setSequence(Integer Sequence){
        this.Sequence=Sequence;
    }
}
