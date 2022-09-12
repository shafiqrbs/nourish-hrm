package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.LineDTO;
import com.erp.hrm.domain.Line;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface LineService {
    ActionResult save(LineDTO lineDTO);

    ActionResult update(LineDTO lineDTO);

    List<LineDTO> findAllLine();

    LineDTO findOne(Integer id);

    void delete(Integer id);
}
