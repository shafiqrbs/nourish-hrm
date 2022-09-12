package com.erp.hrm.api.dto.recruitment;

import java.util.List;

public class SkillMatrixDTO {
    private int sectionId;
    private int candidateSectionId;
    private String sectionName;
    private List<SkillMatrixDetailsDTO> skillMatrixDetailsDTOS;
    private List<SkillMatrixSectionProcessDTO> sectionProcessDTOS;

    public SkillMatrixDTO() {
    }

    public SkillMatrixDTO(int sectionId, int candidateSectionId, String sectionName, List<SkillMatrixDetailsDTO> skillMatrixDetailsDTOS, List<SkillMatrixSectionProcessDTO> sectionProcessDTOS) {
        this.sectionId = sectionId;
        this.candidateSectionId = candidateSectionId;
        this.sectionName = sectionName;
        this.skillMatrixDetailsDTOS = skillMatrixDetailsDTOS;
        this.sectionProcessDTOS = sectionProcessDTOS;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getCandidateSectionId() {
        return candidateSectionId;
    }

    public void setCandidateSectionId(int candidateSectionId) {
        this.candidateSectionId = candidateSectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public List<SkillMatrixDetailsDTO> getSkillMatrixDetailsDTOS() {
        return skillMatrixDetailsDTOS;
    }

    public void setSkillMatrixDetailsDTOS(List<SkillMatrixDetailsDTO> skillMatrixDetailsDTOS) {
        this.skillMatrixDetailsDTOS = skillMatrixDetailsDTOS;
    }

    public List<SkillMatrixSectionProcessDTO> getSectionProcessDTOS() {
        return sectionProcessDTOS;
    }

    public void setSectionProcessDTOS(List<SkillMatrixSectionProcessDTO> sectionProcessDTOS) {
        this.sectionProcessDTOS = sectionProcessDTOS;
    }
}
