package com.erp.hrm.service;

import com.erp.hrm.domain.Position;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface PositionService {
    ActionResult save(Position position);

    ActionResult update(Position position);

    List<Position> findAllPosition();

    Position findOne(Long id);

    void delete(Long id);
}
