package com.erp.hrm.api;

import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.attendance.AttendanceHistoryGridDTO;
import com.erp.hrm.api.dto.attendance.ManualAttendanceDTO;
import com.erp.hrm.api.dto.attendance.ManualAttendanceEntryDTO;
import com.erp.hrm.service.attendance.AttendanceService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.*;

//import java.util.Date;
//import java.util.List;

/**
 * Created by Sohag on 03/11/2018.
 */
@RestController
@RequestMapping("/api/v1/attendances")

public class AttendanceApi {
    private AttendanceService attendanceService;
    public AttendanceApi(AttendanceService attendanceService){
        this.attendanceService = attendanceService;
    }

    @RequestMapping(value = "/dailyAttendance/get", method = RequestMethod.GET)
    public AttendanceHistoryGridDTO getAllBonusPolicyDetailByRuleCode(PageableDTO pageableDTO){
        return attendanceService.getAllDailyAttendance(pageableDTO);
    }

    @RequestMapping(value = "/entry/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody ManualAttendanceDTO attendanceDTO){
        return attendanceService.save(attendanceDTO);
    }

    @RequestMapping(value = "/manualEntry/saveEmployeeCodeIntoTemp", method = RequestMethod.POST)
    public ActionResult saveEmployeeCodeIntoTemp(@RequestBody ManualAttendanceEntryDTO dto){
        return attendanceService.saveEmployeeCodeIntoTemp(dto);
    }

    @RequestMapping(value = "/manualEntry/saveManualBulkAttendances", method = RequestMethod.POST)
    public ActionResult saveManualBulkAttendances(@RequestBody ManualAttendanceEntryDTO dto){
        return attendanceService.saveManualBulkAttendances(dto);
    }
}