package com.erp.hrm.service;

import com.erp.hrm.domain.Division;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface DivisionService {
    ActionResult save(Division division);

    ActionResult update(Division division);

    List<Division> findAllDivision();

    Division findOne(Long id);

    void delete(Long id);
}
