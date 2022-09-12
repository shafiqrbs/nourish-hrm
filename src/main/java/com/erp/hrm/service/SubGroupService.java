package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.SubGroupDTO;
import com.erp.hrm.domain.SubGroup;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface SubGroupService {
    ActionResult save(SubGroupDTO subGroupDTO);

    ActionResult update(SubGroupDTO subGroupDTO);

    List<SubGroupDTO> findAllSubGroup();

    SubGroupDTO findOne(Integer id);

    void delete(Integer id);
}
