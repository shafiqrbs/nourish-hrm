package com.erp.hrm.service.impl.report;

import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.repository.reports.PaymentReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PaymentReportData {
    private PaymentReportRepository paymentReportRepository;
    public PaymentReportData(PaymentReportRepository paymentReportRepository){
        this.paymentReportRepository = paymentReportRepository;
    }

    public List<Map<String, Object>> getSalaryAndOvertimeSheetData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        int pYearNo = 2018;
        int pMonth = 11;

        List<Object[]> reports = paymentReportRepository.findAllSalaryAndOverTime(
                pYearNo,pMonth,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
            );

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("section",report[0].toString());
            item.put("line","A-Line"); //report[1].toString()
            item.put("employeeCode",report[2].toString());
            item.put("punchCardNo",report[3].toString());
            item.put("employeeName",report[4].toString());
            item.put("doj",report[5]);
            item.put("designation",report[6].toString());
            item.put("grade",report[7].toString());
            item.put("present",report[8]);
            item.put("workingDay",report[9]);
            item.put("absent",report[10]);
            item.put("cl",report[11]);
            item.put("sl",report[12]);
            item.put("el",report[13]);
            item.put("spl",report[14]);

            item.put("basic",report[15]);
            item.put("houseRent",report[16]);
            item.put("medicalAllowance",report[17]);
            item.put("lunchBill",report[18]);
            item.put("conveyance",report[19]);
            item.put("advance",report[20]);
            item.put("stamp",report[21]);
            item.put("attendanceBonus",report[22]);
            item.put("otHour",report[23]);
            item.put("otRate",report[24]);
            item.put("ot",report[25]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getSalaryAndOvertimeSheetForBuyerData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        int pYearNo = 2018;
        int pMonth = 11;

        List<Object[]> reports = paymentReportRepository.findAllSalaryAndOverTimeForBuyer(
                pYearNo,pMonth,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("section",report[0].toString());
            item.put("line","A-Line"); //report[1].toString()
            item.put("employeeCode",report[2].toString());
            item.put("punchCardNo",report[3].toString());
            item.put("employeeName",report[4].toString());
            item.put("doj",report[5]);
            item.put("designation",report[6].toString());
            item.put("grade",report[7].toString());
            item.put("present",report[8]);
            item.put("workingDay",report[9]);
            item.put("absent",report[10]);
            item.put("tinNumber","54285452215");
            item.put("bankName","Janata Bank");
            item.put("bankAccNo","AC015482200");
            item.put("cl",(report[14]));
            item.put("sl",report[15]);
            item.put("el",report[16]);
            item.put("spl",report[17]);

            item.put("basic",report[18]);
            item.put("houseRent",report[19]);
            item.put("medicalAllowance",report[20]);
            item.put("lunchBill",report[21]);
            item.put("conveyance",report[22]);
            item.put("advance",report[23]);
            item.put("stamp",report[24]);
            item.put("attendanceBonus",report[25]);
            item.put("otHour",report[26]);
            item.put("otRate",report[27]);
            item.put("ot",report[28]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getSalaryAndOTTopSheetForBuyerData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        int pYearNo = 2018;
        int pMonth = 11;

        List<Object[]> reports = paymentReportRepository.findAllSalaryAndOTTopSheetForBuyer(
                pYearNo,pMonth,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("section",report[0].toString());
            item.put("designation",report[1].toString());
            item.put("totalManPower",(long) report[2]);

            item.put("basic",report[3]);
            item.put("houseRent",report[4]);
            item.put("medicalAllowance",report[5]);
            item.put("lunchBill",report[6]);
            item.put("conveyance",report[7]);
            item.put("absent",report[8]);
            item.put("advance",report[9]);
            item.put("stamp",report[10]);
            item.put("attendanceBonus",report[11]);
            item.put("otHour",report[12]);
            item.put("ot",report[13]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getExtraOvertimeSheetData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        int pYearNo = 2018;
        int pMonth = 11;

        List<Object[]> reports = paymentReportRepository.findAllExtraOverTimeSheet(
                pYearNo,pMonth,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("line","A-Line"); //report[0]
            item.put("employeeCode",report[1].toString());
            item.put("punchCardNo",report[2].toString());
            item.put("employeeName",report[3].toString());
            item.put("doj",report[4]);
            item.put("designation",report[5].toString());
            item.put("grade",report[6].toString());
            item.put("present",report[7]);
            item.put("workingDay",report[8]);
            item.put("totalSalary",report[9]);

            item.put("basic",report[10]);
            item.put("otHour",report[11]);
            item.put("otRate",report[12]);
            item.put("eotHour",report[13]);
            item.put("salaryWithOt",report[14]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getPayslipData(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        int pYearNo = 2018;
        int pMonth = 11;

        List<Object[]> reports = paymentReportRepository.findAllEmployeePaySlip(
                pYearNo,pMonth,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory()
        );

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("employeeCode",report[0].toString());
            item.put("punchCardNo",report[1].toString());
            item.put("yearNo",report[2].toString());
            item.put("monthNo",report[3].toString());
            item.put("employeeName",report[4].toString());
            item.put("designation",report[5].toString());
            item.put("section",report[6].toString());
            item.put("line","A-Line"); //report[7].toString()
            item.put("grade",report[8].toString());
            item.put("doj",report[9]);
            item.put("workingDay",report[10]);
            item.put("present",report[11]);
            item.put("absent",report[12]);
            item.put("cl",report[13]);
            item.put("sl",report[14]);
            item.put("el",report[15]);
            item.put("spl",report[16]);

            item.put("gross",report[17]);
            item.put("basic",report[18]);
            item.put("houseRent",report[19]);
            item.put("medicalAllowance",report[20]);
            item.put("lunchBill",report[21]);
            item.put("conveyance",report[22]);
            item.put("absenteeism",report[23]);
            item.put("advance",report[24]);
            item.put("stamp",report[25]);
            item.put("attendanceBonus",report[26]);
            item.put("otHour",report[27]);
            item.put("otRate",report[28]);
            item.put("ot",report[29]);
            result.add(item);
        }
        return result;
    }
}
