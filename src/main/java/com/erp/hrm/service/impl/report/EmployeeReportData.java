package com.erp.hrm.service.impl.report;

import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.domain.EmployeeReport;
import com.erp.hrm.repository.reports.EmployeeReportRepository;
import com.erp.hrm.util.StaticName;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EmployeeReportData {
    private EmployeeReportRepository employeeReportRepository;
    public EmployeeReportData(EmployeeReportRepository employeeReportRepository){
        this.employeeReportRepository = employeeReportRepository;
    }

    public List<Map<String, Object>> getDepartmentWiseEmployeeData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        List<Object[]> reports = employeeReportRepository.findAllDepartmentWiseEmployee(
            data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );
        for (Object[] report : reports){
            Map<String,Object> item = new HashMap<>();
            item.put("department",(String)report[0]);
            item.put("unit",(String)report[1]);
            item.put("staff",(long)report[2]);
            item.put("male",(long)report[3]);
            item.put("female",(long)report[4]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getDesignationWiseEmployeeData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        List<Object[]> reports = employeeReportRepository.findAllDesignationWiseEmployee(
            data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );
        for (Object[] report : reports){
            Map<String,Object> item = new HashMap<>();
            item.put("designation",(String)report[0]);
            item.put("unit",(String)report[1]);
            item.put("staff",(long)report[2]);
            item.put("male",(long)report[3]);
            item.put("female",(long)report[4]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getGenderWiseEmployeeData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        List<Object[]> reports = employeeReportRepository.findAllGenderWiseEmployee(
            data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );
        for (Object[] report : reports){
            Map<String,Object> item = new HashMap<>();
            item.put("staffCategory",(String)report[0]);
            item.put("unit",(String)report[1]);
            item.put("staff",(long)report[2]);
            item.put("male",(long)report[3]);
            item.put("female",(long)report[4]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getGradeWiseNumberOfEmployeeData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        List<Object[]> reports = employeeReportRepository.findAllGradeWiseEmployee(
                data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );
        for (Object[] report : reports){
            Map<String,Object> item = new HashMap<>();
            item.put("grade",(String)report[0]);
            item.put("staff",(long)report[1]);
            item.put("male",(long)report[2]);
            item.put("female",(long)report[3]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getNewEmployeeJoiningStatusData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(data.getFromDate());
        Date toDate = dateFormat.parse(data.getFromDate());

        List<EmployeeReport> reports = employeeReportRepository.findAllNewJoiningEmployee(
            fromDate,toDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );
        for (EmployeeReport report : reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("gross",report.getGrossSalary());
            item.put("designation",report.getDesignation());
            item.put("dob",report.getDob());
            item.put("doj",report.getDoj());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getSeparatedEmployeeData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(data.getFromDate());
        Date toDate = dateFormat.parse(data.getFromDate());

        List<EmployeeReport> reports = employeeReportRepository.findAllSeparatedEmployee(
            fromDate,toDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );
        for (EmployeeReport report : reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("doj",report.getDoj());
            item.put("address",report.getPresentAddress());
            item.put("designation",report.getDesignation());
            item.put("effectiveDate",new Date());
            item.put("separationCause","Without Information");
            item.put("gross",report.getGrossSalary());
            result.add(item);
        }
        return result;
    }
}
