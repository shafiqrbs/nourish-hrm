package com.erp.hrm.api.dto.recruitment;

public class CandidateSkillMatrixSectionDTO {
    private int sectionId;
    private String candidateCode;

    public CandidateSkillMatrixSectionDTO() {
    }

    public CandidateSkillMatrixSectionDTO(int sectionId, String candidateCode) {
        this.sectionId = sectionId;
        this.candidateCode = candidateCode;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getCandidateCode() {
        return candidateCode;
    }

    public void setCandidateCode(String candidateCode) {
        this.candidateCode = candidateCode;
    }
}
