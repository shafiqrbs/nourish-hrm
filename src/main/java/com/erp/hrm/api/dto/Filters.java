package com.erp.hrm.api.dto;

public class Filters {
    private String filterParam;
    private String filterParamValue;
    private String operator;

    public Filters() {
    }

    public Filters(String filterParam, String filterParamValue,String operator) {
        this.filterParam = filterParam;
        this.filterParamValue = filterParamValue;
        this.operator = operator;
    }

    public String getFilterParam() {
        return filterParam;
    }

    public void setFilterParam(String filterParam) {
        this.filterParam = filterParam;
    }

    public String getFilterParamValue() {
        return filterParamValue;
    }

    public void setFilterParamValue(String filterParamValue) {
        this.filterParamValue = filterParamValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
