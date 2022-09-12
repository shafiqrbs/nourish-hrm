package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "CandidateSkillMatrixSection" )
public class CandidateSkillMatrixSection extends BaseIntEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_CandidateSkillMatrixSection_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "SkillMatrixSectionId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_CandidateSkillMatrixSection_SkillMatrixSection"), nullable = false)
    private RecruitIEDeptSkillMatrixSection recruitIEDeptSkillMatrixSection;

    @OneToMany(mappedBy = "candidateSkillMatrixSection", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CandidateSkillMatrixSectionDetails> skillMatrixSectionDetails;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public RecruitIEDeptSkillMatrixSection getRecruitIEDeptSkillMatrixSection() {
        return recruitIEDeptSkillMatrixSection;
    }

    public void setRecruitIEDeptSkillMatrixSection(RecruitIEDeptSkillMatrixSection recruitIEDeptSkillMatrixSection) {
        this.recruitIEDeptSkillMatrixSection = recruitIEDeptSkillMatrixSection;
    }

    public Set<CandidateSkillMatrixSectionDetails> getSkillMatrixSectionDetails() {
        return skillMatrixSectionDetails;
    }

    public void setSkillMatrixSectionDetails(Set<CandidateSkillMatrixSectionDetails> skillMatrixSectionDetails) {
        this.skillMatrixSectionDetails = skillMatrixSectionDetails;
    }
}
