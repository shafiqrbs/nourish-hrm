package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.CountryDTO;
import com.erp.hrm.service.CountryService;
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
@RequestMapping("/api/v1/overtime")
public class
OvertimeTimeApi {
    private CountryService countryService;
    public OvertimeTimeApi(CountryService countryService){
        this.countryService = countryService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public CountryDTO findOne(Long id){
        return countryService.findOne(id);
    }

    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    public List<CountryDTO> findAllCountry(){
        return countryService.findAllCountry();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody CountryDTO countryDTO){
        return countryService.save(countryDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody CountryDTO countryDTO){
        return countryService.update(countryDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        countryService.delete(id);
    }
}