package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "CandidateSkillMatrixResult" )
public class CandidateSkillMatrixResult extends BaseIntEntity {


    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SkillMatrixSectionDetailId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_CandidateSkillMatrixResult_CandidateSkillMatrixSectionDetails"), nullable = false)
    private CandidateSkillMatrixSectionDetails candidateSkillMatrixSectionDetails;

    @Column(name = "ExamTarget", columnDefinition="INT")
    private float examTarget;

    @Column(name = "HowMuchCanGet", columnDefinition="INT")
    private float howMuchCanGet;

    @Column(name = "PscPerSec", columnDefinition="INT")
    private float pscPerSec;

    @Column(name = "EfficiencyPct", columnDefinition="INT")
    private float efficiencyPct;

    public CandidateSkillMatrixSectionDetails getCandidateSkillMatrixSectionDetails() {
        return candidateSkillMatrixSectionDetails;
    }

    public void setCandidateSkillMatrixSectionDetails(CandidateSkillMatrixSectionDetails candidateSkillMatrixSectionDetails) {
        this.candidateSkillMatrixSectionDetails = candidateSkillMatrixSectionDetails;
    }

    public float getExamTarget() {
        return examTarget;
    }

    public void setExamTarget(float examTarget) {
        this.examTarget = examTarget;
    }

    public float getHowMuchCanGet() {
        return howMuchCanGet;
    }

    public void setHowMuchCanGet(float howMuchCanGet) {
        this.howMuchCanGet = howMuchCanGet;
    }

    public float getPscPerSec() {
        return pscPerSec;
    }

    public void setPscPerSec(float pscPerSec) {
        this.pscPerSec = pscPerSec;
    }

    public float getEfficiencyPct() {
        return efficiencyPct;
    }

    public void setEfficiencyPct(float efficiencyPct) {
        this.efficiencyPct = efficiencyPct;
    }
}
