package com.erp.hrm.api.dto.recruitment;

public class SkillMatrixSectionProcessDTO {
    private int processId;
    private int candidateProcessId;
    private String processName;

    public SkillMatrixSectionProcessDTO() {
    }

    public SkillMatrixSectionProcessDTO(int processId, int candidateProcessId, String processName) {
        this.processId = processId;
        this.candidateProcessId = candidateProcessId;
        this.processName = processName;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getCandidateProcessId() {
        return candidateProcessId;
    }

    public void setCandidateProcessId(int candidateProcessId) {
        this.candidateProcessId = candidateProcessId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
