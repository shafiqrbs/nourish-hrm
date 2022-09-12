package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

@Entity
@Table( name = "EmployeeCodePrefix", uniqueConstraints = { @UniqueConstraint( columnNames = { "DepartmentName" } ) } )
public class EmployeeCodePrefix extends BaseEntity {

    @Size(max = 20)
    @Column(name = "DepartmentName")
    private String DepartmentName;

    @Size(max = 20)
    @Column(name = "CodePrefixValue")
    private String CodePrefixValue;
    
    public EmployeeCodePrefix() {
		super();
	}

	public EmployeeCodePrefix(String departmentName, String codePrefixValue) {
        DepartmentName = departmentName;
        CodePrefixValue = codePrefixValue;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getCodePrefixValue() {
        return CodePrefixValue;
    }

    public void setCodePrefixValue(String codePrefixValue) {
        CodePrefixValue = codePrefixValue;
    }
}
