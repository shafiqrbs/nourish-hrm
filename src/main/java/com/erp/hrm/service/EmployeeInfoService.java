package com.erp.hrm.service;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.PageableDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface EmployeeInfoService {

    EmployeeInfoDTO getEmployeeInfo(String pEmployeeCode);

    EmployeeInfoGridDTO getAllEmployeeInfo(String pCallRequestFrom,PageableDTO pageableDTO);

    EmployeeInfoGridDTO getAllActiveEmployees(PageableDTO pageableDTO);

    EmployeeInfoGridDTO getAllSelectedManualAttendanceEmployees(PageableDTO pageableDTO);

    EmployeeInfoGridDTO getEmployeeInfoByShift(String pShiftNature,String pShiftId,PageableDTO pageableDTO);

}
