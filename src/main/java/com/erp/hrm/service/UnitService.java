package com.erp.hrm.service;

import com.erp.hrm.domain.Unit;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface UnitService {
    ActionResult save(Unit unit);

    ActionResult update(Unit unit);

    List<Unit> findAllUnit();

    Unit findOne(Long id);

    void delete(Long id);
}
