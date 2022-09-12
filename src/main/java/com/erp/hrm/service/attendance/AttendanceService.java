package com.erp.hrm.service.attendance;

import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.attendance.AttendanceHistoryGridDTO;
import com.erp.hrm.api.dto.attendance.ManualAttendanceDTO;
import com.erp.hrm.api.dto.attendance.ManualAttendanceEntryDTO;
import com.erp.hrm.util.ActionResult;

import java.util.Date;

/**
 * Created by Sohag on 31/10/2018.
 */
public interface AttendanceService {

    ActionResult save(ManualAttendanceDTO attendanceDTO);

    AttendanceHistoryGridDTO getAllDailyAttendance(PageableDTO pageableDTO);

    ActionResult saveEmployeeCodeIntoTemp(ManualAttendanceEntryDTO dto);

    ActionResult saveManualBulkAttendances(ManualAttendanceEntryDTO dto);
}
