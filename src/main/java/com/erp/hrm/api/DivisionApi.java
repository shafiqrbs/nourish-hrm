package com.erp.hrm.api;

import com.erp.hrm.domain.Division;
import com.erp.hrm.service.DivisionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/divisions")
public class DivisionApi {
    private DivisionService divisionService;
    public DivisionApi(DivisionService divisionService){
        this.divisionService = divisionService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Division findOne(Long id){
        return divisionService.findOne(id);
    }

    @RequestMapping(value = "/getAllDivision", method = RequestMethod.GET)
    public List<Division> findAllDivision(){
        return divisionService.findAllDivision();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody Division division){
        return divisionService.save(division);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody Division division){
        return divisionService.update(division);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        divisionService.delete(id);
    }
}