package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "City", uniqueConstraints = { @UniqueConstraint( columnNames = { "Name" } ) } )
public class City extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "Name")
    private String name;

    @Size(max = 50)
    @Column(name = "DisplayCode")
    private String displayCode;

    @Size(max = 250)
    @Column(name = "Descriptions")
    private String descriptions;

    @Column(name = "IsDefault")
    private boolean isDefault;

    @Column(name = "SequenceNo")
    private double sequenceNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", columnDefinition = "BIGINT", foreignKey = @ForeignKey(name = "FK_City_Country"), nullable = false)
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
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

    public double getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(double sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
