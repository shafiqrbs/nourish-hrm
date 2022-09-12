package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.FloorDTO;
import com.erp.hrm.domain.Floor;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface FloorService {
    ActionResult save(FloorDTO floorDTO);

    ActionResult update(FloorDTO floorDTO);

    List<FloorDTO> findAllFloor();

    FloorDTO findOne(Integer id);

    void delete(Integer id);
}
