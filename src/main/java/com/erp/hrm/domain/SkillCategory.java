package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "SkillCategory", uniqueConstraints = { @UniqueConstraint( columnNames = { "SkillCatName","SkillType" } ) } )
public class SkillCategory extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "SkillCatName")
    private String skillCatName;

    @Size(max = 100)
    @NotNull
    @Column(name = "SkillType")
    private String skillType;

    @Size(max = 100)
    @Column(name = "Descriptions")
    private String descriptions;

    @Column(name = "IsDefault")
    private boolean isDefault;

    public String getSkillCatName() {
        return skillCatName;
    }

    public void setSkillCatName(String skillCatName) {
        this.skillCatName = skillCatName;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
