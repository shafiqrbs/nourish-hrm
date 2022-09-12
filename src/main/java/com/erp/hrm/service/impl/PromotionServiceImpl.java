package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.PromotionDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.Position;
import com.erp.hrm.domain.Promotion;
import com.erp.hrm.repository.PositionRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.employee.PromotionRepository;
import com.erp.hrm.service.PromotionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class PromotionServiceImpl implements PromotionService {
    private PromotionRepository promotionRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    private PositionRepository positionRepository;

    public PromotionServiceImpl(PromotionRepository promotionRepository, EmployeeInfoRepository employeeInfoRepository, PositionRepository positionRepository) {
        this.promotionRepository = promotionRepository;
        this.employeeInfoRepository = employeeInfoRepository;
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }
    @Override
    public ActionResult save(PromotionDTO promotionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(promotionDTO.getEmployeeCode());
            Promotion promotionObj = new Promotion();
            promotionObj.setEmployeeInfo(employeeInfo);
            promotionObj.setPromotionType(promotionDTO.getPromotionType());
            promotionObj.setEffectiveDate(promotionDTO.getEffectiveDate());
            promotionObj.setDateApproved(promotionDTO.getDateApproved());
            promotionObj.setApproved(promotionDTO.getApproved());
            promotionObj.setEffected(promotionDTO.isEffected());
            promotionObj.setPostStatus(promotionDTO.getPostStatus());
            promotionObj.setPromotedPosition(promotionDTO.getPromotedPosition());
            promotionObj.setPreStatus(promotionDTO.getPreStatus());
            promotionObj.setPromotionCriteria(promotionDTO.getPromotionCriteria());
            promotionObj.setServiceLen(promotionDTO.getServiceLen());
            promotionObj.setNextPromotionDate(promotionDTO.getNextPromotionDate());
            promotionObj.setPromotionSource(promotionDTO.getPromotionSource());
            promotionObj.setPrePosition(promotionDTO.getPrePosition());
            promotionRepository.save(promotionObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Promotion saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(PromotionDTO promotionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(promotionDTO.getEmployeeCode());
            Promotion promotionObj = new Promotion();
            promotionObj.setId(promotionDTO.getPromotionId());
            promotionObj.setEmployeeInfo(employeeInfo);
            promotionObj.setPromotionType(promotionDTO.getPromotionType());
            promotionObj.setEffectiveDate(promotionDTO.getEffectiveDate());
            promotionObj.setDateApproved(promotionDTO.getDateApproved());
            promotionObj.setApproved(promotionDTO.getApproved());
            promotionObj.setEffected(promotionDTO.isEffected());
            promotionObj.setPostStatus(promotionDTO.getPostStatus());
            promotionObj.setPromotedPosition(promotionDTO.getPromotedPosition());
            promotionObj.setPreStatus(promotionDTO.getPreStatus());
            promotionObj.setPromotionCriteria(promotionDTO.getPromotionCriteria());
            promotionObj.setServiceLen(promotionDTO.getServiceLen());
            promotionObj.setNextPromotionDate(promotionDTO.getNextPromotionDate());
            promotionObj.setPromotionSource(promotionDTO.getPromotionSource());
            promotionObj.setPrePosition(promotionDTO.getPrePosition());
            promotionRepository.save(promotionObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Promotion updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<PromotionDTO> findAllPromotionByEmployeeCode(String pEmployeeCode) {
        List<Promotion> promotions = promotionRepository.findAllPromotionByEmployeeCode(pEmployeeCode);
        List<PromotionDTO> promotionDTOS = new ArrayList<>();
        for (Promotion promotion:promotions)
        {
            PromotionDTO promotionDTO = new PromotionDTO();
            promotionDTO.setPromotionId(promotion.getId());
            promotionDTO.setEmployeeCode(promotion.getEmployeeInfo().getEmployeeCode());
            promotionDTO.setPromotionType(promotion.getPromotionType());
            promotionDTO.setEffectiveDate(promotion.getEffectiveDate());
            promotionDTO.setDateApproved(promotion.getDateApproved());
            promotionDTO.setApproved(promotion.getApproved());
            promotionDTO.setEffected(promotion.isEffected());
            promotionDTO.setPostStatus(promotion.getPostStatus());
            promotionDTO.setPromotedPosition(promotion.getPromotedPosition());
            promotionDTO.setPreStatus(promotion.getPreStatus());
            promotionDTO.setPromotionCriteria(promotion.getPromotionCriteria());
            promotionDTO.setServiceLen(promotion.getServiceLen());
            promotionDTO.setNextPromotionDate(promotion.getNextPromotionDate());
            promotionDTO.setPromotionSource(promotion.getPromotionSource());
            promotionDTO.setPrePosition(promotion.getPrePosition());
            promotionDTOS.add(promotionDTO);
        }
        return promotionDTOS;
    }

    @Override
    public PromotionDTO findOne(Long id) {
        Promotion promotion = promotionRepository.getOne(id);//.findOne(id);
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setPromotionId(promotion.getId());
        promotionDTO.setEmployeeCode(promotion.getEmployeeInfo().getEmployeeCode());
        promotionDTO.setPromotionType(promotion.getPromotionType());
        promotionDTO.setEffectiveDate(promotion.getEffectiveDate());
        promotionDTO.setDateApproved(promotion.getDateApproved());
        promotionDTO.setApproved(promotion.getApproved());
        promotionDTO.setEffected(promotion.isEffected());
        promotionDTO.setPostStatus(promotion.getPostStatus());
        promotionDTO.setPromotedPosition(promotion.getPromotedPosition());
        promotionDTO.setPreStatus(promotion.getPreStatus());
        promotionDTO.setPromotionCriteria(promotion.getPromotionCriteria());
        promotionDTO.setServiceLen(promotion.getServiceLen());
        promotionDTO.setNextPromotionDate(promotion.getNextPromotionDate());
        promotionDTO.setPromotionSource(promotion.getPromotionSource());
        promotionDTO.setPrePosition(promotion.getPrePosition());
        return promotionDTO;
    }

    @Override
    public void delete(Long id) {
//        promotionRepository.delete(id);
    }
}
