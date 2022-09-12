package com.erp.hrm.service.impl.leave;

import com.erp.hrm.api.dto.leaveManagement.EmployeeLeaveAllocationDTO;
import com.erp.hrm.api.dto.leaveManagement.LeaveProcessDTO;
import com.erp.hrm.domain.EmployeeLeaveMaster;
import com.erp.hrm.domain.LeavePolicyInfo;
import com.erp.hrm.domain.LeaveYear;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.leave.EmployeeLeaveAllocationRepository;
import com.erp.hrm.repository.leave.EmployeeLeaveMasterRepository;
import com.erp.hrm.repository.leave.LeavePolicyRepository;
import com.erp.hrm.repository.leave.LeaveYearRepository;
import com.erp.hrm.service.leave.EmployeeLeaveAllocationProcessService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.BulkInsetUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeEmployeeLeaveAllocationProcessServiceImpl implements EmployeeLeaveAllocationProcessService {

    private EmployeeLeaveAllocationRepository employeeLeaveAllocationRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    private EmployeeLeaveMasterRepository employeeLeaveMasterRepository;
    private LeavePolicyRepository leavePolicyRepository;
    private LeaveYearRepository leaveYearRepository;
    private EntityManagerFactory emf;

    public EmployeeEmployeeLeaveAllocationProcessServiceImpl(
            EmployeeLeaveAllocationRepository employeeLeaveAllocationRepository, EmployeeInfoRepository employeeInfoRepository,
            EmployeeLeaveMasterRepository employeeLeaveMasterRepository, LeavePolicyRepository leavePolicyRepository,
            LeaveYearRepository leaveYearRepository, EntityManagerFactory emf)
    {
        this.employeeLeaveAllocationRepository = employeeLeaveAllocationRepository;
        this.employeeInfoRepository = employeeInfoRepository;
        this.employeeLeaveMasterRepository = employeeLeaveMasterRepository;
        this.leavePolicyRepository = leavePolicyRepository;
        this.leaveYearRepository = leaveYearRepository;
        this.emf = emf;
    }

    @Override
    public List<EmployeeLeaveAllocationDTO> getAllLeaveAllocationByEmployeeCode(String pEmployeeCode) {
        List<EmployeeLeaveAllocationDTO> employeeLeaveAllocationDTOS = new ArrayList<>();
        List<Object[]> allocatedLeaveObj = employeeLeaveAllocationRepository.getAllLeaveAllocationHistoryByEmployeeCode(pEmployeeCode);
        for (Object[] allocatedLeave:allocatedLeaveObj)
        {
            EmployeeLeaveAllocationDTO dto = new EmployeeLeaveAllocationDTO();
            dto.setEmployeeCode((String) allocatedLeave[0]);
            dto.setLeavePolicyID((String) allocatedLeave[1]);
            dto.setLeaveType((String) allocatedLeave[2]);
            dto.setDescription((String) allocatedLeave[3]);
            dto.setLeaveAllocatedDays((Float) allocatedLeave[4]);
            dto.setOpeningBalance((Float) allocatedLeave[5]);

            float totalDays = (Float) allocatedLeave[4] + (Float) allocatedLeave[5];

            dto.setTotalDays(totalDays);
            dto.setEnCashDays((Float) allocatedLeave[6]);
            dto.setAvailedDays((Float) allocatedLeave[7]);
            dto.setAdjustedDays((Float) allocatedLeave[8]);

            float balance = totalDays + (Float) allocatedLeave[7] + (Float) allocatedLeave[8];
            dto.setBalance(balance);
            dto.setEntitlementDate((Date) allocatedLeave[9]);
            employeeLeaveAllocationDTOS.add(dto);
        }
        return employeeLeaveAllocationDTOS;
    }

    @Override
    public ActionResult leaveProcess(LeaveProcessDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            if(dto.isAllEmployee()){
                dto.setEmployeeCodes(employeeInfoRepository.getAllEmployeeCode());
            }
            List<LeavePolicyInfo> leavePolicyInfoList = leavePolicyRepository.findAll();
            LeaveYear leaveYear = leaveYearRepository.getActiveLeaveYear();

            List<EmployeeLeaveMaster> leaveMasterList = new ArrayList<>() ;

            for(String empCode : dto.getEmployeeCodes()){
                for(LeavePolicyInfo policyInfo : leavePolicyInfoList){
                    leaveMasterList.add(getEmployeeMaster(empCode,policyInfo,leaveYear));
                }
            }
            bulkInsertEmployeeLeaveMaster(leaveMasterList);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Leave Processed successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    private EmployeeLeaveMaster getEmployeeMaster(String empCode, LeavePolicyInfo policyInfo, LeaveYear leaveYear) {
        EmployeeLeaveMaster leaveMaster = employeeLeaveMasterRepository.findOneAll(empCode,policyInfo.getLeavePolicyID(),leaveYear.getFromDate(),leaveYear.getToDate());
        if(leaveMaster == null)
            leaveMaster = new EmployeeLeaveMaster();

        leaveMaster.setAdjustedHLeave(0);
        leaveMaster.setLeavePolicyInfo(policyInfo);
        leaveMaster.setEmployeeInfo(employeeInfoRepository.getEmployeeInfo(empCode)); //TODO need to think of it
        leaveMaster.setAvailFrom(leaveYear.getFromDate());
        leaveMaster.setAvailTo(leaveYear.getToDate());
        leaveMaster.setEntitlementDate(leaveYear.getFromDate());
        leaveMaster.setReEntitlementDate(leaveYear.getFromDate());

        leaveMaster.setAllocatedDays(0);
        leaveMaster.setOpeningBalance(0);
        leaveMaster.setPreviousYrAllocation(0);
        leaveMaster.setLeaveAppliedCurrYr(0);
        leaveMaster.setLeaveAvailedCurrYr(0);
        leaveMaster.setLeaveAppliedNextYr(0);
        leaveMaster.setLeaveAvailedNextYr(0);
        leaveMaster.setAdjustedHLeave(0);
        leaveMaster.setLeaveAvailHour(0);
        leaveMaster.setUploadOpeningBalance(0);
        leaveMaster.setEncashDays(0);

        return leaveMaster;
    }

    public List<EmployeeLeaveMaster> bulkInsertEmployeeLeaveMaster(List<EmployeeLeaveMaster> tempList) {
        return BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
}
