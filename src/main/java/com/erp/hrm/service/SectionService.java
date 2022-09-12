package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.SectionDTO;
import com.erp.hrm.domain.Section;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface SectionService {
    ActionResult save(SectionDTO sectionDTO);

    ActionResult update(SectionDTO sectionDTO);

    List<SectionDTO> findAllSection();

    SectionDTO findOne(Integer id);

    void delete(Integer id);
}
