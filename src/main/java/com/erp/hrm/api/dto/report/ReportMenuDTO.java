package com.erp.hrm.api.dto.report;

import java.util.List;

public class ReportMenuDTO {
    private String label;
    private String icon;
    private List<ReportItemsDTO> items;

    public ReportMenuDTO() {
    }

    public ReportMenuDTO(String label, String icon) {
        this.label = label;
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<ReportItemsDTO> getItems() {
        return items;
    }

    public void setItems(List<ReportItemsDTO> items) {
        this.items = items;
    }
}
