package com.erp.hrm.api;

import com.erp.hrm.domain.Unit;
import com.erp.hrm.service.UnitService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/units")
public class UnitApi {
    private UnitService unitService;
    public UnitApi(UnitService unitService){
        this.unitService = unitService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Unit findOne(Long id){
        return unitService.findOne(id);
    }

    @RequestMapping(value = "/getAllUnit", method = RequestMethod.GET)
    public List<Unit> findAllUnit(){
        return unitService.findAllUnit();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody Unit unit){
        return unitService.save(unit);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody Unit unit){
        return unitService.update(unit);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        unitService.delete(id);
    }
}