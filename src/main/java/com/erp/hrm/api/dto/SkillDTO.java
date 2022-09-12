package com.erp.hrm.api.dto;

public class SkillDTO {
    private long SkillId;
    private String EmployeeCode;
    private String SkillCategory;
    private String SkillType;
    private String Description;
    private String ModuleName;
    private String LabelName;

    public SkillDTO(){
    }

    public SkillDTO(long skillId,String employeeCode, String skillCategory, String skillType, String description, String moduleName, String labelName) {
        SkillId = skillId;
        EmployeeCode = employeeCode;
        SkillCategory = skillCategory;
        SkillType = skillType;
        Description = description;
        ModuleName = moduleName;
        LabelName = labelName;
    }

    public long getSkillId() {
        return SkillId;
    }

    public void setSkillId(long skillId) {
        SkillId = skillId;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getSkillCategory() {
        return SkillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        SkillCategory = skillCategory;
    }

    public String getSkillType() {
        return SkillType;
    }

    public void setSkillType(String skillType) {
        SkillType = skillType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        ModuleName = moduleName;
    }

    public String getLabelName() {
        return LabelName;
    }

    public void setLabelName(String labelName) {
        LabelName = labelName;
    }
}
