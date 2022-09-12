package com.erp.hrm.service;
import com.erp.hrm.api.dto.*;
import com.erp.hrm.util.ActionResult;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface SalaryProcessService {

    ActionResult salaryProcessAndSave(String fromDate,String toDate,List<EmployeeCodeDTO> dto) throws ParseException;

    ActionResult salaryWiseEmployeeReportProcess();

    ActionResult paymentReportProcess();

    ActionResult monthlyAttendanceReportProcess();
}
