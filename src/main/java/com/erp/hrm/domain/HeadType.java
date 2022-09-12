package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * Created by WS on 05/06/2018.
 */
@Entity
@Table( name = "HeadType", uniqueConstraints = { @UniqueConstraint( name ="UK_HeadType",columnNames = { "HeadTypeName" } ) } )

public class HeadType extends BaseIntEntity {

    @Size(max = 20)
    @Column(name = "HeadTypeName",nullable = false)
    private String HeadTypeName;

    public String getHeadTypeName() {
        return HeadTypeName;
    }

    public void setHeadTypeName(String HeadTypeName) {
        this.HeadTypeName = HeadTypeName;
    }
}
