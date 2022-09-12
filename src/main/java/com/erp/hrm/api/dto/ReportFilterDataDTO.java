package com.erp.hrm.api.dto;

import org.springframework.data.domain.Sort;

import java.util.Date;

public class ReportFilterDataDTO {
    private int reportId;
    private String filters;

    public ReportFilterDataDTO() {
    }

    public ReportFilterDataDTO(int reportId, String filters) {
        this.reportId = reportId;
        this.filters = filters;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }
}
