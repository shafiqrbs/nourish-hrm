package com.erp.hrm.service;

import com.erp.hrm.domain.Designation;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface DesignationService {
    ActionResult save(Designation designation);

    ActionResult update(Designation designation);

    List<Designation> findAllDesignation();

    Designation findOne(Long id);

    void delete(Long id);
}
