package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "RecruitIEDeptSkillMatrixSection", uniqueConstraints = { @UniqueConstraint( columnNames = { "skillMatrixSectionName" } ) } )
public class RecruitIEDeptSkillMatrixSection extends BaseIntEntity {

    @Size(max = 64)
    @NotNull
    @Column(name = "SkillMatrixSectionName")
    private String skillMatrixSectionName;

    @Size(max = 8)
    @Column(name="UIPosition")
    private String uiPosition;

    @OneToMany(mappedBy = "recruitIEDeptSkillMatrixSection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RecruitIEDeptSkillMatrixSectionDetails> skillMatrixSectionDetails;

    @OneToMany(mappedBy = "recruitIEDeptSkillMatrixSection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CandidateSkillMatrixSection> candidateSkillMatrixSections;

    public String getSkillMatrixSectionName() {
        return skillMatrixSectionName;
    }

    public void setSkillMatrixSectionName(String skillMatrixSectionName) {
        this.skillMatrixSectionName = skillMatrixSectionName;
    }

    public String getUiPosition() {
        return uiPosition;
    }

    public void setUiPosition(String uiPosition) {
        this.uiPosition = uiPosition;
    }

    public Set<RecruitIEDeptSkillMatrixSectionDetails> getSkillMatrixSectionDetails() {
        return skillMatrixSectionDetails;
    }

    public void setSkillMatrixSectionDetails(Set<RecruitIEDeptSkillMatrixSectionDetails> skillMatrixSectionDetails) {
        this.skillMatrixSectionDetails = skillMatrixSectionDetails;
    }

    public Set<CandidateSkillMatrixSection> getCandidateSkillMatrixSections() {
        return candidateSkillMatrixSections;
    }

    public void setCandidateSkillMatrixSections(Set<CandidateSkillMatrixSection> candidateSkillMatrixSections) {
        this.candidateSkillMatrixSections = candidateSkillMatrixSections;
    }
}
