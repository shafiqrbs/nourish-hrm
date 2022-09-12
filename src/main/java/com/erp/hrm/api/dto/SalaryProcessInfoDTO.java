package com.erp.hrm.api.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 15/08/2018.
 */
public class SalaryProcessInfoDTO {
    private Date salaryFromDate;
    private Date salaryToDate;
    private List<EmployeeCodeDTO> employeeCodeDTO;

    public SalaryProcessInfoDTO() {
    }

    public SalaryProcessInfoDTO(Date salaryFromDate, Date salaryToDate, List<EmployeeCodeDTO> employeeCodeDTO) {
        this.salaryFromDate = salaryFromDate;
        this.salaryToDate = salaryToDate;
        this.employeeCodeDTO = employeeCodeDTO;
    }

    public Date getSalaryFromDate() {
        return salaryFromDate;
    }

    public void setSalaryFromDate(Date salaryFromDate) {
        this.salaryFromDate = salaryFromDate;
    }

    public Date getSalaryToDate() {
        return salaryToDate;
    }

    public void setSalaryToDate(Date salaryToDate) {
        this.salaryToDate = salaryToDate;
    }

    public List<EmployeeCodeDTO> getEmployeeCodeDTO() {
        return employeeCodeDTO;
    }

    public void setEmployeeCodeDTO(List<EmployeeCodeDTO> employeeCodeDTO) {
        this.employeeCodeDTO = employeeCodeDTO;
    }
}
