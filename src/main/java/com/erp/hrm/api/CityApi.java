package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.CityDTO;
import com.erp.hrm.service.CityService;
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
@RequestMapping("/api/v1/cities")
public class CityApi {
    private CityService cityService;
    public CityApi(CityService cityService){
        this.cityService = cityService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public CityDTO findOne(Long id){
        return cityService.findOne(id);
    }

    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    public List<CityDTO> findAllCity(){
        return cityService.findAllCity();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody CityDTO cityDTO){
        return cityService.save(cityDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody CityDTO cityDTO){
        return cityService.update(cityDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        cityService.delete(id);
    }
}