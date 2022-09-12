package com.erp.hrm.api.dto.recruitment;

import java.util.List;

/**
 * Created by SA
 */
public class CandidateGridDTO {
    private int total;
    private List<InterviewCardDTO> data;

    public CandidateGridDTO() {
    }

    public CandidateGridDTO(int total, List<InterviewCardDTO> data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<InterviewCardDTO> getData() {
        return data;
    }

    public void setData(List<InterviewCardDTO> data) {
        this.data = data;
    }
}
