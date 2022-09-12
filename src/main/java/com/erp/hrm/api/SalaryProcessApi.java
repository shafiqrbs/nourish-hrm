package com.erp.hrm.api;

import com.erp.hrm.api.dto.EmployeeCodeDTO;
import com.erp.hrm.service.SalaryProcessService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/salaryProcess")
public class SalaryProcessApi {
    private SalaryProcessService salaryProcessService;
    public SalaryProcessApi(SalaryProcessService salaryProcessService){
        this.salaryProcessService = salaryProcessService;
    }

    @RequestMapping(value = "/salaryProcessAndSave", method = RequestMethod.POST)
    public ActionResult save(String fromDate,String toDate,@RequestBody List<EmployeeCodeDTO> employeeCodeDTO) throws ParseException {
        return salaryProcessService.salaryProcessAndSave(fromDate,toDate,employeeCodeDTO);
    }


    @RequestMapping(value = "/salaryWiseAttnReportProcess", method = RequestMethod.POST)
    public ActionResult salaryWiseEmployeeReportProcess() {
        return salaryProcessService.salaryWiseEmployeeReportProcess();
    }


    @RequestMapping(value = "/monthlyAttnReportProcess", method = RequestMethod.POST)
    public ActionResult monthlyAttendanceReportProcess() {
        return salaryProcessService.monthlyAttendanceReportProcess();
    }

    @RequestMapping(value = "/paymentReportProcess", method = RequestMethod.POST)
    public ActionResult paymentReportProcess() {
        return salaryProcessService.paymentReportProcess();
    }
}