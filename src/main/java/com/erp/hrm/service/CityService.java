package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.CityDTO;
import com.erp.hrm.domain.City;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface CityService {
    ActionResult save(CityDTO cityDTO);

    ActionResult update(CityDTO cityDTO);

    List<CityDTO> findAllCity();

    CityDTO findOne(Long id);

    void delete(Long id);
}
