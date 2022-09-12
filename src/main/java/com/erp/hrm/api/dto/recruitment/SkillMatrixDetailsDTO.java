package com.erp.hrm.api.dto.recruitment;

public class SkillMatrixDetailsDTO {
    private int skillMatrixResultId;
    private int skillMatrixDetailId;
    private int candidateSectionDetailId;
    private String processName;
    private float examTarget;
    private float howMuchCanGet;
    private float pscPerSec;
    private float efficiencyPct;

    public SkillMatrixDetailsDTO() {
    }

    public SkillMatrixDetailsDTO(int skillMatrixResultId, int skillMatrixDetailId, int candidateSectionDetailId, String processName, float examTarget, float howMuchCanGet, float pscPerSec, float efficiencyPct) {
        this.skillMatrixResultId = skillMatrixResultId;
        this.skillMatrixDetailId = skillMatrixDetailId;
        this.candidateSectionDetailId = candidateSectionDetailId;
        this.processName = processName;
        this.examTarget = examTarget;
        this.howMuchCanGet = howMuchCanGet;
        this.pscPerSec = pscPerSec;
        this.efficiencyPct = efficiencyPct;
    }

    public int getSkillMatrixResultId() {
        return skillMatrixResultId;
    }

    public void setSkillMatrixResultId(int skillMatrixResultId) {
        this.skillMatrixResultId = skillMatrixResultId;
    }

    public int getSkillMatrixDetailId() {
        return skillMatrixDetailId;
    }

    public void setSkillMatrixDetailId(int skillMatrixDetailId) {
        this.skillMatrixDetailId = skillMatrixDetailId;
    }

    public int getCandidateSectionDetailId() {
        return candidateSectionDetailId;
    }

    public void setCandidateSectionDetailId(int candidateSectionDetailId) {
        this.candidateSectionDetailId = candidateSectionDetailId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
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
