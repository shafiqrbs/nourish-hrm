package com.erp.hrm.service.impl.report;

import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.domain.DailyAttendanceReport;
import com.erp.hrm.repository.reports.DailyAttendanceReportRepository;
import com.erp.hrm.util.StaticName;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AttendanceReportData {
    private DailyAttendanceReportRepository dailyAttendanceReportRepository;
    public AttendanceReportData(DailyAttendanceReportRepository dailyAttendanceReportRepository){
        this.dailyAttendanceReportRepository = dailyAttendanceReportRepository;
    }

    public List<Map<String, Object>> getAttendanceAbsentReport(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDateByDayStatus(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory(),
                StaticName.ABSENT_DAY_STATUS_TEXT
            );
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("doj",workDate); // report.getDoj()
            item.put("line","A-Line"); //report.getLine()
            item.put("dayStatus",report.getDayStatus());
            item.put("remarks",report.getRemarks());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getDailyLateReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllLateAttendanceInfoByDate(
            workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
            data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory(),
            StaticName.LATE_DAY_STATUS_TEXT
        );
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("unit",report.getUnit());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("employeeName",report.getEmployeeName());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("designation",report.getDesignation());
            item.put("shiftType",report.getShiftType());
            item.put("inTime",report.getPunchInTime());
            item.put("remarks",report.getRemarks());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getDailyAttendanceReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());
        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDate(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("unit",report.getUnit());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("shiftType",report.getShiftType());
            item.put("inTime",report.getPunchInTime());
            item.put("outTime",report.getPunchOutTime());
            item.put("late",(report.getLate() =="L"?true:false));
            item.put("lateHour",(float) report.getLateCountInMinute()); //it's late hour
            item.put("otHour",report.getOtHour());
            item.put("dayStatus",report.getDayStatus());
            item.put("lateStatus",report.getLate());
            item.put("remarks",report.getRemarks());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getDayPresentInformationReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());
        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDateByDayStatus(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory(),
                StaticName.PRESENT_DAY_STATUS_TEXT);
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("unit",report.getUnit());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("doj",report.getDoj());
            item.put("shiftType",report.getShiftType());
            item.put("dayStatus",report.getDayStatus());
            item.put("inTime",report.getPunchInTime());
            item.put("lateHour",report.getLateCountInMinute()); //it's late hour
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getEmployeeInPunchMissingInfoReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllInPunchMissingAttnInfoByDate(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            String pShiftInTime = dateFormat.format(dateFormat.parse(report.getWorkDate().toString()))+" "+report.getShiftInTime();
            String pShiftOutTime = dateFormat.format(dateFormat.parse(report.getWorkDate().toString()))+" "+report.getShiftOutTime();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("shiftInTime",dateTimeFormat.parse(pShiftInTime));
            item.put("shiftOutTime",dateTimeFormat.parse(pShiftOutTime));
            item.put("inTime",(report.getPunchInTime()));
            item.put("outTime",report.getPunchOutTime());
            item.put("shift",report.getShiftType());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getEmployeeOutPunchMissingInfoReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllOutPunchMissingAttnInfoByDate(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            String pShiftInTime = dateFormat.format(dateFormat.parse(report.getWorkDate().toString()))+" "+report.getShiftInTime();
            String pShiftOutTime = dateFormat.format(dateFormat.parse(report.getWorkDate().toString()))+" "+report.getShiftOutTime();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getEmployeeName());
            item.put("designation",report.getDesignation());
            item.put("shiftInTime",dateTimeFormat.parse(pShiftInTime));
            item.put("shiftOutTime",dateTimeFormat.parse(pShiftOutTime));
            item.put("inTime",report.getPunchInTime());
            item.put("outTime",report.getPunchOutTime());
            item.put("shift",report.getShiftType());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getContinuousAbsentReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workFromDate = dateFormat.parse(data.getFromDate());
        Date workToDate = dateFormat.parse(data.getFromDate());

        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDateByDayStatus(
                workFromDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory(),
                StaticName.ABSENT_DAY_STATUS_TEXT);
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report.getUnit());
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("line",report.getLine());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getPunchCardNo());
            item.put("designation",report.getDesignation());
            item.put("fromDate",report.getDoj());
            item.put("toDate",report.getDoj());
            item.put("totalDays",10);
            item.put("salary",50);
            item.put("doj","");
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getWorkDateWiseAttendanceReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<Object[]> reports = dailyAttendanceReportRepository.findAllWorkDateWiseAttendanceReport(
                workDate, data.getUnit(), data.getDepartment(), data.getDesignation() );
        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit", report[0]);
            item.put("department", report[1]);
            item.put("designation", report[2]);
            item.put("totalEmployee", report[3]);
            item.put("present", report[4]);
            item.put("absent", report[5]);
            item.put("leave", report[6]);
            item.put("late", report[7]);
            item.put("newEmployee", report[8]);
            item.put("leftEmployee", report[9]);
            item.put("remarks",report[10]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getDailyLineWiseAttendanceSummaryReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<Object[]> reports = dailyAttendanceReportRepository.findAllLineWiseAttendanceReport(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report[0]);
            item.put("line",report[1]);
            item.put("totalEmployee",report[3]);
            item.put("presentEmployee",report[4]);
            item.put("absentEmployee",report[5]);
            item.put("lateEmployee",report[6]);
            item.put("leaveEmployee",report[7]);
            item.put("newEmployee",report[8]);
            item.put("separatedEmployee",report[9]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getDailyEmployeeAttendanceReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<Object[]> reports = dailyAttendanceReportRepository.findAllLineWiseAttendanceReport(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());

        for (Object[] report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("unit",report[0]);
            item.put("line",report[1]);
            item.put("designation",report[2]);
            item.put("activeEmployee",report[3]);
            item.put("presentEmployee",report[4]);
            item.put("absentEmployee",report[5]);
            item.put("lateEmployee",report[6]);
            item.put("leaveEmployee",report[7]);
            item.put("newEmployee",report[8]);
            item.put("separatedEmployee",report[9]);
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getMonthlyAttendanceSheetReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDate(
                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());
        for (DailyAttendanceReport report:reports){
            Map<String,Object> item = new HashMap<>();
            item.put("department",report.getDepartment());
            item.put("section",report.getSection());
            item.put("employeeCode",report.getEmployeeCode());
            item.put("punchCardNo",report.getPunchCardNo());
            item.put("employeeName",report.getPunchCardNo());
            item.put("designation",report.getDesignation());
            item.put("doj",report.getDoj());
            item.put("line",report.getLine());
            item.put("dayStatus",report.getDayStatus());
            item.put("remarks",report.getRemarks());
            result.add(item);
        }
        return result;
    }

    public List<Map<String, Object>> getEmployeeAttendanceHistoryForBuyerReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

//        List<DailyAttendanceReport> reports = null;
//        for (DailyAttendanceReport report:reports){
//            Map<String,Object> item = new HashMap<>();
//            item.put("unit","");
//            item.put("designation","");
//            item.put("line","");
//            item.put("employeeCode","");
//            item.put("employeeName","");
//            item.put("punchCardNo","");
//            item.put("grade","");
//            item.put("doj","");
//            item.put("gross","");
//            item.put("dos","");
//            item.put("workDate","");
//            item.put("dayStatus","");
//            item.put("inTime","");
//            item.put("outTime","");
//            item.put("lateHour","");
//            item.put("lunchInTime","");
//            item.put("lunchOutTime","");
//            item.put("otHour","");
//            item.put("extraOtHour","");
//            item.put("otReduce","");
//            item.put("remarks","");
//            result.add(item);
//        }
        return result;
    }

    public List<Map<String, Object>> getDailyAttendanceActualHistoryReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

//        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDate(
//                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
//                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());
//        for (DailyAttendanceReport report:reports){
//            Map<String,Object> item = new HashMap<>();
//            item.put("unit",report.getUnit());
//            item.put("designation",report.getDesignation());
//            item.put("line",report.getLine());
//            item.put("employeeCode",report.getEmployeeCode());
//            item.put("punchCardNo",report.getPunchCardNo());
//            item.put("grade","");
//            item.put("doj",report.getDoj());
//            item.put("gross","");
//            item.put("dos","");
//            item.put("workDate",report.getWorkDate());
//            item.put("dayStatus",report.getDayStatus());
//            item.put("inTime",report.getPunchInTime());
//            item.put("outTime",report.getPunchOutTime());
//            item.put("lateHour",report.getLateCountInMinute());
//            item.put("lunchInTime","");
//            item.put("lunchOutTime","");
//            item.put("otHour",report.getOtHour());
//            item.put("extraOtHour","");
//            item.put("otReduce","");
//            item.put("remarks",report.getRemarks());
//            result.add(item);
//        }
        return result;
    }

    public List<Map<String, Object>> getEmployeeJobCardsReport(ReportFilterDTO data) throws ParseException{
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());
//
//        List<DailyAttendanceReport> reports = dailyAttendanceReportRepository.findAllAttendanceInfoByDate(
//                workDate,data.getEmployeeCode(),data.getPunchCardNo(),data.getUnit(),data.getFloor(),
//                data.getLine(),data.getDepartment(),data.getSection(),data.getDesignation(),data.getStaffCategory());
//        for (DailyAttendanceReport report:reports){
//            Map<String,Object> item = new HashMap<>();
//            item.put("unit",report.getUnit());
//            item.put("designation",report.getDesignation());
//            item.put("line",report.getLine());
//            item.put("employeeCode",report.getEmployeeCode());
//            item.put("employeeName",report.getEmployeeName());
//            item.put("punchCardNo",report.getPunchCardNo());
//            item.put("grade","");
//            item.put("doj",report.getDoj());
//            item.put("gross","");
//            item.put("dos","");
//            item.put("workDate",report.getWorkDate());
//            item.put("dayStatus",report.getDayStatus());
//            item.put("inTime",report.getPunchInTime());
//            item.put("outTime",report.getPunchOutTime());
//            item.put("lateHour",report.getLateCountInMinute());
//            item.put("lunchInTime","");
//            item.put("lunchOutTime","");
//            item.put("otHour",report.getOtHour());
//            item.put("extraOtHour","");
//            item.put("otReduce","");
//            item.put("remarks",report.getRemarks());
//            result.add(item);
//        }
        return result;
    }
}
