package com.erp.hrm.service.impl.leave;

import com.erp.hrm.api.dto.leaveManagement.EmployeeLeaveTransactionDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.EmpLeaveTransactionApplied;
import com.erp.hrm.domain.LeavePolicyInfo;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.leave.*;
import com.erp.hrm.service.leave.EmployeeLeaveTransactionService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.ErpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeLeaveTransactionServiceImpl implements EmployeeLeaveTransactionService {
    private EmployeeLeaveTransactionRepository employeeLeaveTransactionRepository;
    private LeavePolicyRepository leavePolicyRepository;
    private EmployeeInfoRepository employeeInfoRepository;

    public EmployeeLeaveTransactionServiceImpl(EmployeeLeaveTransactionRepository employeeLeaveTransactionRepository,EmployeeInfoRepository employeeInfoRepository,LeavePolicyRepository leavePolicyRepository)
    {
        this.employeeLeaveTransactionRepository = employeeLeaveTransactionRepository;
        this.employeeInfoRepository = employeeInfoRepository;
        this.leavePolicyRepository = leavePolicyRepository;
    }

    @Override
    public ActionResult saveEmployeeLeaveTransaction(EmployeeLeaveTransactionDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            int totalTransCount = employeeLeaveTransactionRepository.getEmployeeLeaveTransactionCount(dto.getEmployeeCode());
            String transactionId = ErpUtils.generateMaternityLeaveTransId("LVTR",dto.getFromDate(),totalTransCount);
            EmpLeaveTransactionApplied info = new EmpLeaveTransactionApplied();
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(dto.getEmployeeCode());
            LeavePolicyInfo leavePolicyInfo = leavePolicyRepository.findOneByLeavePolicyID(dto.getLeavePolicyID());
            info.setTransactionID(transactionId);
            info.setTransactionDate(ErpUtils.todayDate());
            info.setEmployeeInfo(employeeInfo);
            info.setLeavePolicyInfo(leavePolicyInfo);
            info.setFromDate(dto.getFromDate());
            info.setToDate(dto.getToDate());
            info.setLeaveDays(dto.getLeaveDays());

            try {
                info.setLeaveDaysNextYr(dto.getLeaveDaysNextYr());
            }catch (Exception e){
                info.setLeaveDaysNextYr(0);
            }

            try {
                info.setReqSync(dto.isReqSync());
            }catch (Exception e){
                info.setReqSync(false);
            }

            info.setLeaveReason(dto.getLeaveReason());
            info.setLeaveAvailPlace(dto.getLeaveAvailPlace());

            try {
                info.setReqSync(dto.isReqSync());
            }catch (Exception e){
                info.setReqSync(false);
            }

            try{
                info.setForwarded(dto.isForwarded());
            }catch (Exception ex){
                info.setForwarded(false);
            }

            try{
                info.setRecomended(dto.isRecomended());
            }catch (Exception ex){
                info.setRecomended(false);
            }

            try{
                info.setApproved(dto.isApproved());
            }catch (Exception ex){
                info.setApproved(false);
            }

            try{
                info.setRejected(dto.isRejected());
            }catch (Exception ex){
                info.setRejected(false);
            }

            try{
                info.setPostApproved(dto.isPostApproved());
            }catch (Exception ex){
                info.setPostApproved(false);
            }

            try{
                info.setPreApproved(dto.isPreApproved());
            }catch (Exception ex){
                info.setPreApproved(false);
            }

            employeeLeaveTransactionRepository.save(info);
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Leave successfully applied!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<EmployeeLeaveTransactionDTO> getEmployeeLeaveTransactions(String pEmployeeCode) {
        List<EmployeeLeaveTransactionDTO> employeeLeaveTransactionDTOS = new ArrayList<>();
        try {
            List<Object[]> leaveTransObj = employeeLeaveTransactionRepository.getAllEmployeeAppliedLeaveTrans(pEmployeeCode);
            for (Object[] leaveTrans:leaveTransObj)
            {
                EmployeeLeaveTransactionDTO dto = new EmployeeLeaveTransactionDTO();
                dto.setEmployeeCode((String) leaveTrans[0]);
                dto.setLeaveType((String) leaveTrans[1]);
                dto.setFromDate((Date) leaveTrans[2]);
                dto.setToDate((Date) leaveTrans[3]);
                dto.setLeaveDays((double) leaveTrans[4]);
                dto.setLeaveReason((String) leaveTrans[5]);

                try{
                    dto.setApproved((boolean) leaveTrans[6]);
                }catch (Exception ex){
                    dto.setApproved(false);
                }

                employeeLeaveTransactionDTOS.add(dto);
            }
        } catch (Exception ex){
            employeeLeaveTransactionDTOS = null;
        }
        return employeeLeaveTransactionDTOS;
    }
}
