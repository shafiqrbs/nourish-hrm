package com.erp.hrm.api.dto;

import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class PageableDTO {
    private int size;
    private int page;
    private String sortBy;
    private Sort.Direction sortOn;
    private String filters;
    private Date fromDate;
    private Date toDate;

    public PageableDTO() {
    }

    public PageableDTO(int size, int page, String sortBy, Sort.Direction sortOn, String filters, Date fromDate, Date toDate) {
        this.size = size;
        this.page = page;
        this.sortBy = sortBy;
        this.sortOn = sortOn;
        this.filters = filters;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Sort.Direction getSortOn() {
        return sortOn;
    }

    public void setSortOn(Sort.Direction sortOn) {
        this.sortOn = sortOn;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
