package com.erp.hrm.api;

import com.erp.hrm.api.dto.PromotionDTO;
import com.erp.hrm.domain.Position;
import com.erp.hrm.service.PromotionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/promotion")
public class PromotionApi {
    private PromotionService promotionService;
    public PromotionApi(PromotionService promotionService){
        this.promotionService = promotionService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public PromotionDTO findOne(Long id){
        return promotionService.findOne(id);
    }

    @RequestMapping(value = "/getAllPosition", method = RequestMethod.GET)
    public List<Position> findAllPosition(){
        return promotionService.findAllPosition();
}

    @RequestMapping(value = "/findAllPromotionByEmployeeCode", method = RequestMethod.GET)
    public List<PromotionDTO> findAllPromotionByEmployeeCode(String pEmployeeCode){
        return promotionService.findAllPromotionByEmployeeCode(pEmployeeCode);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody PromotionDTO promotionDTO){
        return promotionService.save(promotionDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody PromotionDTO promotionDTO){
        return promotionService.update(promotionDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        promotionService.delete(id);
    }
}