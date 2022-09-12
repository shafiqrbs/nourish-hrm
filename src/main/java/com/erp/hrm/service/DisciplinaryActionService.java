package com.erp.hrm.service;

import com.erp.hrm.api.dto.DisciplinaryActionDTO;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface DisciplinaryActionService {
    ActionResult save(DisciplinaryActionDTO disciplinaryActionDTO);

    ActionResult update(DisciplinaryActionDTO disciplinaryActionDTO);

    List<DisciplinaryActionDTO> findAllDisciplinaryActionByEmployeeCode(String pEmployeeCode);

    DisciplinaryActionDTO findOne(Long id);

    void delete(Long id);
}
