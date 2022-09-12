package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Sohag on 09/05/2018.
 */
public class CountryDTO {
    private long id;
    private String name;
    private String descriptions;
    private double sequenceNo;
    private String displayCode;
    private boolean isDefault;

    public CountryDTO() {
    }

    public CountryDTO(long id,String name, String descriptions, double sequenceNo, String displayCode, boolean isDefault) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.sequenceNo = sequenceNo;
        this.displayCode = displayCode;
        this.isDefault = isDefault;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

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

    public double getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(double sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public String getDisplayCode() {
        return displayCode;
    }

    public void setDisplayCode(String displayCode) {
        this.displayCode = displayCode;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}
