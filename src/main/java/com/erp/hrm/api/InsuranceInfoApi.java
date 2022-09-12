package com.erp.hrm.api;

import com.erp.hrm.domain.InsuranceInfo;
import com.erp.hrm.service.InsuranceInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/insuranceInfos")
public class InsuranceInfoApi {
    private InsuranceInfoService insuranceInfoService;
    public InsuranceInfoApi(InsuranceInfoService insuranceInfoService){
        this.insuranceInfoService = insuranceInfoService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public InsuranceInfo findOne(Long id){
        return insuranceInfoService.findOne(id);
    }

    @RequestMapping(value = "/findAllInsuranceInfo", method = RequestMethod.GET)
    public List<InsuranceInfo> findAllInsuranceInfo(){
        return insuranceInfoService.findAllInsuranceInfo();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<InsuranceInfo> findAll(){
        return insuranceInfoService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public InsuranceInfo save(@RequestBody InsuranceInfo insuranceInfo){
        return insuranceInfoService.save(insuranceInfo);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public InsuranceInfo update(@RequestBody InsuranceInfo insuranceInfo){
        return insuranceInfoService.update(insuranceInfo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Long id){
        insuranceInfoService.delete(id);
    }
}