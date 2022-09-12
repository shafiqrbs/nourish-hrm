package com.erp.hrm.api;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.service.EmployeeInfoService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sohag on 15/04/2018.
 */
@RestController
@RequestMapping("/api/v1/employees/info")
public class EmployeeInfoApi {
    private EmployeeInfoService employeeInfoService;
    public EmployeeInfoApi(EmployeeInfoService employeeInfoService){
        this.employeeInfoService = employeeInfoService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public EmployeeInfoDTO getEmployeeInfo(String pEmployeeCode){
        return employeeInfoService.getEmployeeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getAllEmployeeInfo(String pCallRequestFrom,PageableDTO pageableDTO){
        return employeeInfoService.getAllEmployeeInfo(pCallRequestFrom,pageableDTO);
    }

    @RequestMapping(value = "/getAllActiveEmployees", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getAllActiveEmployees(PageableDTO pageableDTO){
        return employeeInfoService.getAllActiveEmployees(pageableDTO);
    }

    @RequestMapping(value = "/getAllSelectedManualAttendanceEmployees", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getAllSelectedManualAttendanceEmployees(PageableDTO pageableDTO){
        return employeeInfoService.getAllSelectedManualAttendanceEmployees(pageableDTO);
    }

    @RequestMapping(value = "/getAllByShift", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getEmployeeInfoByShift(String pShiftNature,String pShiftIds,PageableDTO pageableDTO){
        return employeeInfoService.getEmployeeInfoByShift(pShiftNature,pShiftIds, pageableDTO);
    }

}
