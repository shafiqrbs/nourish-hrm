package com.erp.hrm.api.dto.EmployeeInfo;

import java.util.List;
import java.util.Set;

/**
 * Created by SA
 */
public class EmployeeInfoGridDTO {
    private int total;
    private List<EmployeeInfoDTO> data;

    public EmployeeInfoGridDTO() {
    }

    public EmployeeInfoGridDTO(int total, List<EmployeeInfoDTO> data) {
        this.total = total;
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<EmployeeInfoDTO> getData() {
        return data;
    }

    public void setData(List<EmployeeInfoDTO> data) {
        this.data = data;
    }
}
