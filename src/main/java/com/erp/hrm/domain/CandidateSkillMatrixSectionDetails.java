package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "CandidateSkillMatrixSectionDetails" )
public class CandidateSkillMatrixSectionDetails extends BaseIntEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CandidateSectionId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_CandidateSMSectionDetails_CandidateSMSection"), nullable = false)
    private CandidateSkillMatrixSection candidateSkillMatrixSection;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SkillMatrixProcessId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_CandidateSMSectionDetails_SkillMatrixSectionDetails"), nullable = true)
    private RecruitIEDeptSkillMatrixSectionDetails recruitIEDeptSkillMatrixSectionDetails;

    @OneToOne(mappedBy = "candidateSkillMatrixSectionDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CandidateSkillMatrixResult candidateSkillMatrixResults;

    public CandidateSkillMatrixSection getCandidateSkillMatrixSection() {
        return candidateSkillMatrixSection;
    }

    public void setCandidateSkillMatrixSection(CandidateSkillMatrixSection candidateSkillMatrixSection) {
        this.candidateSkillMatrixSection = candidateSkillMatrixSection;
    }

    public RecruitIEDeptSkillMatrixSectionDetails getRecruitIEDeptSkillMatrixSectionDetails() {
        return recruitIEDeptSkillMatrixSectionDetails;
    }

    public void setRecruitIEDeptSkillMatrixSectionDetails(RecruitIEDeptSkillMatrixSectionDetails recruitIEDeptSkillMatrixSectionDetails) {
        this.recruitIEDeptSkillMatrixSectionDetails = recruitIEDeptSkillMatrixSectionDetails;
    }

    public CandidateSkillMatrixResult getCandidateSkillMatrixResults() {
        return candidateSkillMatrixResults;
    }

    public void setCandidateSkillMatrixResults(CandidateSkillMatrixResult candidateSkillMatrixResults) {
        this.candidateSkillMatrixResults = candidateSkillMatrixResults;
    }
}
