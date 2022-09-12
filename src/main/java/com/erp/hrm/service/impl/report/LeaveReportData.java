package com.erp.hrm.service.impl.report;

import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.domain.LeaveReport;
import com.erp.hrm.repository.reports.LeaveReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LeaveReportData {
    private LeaveReportRepository leaveReportRepository;
    public LeaveReportData(LeaveReportRepository leaveReportRepository){
        this.leaveReportRepository = leaveReportRepository;
    }

    public List<Map<String, Object>> getMonthlyLeaveTransactionData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(data.getFromDate());
        Date toDate = dateFormat.parse(data.getToDate());

        List<LeaveReport> reports = leaveReportRepository.findAllMonthlyLeaveTransaction(
                fromDate,toDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
            );

        for (LeaveReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("serviceLength",report.getServiceLength());
            item.put("fromDate",report.getLeaveFromDate());
            item.put("toDate",report.getLeaveToDate());
            item.put("leaveDays",report.getTotalDays());
            item.put("leaveReason",report.getLeaveReason());
            item.put("leaveType",report.getLeaveType());
            item.put("policyDescription",report.getLeaveDescription());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getEmployeeLeaveTransactionData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = dateFormat.parse(data.getFromDate());
        Date toDate = dateFormat.parse(data.getToDate());

        List<LeaveReport> reports = leaveReportRepository.findEmployeeAllLeaveTransaction(
            fromDate,toDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );

        for (LeaveReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("serviceLength",report.getServiceLength());
            item.put("fromDate",report.getLeaveFromDate());
            item.put("toDate",report.getLeaveToDate());
            item.put("leaveDays",report.getTotalDays());
            item.put("leaveReason",report.getLeaveReason());
            item.put("leaveType",report.getLeaveType());
            item.put("policyDescription",report.getLeaveDescription());
            result.add(item);
        }
        return result;
    }
}
