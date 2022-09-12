package com.erp.hrm.service.impl.leave;

import com.erp.hrm.api.dto.leaveManagement.*;
import com.erp.hrm.domain.*;
import com.erp.hrm.repository.leave.*;
import com.erp.hrm.service.leave.LeavePolicyService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeavePolicyServiceImpl implements LeavePolicyService {
    private LeavePolicyRepository leavePolicyRepository;
    private LeaveRuleRepository leaveRuleRepository;
    private MaternityLeaveRuleRepository maternityLeaveRuleRepository;

    public LeavePolicyServiceImpl(LeavePolicyRepository leavePolicyRepository,LeaveRuleRepository leaveRuleRepository,MaternityLeaveRuleRepository maternityLeaveRuleRepository) {
        this.leavePolicyRepository = leavePolicyRepository;
        this.leaveRuleRepository = leaveRuleRepository;
        this.maternityLeaveRuleRepository = maternityLeaveRuleRepository;
    }

    @Override
    public ActionResult saveLeaveRuleInfo(LeaveRuleInfoDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            LeaveRuleInfo info = new LeaveRuleInfo();
            info.setLeavePolicyID(dto.getLeaveRuleID());
            info.setDescription(dto.getDescription());
            info.setLeaveRuleID(dto.getLeaveRuleID());

            leaveRuleRepository.save(info);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("LeaveRule saved successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<LeaveRuleInfoDTO> getLeaveRuleInfos() {
        List<LeaveRuleInfoDTO> list = new ArrayList<>();
        List<LeaveRuleInfo> infos = leaveRuleRepository.findAll();
        for (int i = 0; i < infos.size(); i ++){
            LeaveRuleInfo info = infos.get(i);
            LeaveRuleInfoDTO dto = new LeaveRuleInfoDTO();
            dto.setDescription(info.getDescription());
            dto.setLeaveRuleID(info.getLeaveRuleID());
            list.add(dto);
        }
        return list;
    }

    @Override
    public List<LeaveRuleDTO> getAllLeaveRuleName() {
        List<Object[]> leaveRuleInfo = leaveRuleRepository.getAllDistinctLeaveRule();
        List<LeaveRuleDTO> leaveRuleDTOS=new ArrayList<>();
        for(Object leaveRule:leaveRuleInfo){
            LeaveRuleDTO leaveRuleDTO=new LeaveRuleDTO();
            leaveRuleDTO.setLeaveRuleName((String) leaveRule);
            leaveRuleDTOS.add(leaveRuleDTO);
        }
        return leaveRuleDTOS;
    }

    @Override
    public ActionResult saveLeavePolicyInfo(LeavePolicyInfoDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            LeavePolicyInfo info = new LeavePolicyInfo();
            String leavePolicyId = generateLeavePolicyId();

            info.setLeavePolicyID(leavePolicyId);
            info.setPolicyDescription(dto.getPolicyDescription());
            info.setLeaveType(dto.getLeaveType());
            info.setLeaveCategory(dto.getLeaveCategory());
            info.setLeaveCredit(dto.getLeaveCredit());

            try {
                info.setDefault(dto.isDefault());
            }catch (Exception e){
                info.setDefault(false);
            }
            try {
                info.setServiceLengthDependant(dto.isServiceLengthDependant());
            }catch (Exception e){
                info.setServiceLengthDependant(false);
            }
            try {

                info.setFixedDays(dto.isFixedDays());
            }catch (Exception e){
                info.setFixedDays(false);
            }
   //         info.setFixedDays(dto.getDayStatus().equals("Fixed")? true : false);
            try {
                info.setCarryForwarded(dto.isCarryForwarded());
            }catch (Exception e){
                info.setCarryForwarded(false);
            }
            try {
                info.setConsecutiveLimit(dto.isConsecutiveLimit());
            }catch (Exception e){
                info.setConsecutiveLimit(false);
            }
            info.setCalculationBasis(dto.getLeaveCalculationBasis());
            info.setCalculateAfter(dto.getCalculateAfter());
            try {
                info.setAllowPreceedingHolidays(dto.isAllowPreceedingHolidays());
            }catch (Exception e){
                info.setAllowPreceedingHolidays(false);
            }
            try {
                info.setAllowSucceedingHolidays(dto.isAllowSucceedingHolidays());
            }catch (Exception e){
                info.setAllowSucceedingHolidays(false);
            }
            //      info.setWorkDayType(dto.getWorkDayType());
            info.setCalenderType(dto.getCalenderType());
//            info.setDayStatus(dto.getDayStatus());
//            info.setAdjustedHour(dto.getADjustedHour());
            try {
                info.setFyrLVProportionateBasedOnDOJDOC(dto.isfYrLVProportionateBasedOnDOJDOC());
            }catch (Exception e){
                info.setFyrLVProportionateBasedOnDOJDOC(false);
            }
            try {
                info.setAllowAdvanceLeave(dto.isAllowAdvanceLeave());
            }catch (Exception e){
                info.setAllowAdvanceLeave(false);
            }
            try {
                info.setAllowOpeningBalance(dto.isAllowOpeningBalance());
            }catch (Exception e){
                info.setAllowOpeningBalance(false);
            }

            leavePolicyRepository.save(info);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("LeavePolicy saved successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult updateLeavePolicyInfo(LeavePolicyInfoDTO dto) {

        ActionResult actionResult = new ActionResult();
        try {
            LeavePolicyInfo info = leavePolicyRepository.findOneByLeavePolicyID(dto.getPolicyID());
            info.setLeavePolicyID(dto.getPolicyID());
            info.setPolicyDescription(dto.getPolicyDescription());
            info.setLeaveType(dto.getLeaveType());
            info.setLeaveCategory(dto.getLeaveCategory());
            info.setLeaveCredit(dto.getLeaveCredit());

            try {
                info.setDefault(dto.isDefault());
            }catch (Exception e){
                info.setDefault(false);
            }
            try {
                info.setServiceLengthDependant(dto.isServiceLengthDependant());
            }catch (Exception e){
                info.setServiceLengthDependant(false);
            }
            try {
                info.setFixedDays(dto.isFixedDays());
            }catch (Exception e){
                info.setFixedDays(false);
            }

//            info.setFixedDays(dto.getDayStatus().equals("Fixed")? true : false);
            try {
                info.setCarryForwarded(dto.isCarryForwarded());
            }catch (Exception e){
                info.setCarryForwarded(false);
            }
            try {
                info.setConsecutiveLimit(dto.isConsecutiveLimit());
            }catch (Exception e){
                info.setConsecutiveLimit(false);
            }
            info.setCalculationBasis(dto.getLeaveCalculationBasis());
            info.setCalculateAfter(dto.getCalculateAfter());
            try {
                info.setAllowPreceedingHolidays(dto.isAllowPreceedingHolidays());
            }catch (Exception e){
                info.setAllowPreceedingHolidays(false);
            }
            try {
                info.setAllowSucceedingHolidays(dto.isAllowSucceedingHolidays());
            }catch (Exception e){
                info.setAllowSucceedingHolidays(false);
            }
            //      info.setWorkDayType(dto.getWorkDayType());
            info.setCalenderType(dto.getCalenderType());
//            info.setDayStatus(dto.getDayStatus());
//            info.setAdjustedHour(dto.getADjustedHour());
            try {
                info.setFyrLVProportionateBasedOnDOJDOC(dto.isfYrLVProportionateBasedOnDOJDOC());
            }catch (Exception e){
                info.setFyrLVProportionateBasedOnDOJDOC(false);
            }
            try {
                info.setAllowAdvanceLeave(dto.isAllowAdvanceLeave());
            }catch (Exception e){
                info.setAllowAdvanceLeave(false);
            }
            try {
                info.setAllowOpeningBalance(dto.isAllowOpeningBalance());
            }catch (Exception e){
                info.setAllowOpeningBalance(false);
            }

            leavePolicyRepository.save(info);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("LeavePolicy updated successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    public String generateLeavePolicyId() {
        String leavePolicyId = leavePolicyRepository.generateLeavePolicyId();
        String[] leavePolicyRegex = leavePolicyId.split("-");
        int number = Integer.parseInt(leavePolicyRegex[2])+1;
        String newLeavePolicyId = "LV-11-"+number;
        return newLeavePolicyId;
    }

    @Override
    public List<LeavePolicyInfoDTO> getLeavePolicyInfos() {
        List<LeavePolicyInfo> infos = leavePolicyRepository.findAll();
        List<LeavePolicyInfoDTO> list = new ArrayList<>();
        for (LeavePolicyInfo info:infos)
        {
            LeavePolicyInfoDTO dto = new LeavePolicyInfoDTO();

            dto.setPolicyID(info.getLeavePolicyID());
            dto.setPolicyDescription(info.getPolicyDescription());
            dto.setLeaveType(info.getLeaveType());
            dto.setLeaveCategory(info.getLeaveCategory());
            dto.setLeaveCredit(info.getLeaveCredit());
            dto.setLeaveCalculationBasis(info.getCalculationBasis());

            try {
                dto.setDefault(info.isDefault());
            }catch (Exception e){
                dto.setDefault(false);
            }
            try {
                dto.setServiceLengthDependant(info.isServiceLengthDependant());
            }catch (Exception e){
                dto.setServiceLengthDependant(false);
            }
            try {
                dto.setFixedDays(info.isFixedDays());
            }catch (Exception e){
                dto.setFixedDays(false);
            }
      //      dto.setDayStatus(info.isFixedDays() ? "Fixed" : "Based on Working Days");
            try {
                dto.setCarryForwarded(info.isCarryForwarded());
            }catch (Exception e){
                dto.setCarryForwarded(false);
            }
            try {
                dto.setConsecutiveLimit(info.isConsecutiveLimit());
            }catch (Exception e){
                dto.setConsecutiveLimit(false);
            }
            dto.setLeaveCalculationBasis(info.getCalculationBasis());
            dto.setCalculateAfter(info.getCalculateAfter());
            try {
                dto.setAllowPreceedingHolidays(info.isAllowPreceedingHolidays());
            }catch (Exception e){
                dto.setAllowPreceedingHolidays(false);
            }
            try {
                dto.setAllowSucceedingHolidays(info.isAllowSucceedingHolidays());
            }catch (Exception e){
                dto.setAllowSucceedingHolidays(false);
            }
            //      dto.setWorkDayType(info.getWorkDayType());
            dto.setCalenderType(info.getCalenderType());
//            dto.setDayStatus(info.getDayStatus());
//            dto.setAdjustedHour(info.getADjustedHour());
            try {
                dto.setfYrLVProportionateBasedOnDOJDOC(info.isFyrLVProportionateBasedOnDOJDOC());
            }catch (Exception e){
                dto.setfYrLVProportionateBasedOnDOJDOC(false);
            }
            try {
                dto.setAllowAdvanceLeave(info.isAllowAdvanceLeave());
            }catch (Exception e){
                dto.setAllowAdvanceLeave(false);
            }
            try {
                dto.setAllowOpeningBalance(info.isAllowOpeningBalance());
            }catch (Exception e){
                dto.setAllowOpeningBalance(false);
            }

            list.add(dto);
        }

        return list;
    }

    @Override
    public List<LeaveTypeDTO> getAllLeaveType() {
        List<LeaveTypeDTO> leaveTypeDTOS=new ArrayList<>();
        List<Object[]> leaveTypes=leavePolicyRepository.getAllLeaveType();
        for (Object[] leaveType : leaveTypes) {
            LeaveTypeDTO leaveTypeDTO = new LeaveTypeDTO();
            leaveTypeDTO.setLeavePolicyID((String) leaveType[0]);
            leaveTypeDTO.setLeaveType((String) leaveType[1]);
            leaveTypeDTOS.add(leaveTypeDTO);
        }
        return leaveTypeDTOS;
    }

    @Override
    public List<LeaveCategoryDTO> getAllLeaveCategory() {
        List<LeaveCategoryDTO> leaveCategoryDTOS=new ArrayList<>();
        List<Object[]> leaveCategoryObj = leavePolicyRepository.getAllLeaveCategory();
        for (Object leaveCategory : leaveCategoryObj) {
            LeaveCategoryDTO leaveCategoryDTO = new LeaveCategoryDTO();
            leaveCategoryDTO.setLeaveCategory((String) leaveCategory);
            leaveCategoryDTOS.add(leaveCategoryDTO);
        }
        return leaveCategoryDTOS;
    }

    @Override
    public List<LeaveCreditDTO> getAllLeaveCredit() {
        List<LeaveCreditDTO> leaveCreditDTOS=new ArrayList<>();
        List<Object[]> leaveCreditObj = leavePolicyRepository.getAllLeaveCredit();
        for (Object leaveCredit : leaveCreditObj) {
            LeaveCreditDTO leaveCreditDTO = new LeaveCreditDTO();
            leaveCreditDTO.setLeaveCredit((String) leaveCredit);
            leaveCreditDTOS.add(leaveCreditDTO);
        }
        return leaveCreditDTOS;
    }

    @Override
    public LeavePolicyInfoDTO getLeavePolicy(String LeavePolicyID) {
        LeavePolicyInfo info = leavePolicyRepository.findOneByLeavePolicyID(LeavePolicyID);
        LeavePolicyInfoDTO dto = new LeavePolicyInfoDTO();

        dto.setPolicyID(info.getLeavePolicyID());
        dto.setPolicyDescription(info.getPolicyDescription());
        dto.setLeaveType(info.getLeaveType());
        dto.setLeaveCategory(info.getLeaveCategory());
        dto.setLeaveCredit(info.getLeaveCredit());
        dto.setLeaveCalculationBasis(info.getCalculationBasis());

        try {
            dto.setDefault(info.isDefault());
        }catch (Exception e){
            dto.setDefault(false);
        }
        try {
            dto.setServiceLengthDependant(info.isServiceLengthDependant());
        }catch (Exception e){
            dto.setServiceLengthDependant(false);
        }
        try {
            dto.setFixedDays(info.isFixedDays());
        }catch (Exception e){
            dto.setFixedDays(false);
        }

        dto.setDayStatus(info.isFixedDays() ? "Fixed" : "Based on Working Days");
        try {
            dto.setCarryForwarded(info.isCarryForwarded());
        }catch (Exception e){
            dto.setCarryForwarded(false);
        }
        try {
            dto.setConsecutiveLimit(info.isConsecutiveLimit());
        }catch (Exception e){
            dto.setConsecutiveLimit(false);
        }
        dto.setLeaveCalculationBasis(info.getCalculationBasis());
        dto.setCalculateAfter(info.getCalculateAfter());
        try {
            dto.setAllowPreceedingHolidays(info.isAllowPreceedingHolidays());
        }catch (Exception e){
            dto.setAllowPreceedingHolidays(false);
        }
        try {
            dto.setAllowSucceedingHolidays(info.isAllowSucceedingHolidays());
        }catch (Exception e){
            dto.setAllowSucceedingHolidays(false);
        }
        //      dto.setWorkDayType(info.getWorkDayType());
        dto.setCalenderType(info.getCalenderType());
//            dto.setDayStatus(info.getDayStatus());
//            dto.setAdjustedHour(info.getADjustedHour());
        try {
            dto.setfYrLVProportionateBasedOnDOJDOC(info.isFyrLVProportionateBasedOnDOJDOC());
        }catch (Exception e){
            dto.setfYrLVProportionateBasedOnDOJDOC(false);
        }
        try {
            dto.setAllowAdvanceLeave(info.isAllowAdvanceLeave());
        }catch (Exception e){
            dto.setAllowAdvanceLeave(false);
        }
        try {
            dto.setAllowOpeningBalance(info.isAllowOpeningBalance());
        }catch (Exception e){
            dto.setAllowOpeningBalance(false);
        }
        return dto;
    }

    @Override
    public ActionResult saveMaternityLeavePolicyInfo(MaternityLeavePolicyDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            MaternityLeaveRule info = new MaternityLeaveRule();

            info.setMaternityLeaveRuleID(dto.getMaternityLeaveRuleID());
            info.setDescription(dto.getDescription());
            info.setNoOfDays(dto.getNoOfDays());
            info.setMaxBenefit(dto.getMaxBenefit());
            info.setDayGap(dto.getDayGap());
            info.setDaysBenefitBefore(dto.getDaysBenefitBefore());
            info.setCanGetBenefitAfterDays(dto.getCanGetBenefitAfterDays());
            info.setDependsOn(dto.getDependsOn());
            info.setYearCalculatedFrom(dto.getYearCalculatedFrom());
            info.setoTAverageMonth(dto.getoTAverageMonth());

            try {
                info.setTransactionMonth(dto.isTransactionMonth());
            }catch (Exception e){
                info.setTransactionMonth(false);
            }

            info.setCalculationOn(dto.getCalculationOn());
            info.setBasedOn(dto.getBasedOn());

            try {
                info.setConsiderEDD(dto.isConsiderEDD());
            }catch (Exception e){
                info.setConsiderEDD(false);
            }

            info.setBasedHead(dto.getBasedHead());
            info.setReportingHead(dto.getReportingHead());
            info.setCalculateBasedOn(dto.getCalculateBasedOn());
            info.setDayStatus(dto.getDayStatus());

            try {
                info.setConsiderSalaryHead(dto.isConsiderSalaryHead());
            }catch (Exception e){
                info.setConsiderSalaryHead(false);
            }

            maternityLeaveRuleRepository.save(info);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Maternity LeavePolicy saved successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult updateMaternityLeavePolicyInfo(MaternityLeavePolicyDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            MaternityLeaveRule info = maternityLeaveRuleRepository.findOneByMaternityLeaveRuleID(dto.getMaternityLeaveRuleID());
            info.setDescription(dto.getDescription());
            info.setNoOfDays(dto.getNoOfDays());
            info.setMaxBenefit(dto.getMaxBenefit());
            info.setDayGap(dto.getDayGap());
            info.setDaysBenefitBefore(dto.getDaysBenefitBefore());
            info.setCanGetBenefitAfterDays(dto.getCanGetBenefitAfterDays());
            info.setDependsOn(dto.getDependsOn());
            info.setYearCalculatedFrom(dto.getYearCalculatedFrom());
            info.setoTAverageMonth(dto.getoTAverageMonth());

            try {
                info.setTransactionMonth(dto.isTransactionMonth());
            }catch (Exception e){
                info.setTransactionMonth(false);
            }

            info.setCalculationOn(dto.getCalculationOn());
            info.setBasedOn(dto.getBasedOn());

            try {
                info.setConsiderEDD(dto.isConsiderEDD());
            }catch (Exception e){
                info.setConsiderEDD(false);
            }

            info.setBasedHead(dto.getBasedHead());
            info.setReportingHead(dto.getReportingHead());
            info.setCalculateBasedOn(dto.getCalculateBasedOn());
            info.setDayStatus(dto.getDayStatus());

            try {
                info.setConsiderSalaryHead(dto.isConsiderSalaryHead());
            }catch (Exception e){
                info.setConsiderSalaryHead(false);
            }

            maternityLeaveRuleRepository.save(info);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Maternity LeavePolicy updated successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<MaternityLeavePolicyDTO> getMaternityLeavePolicyInfos() {
        List<MaternityLeaveRule> infos = maternityLeaveRuleRepository.findAll();
        List<MaternityLeavePolicyDTO> list = new ArrayList<>();
        for (MaternityLeaveRule info:infos)
        {
            MaternityLeavePolicyDTO dto = new MaternityLeavePolicyDTO();

            dto.setDescription(info.getDescription());
            dto.setNoOfDays(info.getNoOfDays());
            dto.setMaxBenefit(info.getMaxBenefit());
            dto.setDayGap(info.getDayGap());
            dto.setDaysBenefitBefore(info.getDaysBenefitBefore());
            dto.setCanGetBenefitAfterDays(info.getCanGetBenefitAfterDays());
            dto.setDependsOn(info.getDependsOn());
            dto.setYearCalculatedFrom(info.getYearCalculatedFrom());
            dto.setoTAverageMonth(info.getoTAverageMonth());

            try {
                dto.setTransactionMonth(info.isTransactionMonth());
            }catch (Exception e){
                dto.setTransactionMonth(false);
            }

            dto.setCalculationOn(info.getCalculationOn());
            dto.setBasedOn(info.getBasedOn());

            try {
                dto.setConsiderEDD(info.isConsiderEDD());
            }catch (Exception e){
                dto.setConsiderEDD(false);
            }

            dto.setBasedHead(info.getBasedHead());
            dto.setReportingHead(info.getReportingHead());
            dto.setCalculateBasedOn(info.getCalculateBasedOn());
            dto.setDayStatus(info.getDayStatus());

            try {
                dto.setConsiderSalaryHead(info.isConsiderSalaryHead());
            }catch (Exception e){
                dto.setConsiderSalaryHead(false);
            }

            list.add(dto);
        }

        return list;
    }

    @Override
    public MaternityLeavePolicyDTO getMaternityLeavePolicy(String pMaternityLeavePolicyID) {
        MaternityLeaveRule info = maternityLeaveRuleRepository.findOneByMaternityLeaveRuleID(pMaternityLeavePolicyID);

        MaternityLeavePolicyDTO dto = new MaternityLeavePolicyDTO();
        dto.setMaternityLeaveRuleID(info.getMaternityLeaveRuleID());
        dto.setDescription(info.getDescription());
        dto.setNoOfDays(info.getNoOfDays());
        dto.setMaxBenefit(info.getMaxBenefit());
        dto.setDayGap(info.getDayGap());
        dto.setDaysBenefitBefore(info.getDaysBenefitBefore());
        dto.setCanGetBenefitAfterDays(info.getCanGetBenefitAfterDays());
        dto.setDependsOn(info.getDependsOn());
        dto.setYearCalculatedFrom(info.getYearCalculatedFrom());
        dto.setoTAverageMonth(info.getoTAverageMonth());

        try {
            dto.setTransactionMonth(info.isTransactionMonth());
        }catch (Exception e){
            dto.setTransactionMonth(false);
        }

        dto.setCalculationOn(info.getCalculationOn());
        dto.setBasedOn(info.getBasedOn());

        try {
            dto.setConsiderEDD(info.isConsiderEDD());
        }catch (Exception e){
            dto.setConsiderEDD(false);
        }

        dto.setBasedHead(info.getBasedHead());
        dto.setReportingHead(info.getReportingHead());
        dto.setCalculateBasedOn(info.getCalculateBasedOn());
        dto.setDayStatus(info.getDayStatus());

        try {
            dto.setConsiderSalaryHead(info.isConsiderSalaryHead());
        }catch (Exception e){
            dto.setConsiderSalaryHead(false);
        }

        return dto;
    }

    @Override
    public List<MaternityLeaveRuleDTO> getAllMaternityLeaveRule() {
        List<Object[]> maternityLeaveRuleObj = maternityLeaveRuleRepository.getAllDistinctMaternityLeaveRule();
        List<MaternityLeaveRuleDTO> maternityLeaveRuleDTOS=new ArrayList<>();
        for(Object maternityLeaveRule:maternityLeaveRuleObj){
            MaternityLeaveRuleDTO maternityLeaveRuleDTO=new MaternityLeaveRuleDTO();
            maternityLeaveRuleDTO.setMaternityLeaveRuleID((String) maternityLeaveRule);
            maternityLeaveRuleDTOS.add(maternityLeaveRuleDTO);
        }
        return maternityLeaveRuleDTOS;
    }
}
