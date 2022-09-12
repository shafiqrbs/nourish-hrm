package com.erp.hrm.service.leave;

import com.erp.hrm.api.dto.leaveManagement.*;
import com.erp.hrm.domain.EmpLeaveTransactionApplied;
import com.erp.hrm.domain.EmployeeLeaveMaster;
import com.erp.hrm.domain.LeaveYear;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface LeaveInfoService {
    ActionResult saveLeaveYear(LeaveYear dto);
    List<LeaveYear> getLeaveYears();
    LeaveYear getActiveLeaveYear();

    ActionResult saveLeaveRuleInfo(LeaveRuleInfoDTO dto);
    List<LeaveRuleInfoDTO> getLeaveRuleInfos();
    List<LeaveRuleDTO> getAllLeaveRuleName();

    ActionResult saveLeavePolicyInfo(LeavePolicyInfoDTO dto);
    ActionResult updateLeavePolicyInfo(LeavePolicyInfoDTO dto);
    List<LeavePolicyInfoDTO> getLeavePolicyInfos();
    LeavePolicyInfoDTO getLeavePolicy(String LeavePolicyID);
    List<LeaveTypeDTO> getAllLeaveType();
    List<LeaveCategoryDTO> getAllLeaveCategory();
    List<LeaveCreditDTO> getAllLeaveCredit();

    ActionResult saveMaternityLeavePolicyInfo(MaternityLeavePolicyDTO dto);
    ActionResult updateMaternityLeavePolicyInfo(MaternityLeavePolicyDTO dto);
    List<MaternityLeavePolicyDTO> getMaternityLeavePolicyInfos();
    MaternityLeavePolicyDTO getMaternityLeavePolicy(String pMaternityLeavePolicyID);
    List<MaternityLeaveRuleDTO> getAllMaternityLeaveRule();

    ActionResult saveLeaveDeductionInfo(LeaveDeductionEncashmentDTO dto);
    List<LeaveDeductionEncashmentDTO> getLeaveDeductionInfos();
    LeaveDeductionEncashmentDTO getLeaveDeduction(String LeavePolicyID);

    ActionResult saveLeaveEncashment(LeaveDeductionEncashmentDTO dto);
    List<LeaveDeductionEncashmentDTO> getLeaveEncashmentInfos();
    LeaveDeductionEncashmentDTO getLeaveEncashment(String LeavePolicyID);

    ActionResult saveLeaveTransInfo(LeaveTransInfoDTO dto);
    List<LeaveTransInfoDTO> getLeaveTransInfos();
    List<LeaveTransInfoDTO> getLeaveTransInfo(String EmployeeCode);

    ActionResult saveMaternityLeaveTransInfo(MaternityLeaveTransInfoDTO dto);
    List<MaternityLeaveTransInfoDTO> getMaternityLeaveTransInfos();
    List<MaternityLeaveTransInfoDTO> getMaternityLeaveTransInfo(String EmployeeCode);


    ActionResult saveLeaveTransactionApplied(EmpLeaveTransactionApplied empLeaveTransactionApplied);
    List<EmpLeaveTransactionApplied> getLeaveTransactionApplieds();


    ActionResult saveEmployeeLeaveMaster(EmployeeLeaveMaster employeeLeaveMaster);
    List<EmployeeLeaveMaster> getEmployeeLeaveMasters();

    /*
    ActionResult saveLeaveHourlyTransactioInfo(LeaveHourlyTransactionDTO dto);
    List<LeaveHourlyTransactionDTO> getLeaveHourlyTransactionInfos();
    LeaveHourlyTransactionDTO getLeaveHourlyTransactionInfo(String EmployeeCode);
    */
}
