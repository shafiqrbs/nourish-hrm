package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.SubSectionDTO;
import com.erp.hrm.domain.SubSection;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface SubSectionService {
    ActionResult save(SubSectionDTO subSectionDTO);

    ActionResult update(SubSectionDTO subSectionDTO);

    List<SubSectionDTO> getAllSubSection();

    SubSectionDTO findOne(Integer id);

    void delete(Integer id);
}
