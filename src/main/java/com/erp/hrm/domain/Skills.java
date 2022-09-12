package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 29/04/2018.
 */
@Entity
@Table( name = "Skills")
public class Skills extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_Skills_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 50)
    @Column(name = "SkillCategory")
    private String SkillCategory;

    @Size(max = 100)
    @Column(name = "SkillType")
    private String SkillType;

    @Size(max = 100)
    @Column(name = "Description")
    private String Description;

    @Size(max = 60)
    @Column(name = "ModuleName")
    private String ModuleName;

    @Size(max = 50)
    @Column(name = "LabelName")
    private String LabelName;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getSkillCategory() {
        return SkillCategory;
    }

    public void setSkillCategory(String skillCategory) {
        this.SkillCategory = skillCategory;
    }

    public String getSkillType() {
        return SkillType;
    }

    public void setSkillType(String skillType) {
        this.SkillType = skillType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getModuleName() {
        return ModuleName;
    }

    public void setModuleName(String moduleName) {
        this.ModuleName = moduleName;
    }

    public String getLabelName() {
        return LabelName;
    }

    public void setLabelName(String labelName) {
        this.LabelName = labelName;
    }
}
