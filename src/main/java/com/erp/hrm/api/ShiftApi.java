package com.erp.hrm.api;


import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.shift.*;
import com.erp.hrm.domain.ManualShiftTempEmployeeCode;
import com.erp.hrm.domain.RosteringTempEmployeeCode;
import com.erp.hrm.domain.ShiftPlan;
import com.erp.hrm.domain.ShiftRule;
import com.erp.hrm.service.ShiftService;
import com.erp.hrm.util.ActionResult;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by WS on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/shift")
public class ShiftApi {
    private ShiftService shiftService;

    public ShiftApi(ShiftService shiftService) {
        this.shiftService = shiftService;
    }

    @RequestMapping(value = "/plan/get", method = RequestMethod.GET)
    public ShiftPlanDTO getShiftPlan(String ShiftId){
        return shiftService.getShiftPlan(ShiftId);
    }

    @RequestMapping(value = "/plan/getAllShift", method = RequestMethod.GET)
    public List<ShiftDTO> getAllShift(){
        return shiftService.getAllShift();
    }

    @RequestMapping(value = "/plan/getAllShiftType", method = RequestMethod.GET)
    public List<ShiftTypeDTO> getAllShiftType(){
        return shiftService.getAllShiftType();
    }

    @RequestMapping(value = "/plan/getAllShiftPlan", method = RequestMethod.GET)
    public List<ShiftPlan> getAllShiftPlan(){
        return shiftService.getAllShiftPlan();
    }

    @RequestMapping(value = "/plan/getAllShiftPlanByShiftNature", method = RequestMethod.GET)
    public List<ShiftPlan> getAllShiftPlan(String pShiftNature){
        return shiftService.getAllShiftPlan(pShiftNature);
    }

    @RequestMapping(value = "/plan/save", method = RequestMethod.POST)
    public ActionResult saveShiftPlan(@RequestBody ShiftPlanDTO dto){
        return shiftService.saveShiftPlan(dto);
    }

    @RequestMapping(value = "/rule/get", method = RequestMethod.GET)
    public ShiftRule getShiftRule(long id){
        return shiftService.getShiftRuleById(id);
    }

    @RequestMapping(value = "/rule/getAll", method = RequestMethod.GET)
    public List<ShiftRule> getAllShiftRule(){
        return shiftService.getAllShiftRule();
    }

    @RequestMapping(value = "/workOffCalendar/saveToTemp", method = RequestMethod.POST)
    public ActionResult saveWorkOffCalendar(@RequestBody WorkOffCalendarDTO dto){
        return shiftService.saveWorkOffCalendar(dto);
    }

    @RequestMapping(value = "/workOffCalendar/pushFromTemp", method = RequestMethod.GET)
    public ActionResult pushWorkOffCalendar(String pUserId){
        return shiftService.pushWorkOffCalendar(pUserId);
    }

    @RequestMapping(value = "/workOffCalendar/getTempList", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getWorkOffCalendarTempList(String pUserId,PageableDTO pageableDTO){
        return shiftService.getWorkOffCalendarTempList(pUserId,pageableDTO);
    }

    @RequestMapping(value = "/rule/rostering/getAll", method = RequestMethod.GET)
    public List<ShiftPlanRosteringDTO> getAllShiftRosteringBySRC(String pShiftRuleCode){
        return shiftService.getAllShiftRosteringBySRC(pShiftRuleCode);
    }

    @RequestMapping(value = "/rule/rostering/process", method = RequestMethod.POST)
    public ActionResult processShiftRostering(@RequestBody ShiftRosteringDTO dto){
        return shiftService.processShiftRostering(dto);
    }

    @RequestMapping(value = "/saveRosteringEmployeeCodeIntoTemp", method = RequestMethod.POST)
    public @ResponseBody
    ActionResult saveRosteringEmployeeCodeIntoTemp(@RequestBody RosteringTempEmployeeCodeDTO dto){
        return shiftService.saveRosteringEmployeeCodeIntoTemp(dto);
    }

    @RequestMapping(value = "/shiftRosteringProcess/getTempList", method = RequestMethod.GET)
    public EmployeeInfoGridDTO getRosteringTempEployeeList(String pUserId,PageableDTO pageableDTO){
        return shiftService.getRosteringTempEployeeList(pUserId,pageableDTO);
    }

    @RequestMapping(value = "/rule/save", method = RequestMethod.POST)
    public ActionResult saveShiftRulle(@RequestBody ShiftRule shiftRule, List<ShiftPlanRosteringDTO> shiftPlanRosteringDTOS){
        return shiftService.saveShiftRuleWithRostering(shiftRule,shiftPlanRosteringDTOS);
    }

    @RequestMapping(value = "/saveManualShiftEmployeeCodeIntoTemp", method = RequestMethod.POST)
    public @ResponseBody
    ActionResult saveManualShiftEmployeeCodeIntoTemp(@RequestBody ManualShiftTempEmployeeCodeDTO dto){
        return shiftService.saveManualShiftEmployeeCodeIntoTemp(dto);
    }

    @RequestMapping(value = "/shift/manualShiftRosterSave", method = RequestMethod.POST)
    public ActionResult saveManualShiftRoster(@RequestBody ManualShiftAssignmentDTO dto){
        return shiftService.saveManualShiftRoster(dto);
    }
}
