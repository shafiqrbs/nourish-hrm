package com.erp.hrm.service;

import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeRuleTagDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.shift.*;
import com.erp.hrm.domain.ManualShiftTempEmployeeCode;
import com.erp.hrm.domain.RosteringTempEmployeeCode;
import com.erp.hrm.domain.ShiftPlan;
import com.erp.hrm.domain.ShiftRule;
import com.erp.hrm.util.ActionResult;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by WS on 15/06/2018.
 */
public interface ShiftService {
    ShiftPlanDTO getShiftPlan(String ShiftId);
    List<ShiftDTO> getAllShift();
    List<ShiftTypeDTO> getAllShiftType();
    List<ShiftPlan> getAllShiftPlan();
    List<ShiftPlan> getAllShiftPlan(String pShiftNature);
    ActionResult saveShiftPlan(ShiftPlanDTO dto);

    List<ShiftRuleCodeDTO> getAllShiftRuleCode();
    ShiftRule getShiftRuleByCode(String pShiftRuleCode);
    List<ShiftRule> getAllShiftRule();
    ShiftRule getShiftRuleById(long pId);
    ActionResult saveShiftRule(ShiftRule shiftRule);
    ActionResult updateShiftRule(ShiftRule shiftRule);
    void deleteShiftRule(Long pId);

    List<ShiftPlanRosteringDTO> getAllShiftRosteringBySRC(String pShiftRuleCode);
    ActionResult saveShiftRuleRostering(List<ShiftPlanRosteringDTO> shiftPlanRosteringDTOS);
    ActionResult saveShiftRuleWithRostering(ShiftRule shiftRule, List<ShiftPlanRosteringDTO> shiftPlanRosteringDTOS);
    ActionResult saveRosteringEmployeeCodeIntoTemp(RosteringTempEmployeeCodeDTO dto);
    EmployeeInfoGridDTO getRosteringTempEployeeList(String pUserId,PageableDTO pageableDTO);

    ActionResult saveManualShiftRoster(ManualShiftAssignmentDTO dto);
    ActionResult saveManualShiftEmployeeCodeIntoTemp(ManualShiftTempEmployeeCodeDTO dto);

    ActionResult saveWorkOffCalendar(WorkOffCalendarDTO dto);
    ActionResult pushWorkOffCalendar(String pUserId);
    EmployeeInfoGridDTO getWorkOffCalendarTempList(String pUserId,PageableDTO pageableDTO);

    ActionResult processShiftRostering(ShiftRosteringDTO dto);
}
