package com.erp.hrm.service;

import com.erp.hrm.api.dto.SeparationDTO;
import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface SeparationService {
    ActionResult save(SeparationDTO separationDTO);

    ActionResult update(SeparationDTO separationDTO);

    List<SeparationDTO> findAllSeparationByEmployeeCode(String pEmployeeCode);

    SeparationDTO findOne(Long id);

    void delete(Long id);
}
