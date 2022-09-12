package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "RecruitIEDeptSkillMatrixSectionDetails", uniqueConstraints = { @UniqueConstraint( columnNames = { "SkillMatrixSectionId","processName" } ) } )
public class RecruitIEDeptSkillMatrixSectionDetails extends BaseIntEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SkillMatrixSectionId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_SkillMatrixSectionDetails_SkillMatrixSection"), nullable = false)
    private RecruitIEDeptSkillMatrixSection recruitIEDeptSkillMatrixSection;

    @Size(max = 100)
    @NotNull
    @Column(name = "ProcessName")
    private String processName;

    @OneToMany(mappedBy = "recruitIEDeptSkillMatrixSectionDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CandidateSkillMatrixSectionDetails> candidateSkillMatrixSectionDetails;

    public RecruitIEDeptSkillMatrixSection getRecruitIEDeptSkillMatrixSection() {
        return recruitIEDeptSkillMatrixSection;
    }

    public void setRecruitIEDeptSkillMatrixSection(RecruitIEDeptSkillMatrixSection recruitIEDeptSkillMatrixSection) {
        this.recruitIEDeptSkillMatrixSection = recruitIEDeptSkillMatrixSection;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Set<CandidateSkillMatrixSectionDetails> getCandidateSkillMatrixSectionDetails() {
        return candidateSkillMatrixSectionDetails;
    }

    public void setCandidateSkillMatrixSectionDetails(Set<CandidateSkillMatrixSectionDetails> candidateSkillMatrixSectionDetails) {
        this.candidateSkillMatrixSectionDetails = candidateSkillMatrixSectionDetails;
    }
}
