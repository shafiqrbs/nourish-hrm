package com.erp.hrm.service;

import com.erp.hrm.api.dto.SkillDTO;
import com.erp.hrm.domain.Skills;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface SkillsService {
    ActionResult save(SkillDTO skillDTO);

    ActionResult update(SkillDTO skillDTO);

    List<SkillDTO> findAllSkillsByEmployeeCode(String pEmployeeCode);

    SkillDTO findOne(Long id);

    void delete(Long id);
}
