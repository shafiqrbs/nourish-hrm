package com.erp.hrm.api.dto.Configuration;

/**
 * Created by Sohag on 09/05/2018.
 */
public class CityDTO{
    private long id;
    private String name;
    private String displayCode;
    private String descriptions;
    private boolean isDefault;
    private double sequenceNo;

    public CityDTO() {
    }

    public CityDTO(long id, String name, String displayCode, String descriptions, boolean isDefault, double sequenceNo) {
        this.id = id;
        this.name = name;
        this.displayCode = displayCode;
        this.descriptions = descriptions;
        this.isDefault = isDefault;
        this.sequenceNo = sequenceNo;
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
}
