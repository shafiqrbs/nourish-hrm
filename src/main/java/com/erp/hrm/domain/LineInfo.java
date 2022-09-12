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
@Table( name = "LineInfo", uniqueConstraints = { @UniqueConstraint( columnNames = { "Name" } ) } )
public class LineInfo extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "Name")
    private String Name;

    @Column(name = "Descriptions")
    private String Descriptions;

    @Column(name = "IsDefault")
    private boolean IsDefault;

    @Column(name = "SequenceNo")
    private double SequenceNo;

    @Column(name = "DisplayCode")
    private String DisplayCode;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String Descriptions) {
        this.Descriptions = Descriptions;
    }

    public boolean getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(boolean IsDefault) {
        this.IsDefault = IsDefault;
    }

    public double getSequenceNo(){
        return SequenceNo;
    }

    public void setSequenceNo(double status){
        this.SequenceNo=SequenceNo;
    }

    public String getDisplayCode(){
        return DisplayCode;
    }

    public void setDisplayCode(String DisplayCode){
        this.DisplayCode=DisplayCode;
    }
}
