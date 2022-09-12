package com.erp.hrm.api.dto.recruitment;

public class CandidateSectionProcessDTO {
    private int candidateSectionId;
    private int sectionId;
    private int processId;

    public CandidateSectionProcessDTO() {
    }

    public CandidateSectionProcessDTO(int candidateSectionId, int sectionId, int processId) {
        this.candidateSectionId = candidateSectionId;
        this.sectionId = sectionId;
        this.processId = processId;
    }

    public int getCandidateSectionId() {
        return candidateSectionId;
    }

    public void setCandidateSectionId(int candidateSectionId) {
        this.candidateSectionId = candidateSectionId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }
}
