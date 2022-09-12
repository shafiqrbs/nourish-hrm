package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.CountryDTO;
import com.erp.hrm.domain.Country;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface CountryService {
    ActionResult save(CountryDTO countryDTO);

    ActionResult update(CountryDTO countryDTO);

    List<CountryDTO> findAllCountry();

    CountryDTO findOne(Long id);

    void delete(Long id);
}
