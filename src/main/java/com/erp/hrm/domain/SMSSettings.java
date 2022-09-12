package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Navid on 05/05/2018.
 */
@Entity
@Table( name = "SMSSettings" )
public class SMSSettings extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "SectionCode")
    private String SectionCode;

    @Size(max = 150)
    @Column(name = "SectionName")
    private String SectionName;

    @Size(max = 50)
    @Column(name = "Sequence")
    private String Sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CompanyId", columnDefinition = "INT", foreignKey = @ForeignKey(name = "FK_SMSSettings_CompanySettings"), nullable = false)
    private CompanySettings companySettings;

    @Size(max = 150)
    @Column(name = "Branch")
    private String Branch;

    @Size(max = 250)
    @Column(name = "Notes")
    private String Notes;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Floor> floors;

    public String getSectionCode() {
        return SectionCode;
    }

    public void setSectionCode(String SectionCode) {
        this.SectionCode = SectionCode;
    }

    public String getSectionName() {
        return SectionName;
    }

    public void setSectionName(String SectionName) {
        this.SectionName = SectionName;
    }

    public String getSequence() {
        return Sequence;
    }

    public void setSequence(String Sequence) {
        this.Sequence = Sequence;
    }

    public CompanySettings getCompanySettings() {
        return companySettings;
    }

    public void setCompanySettings(CompanySettings companySettings) {
        this.companySettings = companySettings;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String Notes) {
        this.Notes = Notes;
    }
}
