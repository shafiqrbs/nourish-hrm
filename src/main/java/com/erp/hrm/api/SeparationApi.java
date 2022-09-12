package com.erp.hrm.api;

import com.erp.hrm.api.dto.SeparationDTO;
import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.service.SeparationService;
import com.erp.hrm.service.TransferService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sohag on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/separation")
public class SeparationApi {
    private SeparationService separationService;
    public SeparationApi(SeparationService separationService){
        this.separationService = separationService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SeparationDTO findOne(Long id){
        return separationService.findOne(id);
    }

    @RequestMapping(value = "/findAllSeparationByEmployeeCode", method = RequestMethod.GET)
    public List<SeparationDTO> findAllSeparationByEmployeeCode(String pEmployeeCode){
        return separationService.findAllSeparationByEmployeeCode(pEmployeeCode);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SeparationDTO separationDTO){
        return separationService.save(separationDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SeparationDTO separationDTO){
        return separationService.update(separationDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        separationService.delete(id);
    }
}