package com.erp.hrm.api.dto.report;

public class ReportItemsDTO {
    private long reportId;
    private String label;
    private String name;

    public ReportItemsDTO() {
    }

    public ReportItemsDTO(long reportId, String label, String name) {
        this.reportId = reportId;
        this.label = label;
        this.name = name;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
