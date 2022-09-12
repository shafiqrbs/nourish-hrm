package com.erp.hrm.api;

import com.erp.hrm.api.dto.shift.ShiftPlanRosteringDTO;
import com.erp.hrm.api.dto.shift.ShiftRuleCodeDTO;
import com.erp.hrm.domain.ShiftRule;
import com.erp.hrm.service.ShiftService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sohag on 09/08/2018.
 */
@RestController
@RequestMapping("/api/v1/shiftRules")
public class ShiftRuleApi {
    private ShiftService shiftRuleService;
    public ShiftRuleApi(ShiftService shiftRuleService){
        this.shiftRuleService = shiftRuleService;
    }

    @RequestMapping(value = "/getAllShiftRuleCode", method = RequestMethod.GET)
    public List<ShiftRuleCodeDTO> getAllShiftRuleCode(){
        return shiftRuleService.getAllShiftRuleCode();
    }

    @RequestMapping(value = "/getByRuleCode", method = RequestMethod.GET)
    public ShiftRule getShiftRuleByCode(String pShiftRuleCode){
        return shiftRuleService.getShiftRuleByCode(pShiftRuleCode);
    }

    @RequestMapping(value = "/getAllShiftRuleRosteringByCode", method = RequestMethod.GET)
    public List<ShiftPlanRosteringDTO> getSftRoasteringDetailByCode(String pShiftRuleCode){
        return shiftRuleService.getAllShiftRosteringBySRC(pShiftRuleCode);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ShiftRule getShiftRule(Long id){
        return shiftRuleService.getShiftRuleById(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<ShiftRule> getAllShiftRule(){
        return shiftRuleService.getAllShiftRule();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody ShiftRule shiftRule){
        return shiftRuleService.saveShiftRule(shiftRule);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ActionResult update(@RequestBody ShiftRule shiftRule){
        return shiftRuleService.updateShiftRule(shiftRule);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        shiftRuleService.deleteShiftRule(id);
    }
}