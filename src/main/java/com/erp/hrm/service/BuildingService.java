package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.BuildingDTO;
import com.erp.hrm.domain.Building;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface BuildingService {
    ActionResult save(BuildingDTO buildingDTO);

    ActionResult update(BuildingDTO buildingDTO);

    List<BuildingDTO> findAllBuilding();

    BuildingDTO findOne(Integer id);

    void delete(Integer id);
}
