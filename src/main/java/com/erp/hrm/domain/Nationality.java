package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "Nationality", uniqueConstraints = { @UniqueConstraint( columnNames = { "Name" } ) } )
public class Nationality extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "Name")
    private String name;

    @Column(name = "Descriptions")
    private String descriptions;

    @Column(name = "SequenceNo")
    private double sequenceNo;

    @Column(name = "DisplayCode")
    private String displayCode;

    @Column(name = "IsDefault")
    private boolean isDefault;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getSequenceNo(){
        return sequenceNo;
    }

    public void setSequenceNo(double sequenceNo){
        this.sequenceNo=sequenceNo;
    }

    public String getDisplayCode(){
        return displayCode;
    }

    public void setDisplayCode(String displayCode){
        this.displayCode=displayCode;
    }
}
