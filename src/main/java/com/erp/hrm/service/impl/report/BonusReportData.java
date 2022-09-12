package com.erp.hrm.service.impl.report;

import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.repository.reports.BonusReportRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BonusReportData {
    private BonusReportRepository bonusReportRepository;
    public BonusReportData(BonusReportRepository bonusReportRepository){
        this.bonusReportRepository = bonusReportRepository;
    }

    public List<Map<String, Object>> getBonusInfo(ReportFilterDTO data) throws ParseException {
        List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date workDate = dateFormat.parse(data.getFromDate());

        /*
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
            item.put("remarks","");
            result.add(item);
        }
        */
        return result;
    }
}
