package com.erp.hrm.api;

import com.erp.hrm.domain.Country;
import com.erp.hrm.domain.Nationality;
import com.erp.hrm.service.CountryService;
import com.erp.hrm.service.NationalityService;
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
@RequestMapping("/api/v1/nationality")
public class NationalityApi {
    private NationalityService nationalityService;
    public NationalityApi(NationalityService nationalityService){
        this.nationalityService = nationalityService;
    }

    @RequestMapping(value = "/getAllNationality", method = RequestMethod.GET)
    public List<Nationality> findAllNationality(){
        return nationalityService.findAll();
    }
}