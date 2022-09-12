package com.erp.hrm.api.dto.recruitment;

public class SkillMatrixSectionDTO {
    private int sectionId;
    private String sectionName;

    public SkillMatrixSectionDTO() {
    }

    public SkillMatrixSectionDTO(int sectionId, String sectionName) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
