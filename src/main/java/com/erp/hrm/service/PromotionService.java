package com.erp.hrm.service;

import com.erp.hrm.api.dto.PromotionDTO;
import com.erp.hrm.domain.Position;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface PromotionService {
    List<Position> findAllPosition();

    ActionResult save(PromotionDTO promotionDTO);

    ActionResult update(PromotionDTO promotionDTO);

    List<PromotionDTO> findAllPromotionByEmployeeCode(String pEmployeeCode);

    PromotionDTO findOne(Long id);

    void delete(Long id);
}
