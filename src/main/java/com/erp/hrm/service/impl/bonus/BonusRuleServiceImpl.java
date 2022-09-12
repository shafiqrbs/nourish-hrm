package com.erp.hrm.service.impl.bonus;

import com.erp.hrm.api.dto.bonus.BonusEffectiveDateDTO;
import com.erp.hrm.api.dto.bonus.BonusPolicyDetailDTO;
import com.erp.hrm.api.dto.bonus.BonusRuleCodeDTO;
import com.erp.hrm.api.dto.bonus.BonusRuleDTO;
import com.erp.hrm.domain.BonusEffectiveDate;
import com.erp.hrm.domain.BonusPolicyDetail;
import com.erp.hrm.domain.BonusPolicyMaster;
import com.erp.hrm.repository.bonus.BonusEffectiveDateRepository;
import com.erp.hrm.repository.bonus.BonusPolicyDetailRepository;
import com.erp.hrm.repository.bonus.BonusPolicyMasterRepository;
import com.erp.hrm.service.bonus.BonusRuleService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BonusRuleServiceImpl implements BonusRuleService {

    private BonusPolicyMasterRepository bonusPolicyMasterRepository;
    private BonusPolicyDetailRepository bonusPolicyDetailRepository;
    private BonusEffectiveDateRepository bonusEffectiveDateRepository;

    public BonusRuleServiceImpl(BonusPolicyMasterRepository bonusPolicyMasterRepository ,BonusPolicyDetailRepository bonusPolicyDetailRepository,
                                BonusEffectiveDateRepository bonusEffectiveDateRepository) {
        this.bonusPolicyMasterRepository = bonusPolicyMasterRepository;
        this.bonusPolicyDetailRepository = bonusPolicyDetailRepository;
        this.bonusEffectiveDateRepository = bonusEffectiveDateRepository;
    }

    @Override
    public ActionResult save(BonusRuleDTO bonusRuleDTO) {
        ActionResult actionResult = new ActionResult();
        try {
            BonusPolicyMaster bonusPolicyMaster = new BonusPolicyMaster();
            bonusPolicyMaster.setBonusCode(bonusRuleDTO.getBonusCode());
            bonusPolicyMaster.setDescription(bonusRuleDTO.getDescription());

            try{
                bonusPolicyMaster.setActive(bonusRuleDTO.isActive());
            }
            catch (Exception e){
                bonusPolicyMaster.setActive(false);
            }
            bonusPolicyMaster.setAvailFrom(bonusRuleDTO.getAvailFrom());
            try{
                bonusPolicyMaster.setCalculationAfter(bonusRuleDTO.getCalculationAfter());
            }
            catch (Exception e){
                bonusPolicyMaster.setCalculationAfter(0);
            }
            try{
                bonusPolicyMaster.setProcessApproved(bonusRuleDTO.isProcessApproved());
            }
            catch (Exception e){
                bonusPolicyMaster.setProcessApproved(false);
            }

            bonusPolicyMasterRepository.save(bonusPolicyMaster);

            BonusEffectiveDate bonusEffectiveDate = new BonusEffectiveDate();
            bonusEffectiveDate.setBonusCode(bonusRuleDTO.getBonusCode());
            try {
                bonusEffectiveDate.setEffectiveDate(bonusRuleDTO.getEffectiveDate());
            }
            catch (Exception ex){
                bonusEffectiveDate.setEffectiveDate(null);
            }
            bonusEffectiveDate.setApproved(true);
            bonusEffectiveDateRepository.save(bonusEffectiveDate);

            BonusPolicyDetail bonusPolicyDetail = new BonusPolicyDetail();
            bonusPolicyDetail.setBonusCode(bonusRuleDTO.getBonusCode());
            bonusPolicyDetail.setBonusCriteria("Staff Category");
            bonusPolicyDetail.setBonusCriteriaValue(bonusRuleDTO.getStaffCategory());
            try{
                bonusPolicyDetail.setMinServiceLen(bonusRuleDTO.getMinServiceLen());
            }
            catch (Exception e){
                bonusPolicyDetail.setMinServiceLen(0);
            }
            try{
                bonusPolicyDetail.setMaxServiceLen(bonusRuleDTO.getMaxServiceLen());
            }
            catch (Exception e){
                bonusPolicyDetail.setMaxServiceLen(0);
            }
            try{
                bonusPolicyDetail.setCalOnPaidSalaryForProdEmployee(bonusRuleDTO.getCalOnPaidSalaryForProdEmployee());
            }
            catch (Exception e){
                bonusPolicyDetail.setCalOnPaidSalaryForProdEmployee(0);
            }
            try{
                bonusPolicyDetail.setNoOfMonthForAvrSalCal(bonusRuleDTO.getNoOfMonthForAvrSalCal());
            }
            catch (Exception e){
                bonusPolicyDetail.setNoOfMonthForAvrSalCal(0);
            }

            bonusPolicyDetail.setSalaryHeadID(bonusRuleDTO.getSalaryHeadID());
            try{
                bonusPolicyDetail.setAmount(bonusRuleDTO.getAmount());
            }
            catch (Exception e){
                bonusPolicyDetail.setAmount(0);
            }

            bonusPolicyDetail.setsCriteria(bonusRuleDTO.getsCriteria());
            if(bonusRuleDTO.getsCriteria().contains("F"))
                bonusPolicyDetail.setFixedCalculation(true);
            else
                bonusPolicyDetail.setFixedCalculation(false);

            bonusPolicyDetailRepository.save(bonusPolicyDetail);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Bonus Policy saved successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(BonusRuleDTO bonusRuleDTO) {
        ActionResult actionResult = new ActionResult();
        try {
            BonusPolicyMaster bonusPolicyMaster = bonusPolicyMasterRepository.getBonusPolicyByBonusCode(bonusRuleDTO.getBonusCode());
            bonusPolicyMaster.setBonusCode(bonusRuleDTO.getBonusCode());
            bonusPolicyMaster.setDescription(bonusRuleDTO.getDescription());

            try{
                bonusPolicyMaster.setActive(bonusRuleDTO.isActive());
            }
            catch (Exception e){
                bonusPolicyMaster.setActive(false);
            }
            bonusPolicyMaster.setAvailFrom(bonusRuleDTO.getAvailFrom());
            try{
                bonusPolicyMaster.setCalculationAfter(bonusRuleDTO.getCalculationAfter());
            }
            catch (Exception e){
                bonusPolicyMaster.setCalculationAfter(0);
            }
            try{
                bonusPolicyMaster.setProcessApproved(bonusRuleDTO.isProcessApproved());
            }
            catch (Exception e){
                bonusPolicyMaster.setProcessApproved(false);
            }

            bonusPolicyMasterRepository.save(bonusPolicyMaster);

            BonusEffectiveDate bonusEffectiveDate = bonusEffectiveDateRepository.getBonusEffectiveDatesByRuleCode(bonusRuleDTO.getBonusCode());
            bonusEffectiveDate.setEffectiveDate(bonusRuleDTO.getEffectiveDate());
            bonusEffectiveDateRepository.save(bonusEffectiveDate);

//            BonusPolicyDetail bonusPolicyDetail = bonusPolicyDetailRepository.findOne(bonusRuleDTO.getBonusPaymentPolicyId());
            
            BonusPolicyDetail bonusPolicyDetail = bonusPolicyDetailRepository.getOne(bonusRuleDTO.getBonusPaymentPolicyId());
            bonusPolicyDetail.setBonusCode(bonusRuleDTO.getBonusCode());
            bonusPolicyDetail.setBonusCriteria("Staff Category");
            bonusPolicyDetail.setBonusCriteriaValue(bonusRuleDTO.getStaffCategory());
            try{
                bonusPolicyDetail.setMinServiceLen(bonusRuleDTO.getMinServiceLen());
            }
            catch (Exception e){
                bonusPolicyDetail.setMinServiceLen(0);
            }
            try{
                bonusPolicyDetail.setMaxServiceLen(bonusRuleDTO.getMaxServiceLen());
            }
            catch (Exception e){
                bonusPolicyDetail.setMaxServiceLen(0);
            }
            try{
                bonusPolicyDetail.setCalOnPaidSalaryForProdEmployee(bonusRuleDTO.getCalOnPaidSalaryForProdEmployee());
            }
            catch (Exception e){
                bonusPolicyDetail.setCalOnPaidSalaryForProdEmployee(0);
            }
            try{
                bonusPolicyDetail.setNoOfMonthForAvrSalCal(bonusRuleDTO.getNoOfMonthForAvrSalCal());
            }
            catch (Exception e){
                bonusPolicyDetail.setNoOfMonthForAvrSalCal(0);
            }

            bonusPolicyDetail.setSalaryHeadID(bonusRuleDTO.getSalaryHeadID());
            try{
                bonusPolicyDetail.setAmount(bonusRuleDTO.getAmount());
            }
            catch (Exception e){
                bonusPolicyDetail.setAmount(0);
            }

            bonusPolicyDetail.setsCriteria(bonusRuleDTO.getsCriteria());
            if(bonusRuleDTO.getsCriteria().contains("F"))
                bonusPolicyDetail.setFixedCalculation(true);
            else
                bonusPolicyDetail.setFixedCalculation(false);

            bonusPolicyDetailRepository.save(bonusPolicyDetail);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Bonus Policy updated successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<BonusRuleCodeDTO> getAllBonusRuleCode() {
        List<BonusRuleCodeDTO> bonusRuleCodeDTOS = new ArrayList<>();
        List<Object[]> bonusPolicyObj = bonusPolicyMasterRepository.getAllBonusRuleCode();
        for (Object data: bonusPolicyObj) {
            BonusRuleCodeDTO bonusRuleCodeDTO = new BonusRuleCodeDTO();
            bonusRuleCodeDTO.setBonusRuleCode((String) data);
            bonusRuleCodeDTOS.add(bonusRuleCodeDTO);
        }
        return bonusRuleCodeDTOS;
    }

    @Override
    public BonusRuleDTO getBonusRuleByCode(String pBonusRuleCode) {
        BonusRuleDTO bonusRuleDTO = new BonusRuleDTO();
        BonusPolicyMaster bonusPolicyMaster = bonusPolicyMasterRepository.getBonusPolicyByBonusCode(pBonusRuleCode);
        bonusRuleDTO.setBonusCode(bonusPolicyMaster.getBonusCode());
        bonusRuleDTO.setDescription(bonusPolicyMaster.getDescription());

        try {
            bonusRuleDTO.setActive(bonusPolicyMaster.isActive());
        }
        catch (Exception e){
            bonusRuleDTO.setActive(false);
        }

        bonusRuleDTO.setAvailFrom(bonusPolicyMaster.getAvailFrom());

        try {
            bonusRuleDTO.setCalculationAfter(bonusPolicyMaster.getCalculationAfter());
        }
        catch (Exception e){
            bonusRuleDTO.setCalculationAfter(0);
        }

        try {
            bonusRuleDTO.setProcessApproved(bonusPolicyMaster.isProcessApproved());
        }
        catch (Exception e){
            bonusRuleDTO.setProcessApproved(false);
        }

        BonusEffectiveDate bonusEffectiveDate = bonusEffectiveDateRepository.getBonusEffectiveDatesByRuleCode(pBonusRuleCode);
        try {
            bonusRuleDTO.setBonusEffectiveId(bonusEffectiveDate.getId());
        }
        catch (Exception e){
            bonusRuleDTO.setBonusEffectiveId(0);
        }

        try {
            bonusRuleDTO.setEffectiveDate(bonusEffectiveDate.getEffectiveDate());
        }
        catch (Exception e){
            bonusRuleDTO.setEffectiveDate(null);
        }

        return bonusRuleDTO;
    }

    @Override
    public List<BonusPolicyDetailDTO> getAllBonusPolicyDetailByRuleCode(String pBonusRuleCode) {
        List<BonusPolicyDetailDTO> bonusPolicyDetailDTOS = new ArrayList<>();
        List<BonusPolicyDetail> bonusPolicyDetails = bonusPolicyDetailRepository.getAllBonusPolicyDetailByRuleCode(pBonusRuleCode);
        for (BonusPolicyDetail bonusPolicyDetail : bonusPolicyDetails) {
            BonusPolicyDetailDTO bonusPolicyDetailDTO = new BonusPolicyDetailDTO();
            bonusPolicyDetailDTO.setBonusPaymentPolicyId(bonusPolicyDetail.getId());
            bonusPolicyDetailDTO.setBonusCode(bonusPolicyDetail.getBonusCode());
            bonusPolicyDetailDTO.setStaffCategory(bonusPolicyDetail.getBonusCriteriaValue());
            bonusPolicyDetailDTO.setMaxServiceLen(bonusPolicyDetail.getMaxServiceLen());
            bonusPolicyDetailDTO.setMinServiceLen(bonusPolicyDetail.getMinServiceLen());


            String remarks = "";
            if(bonusPolicyDetail.isFixedCalculation())
                remarks = String.valueOf(bonusPolicyDetail.getAmount());
            else {
                remarks = String.valueOf(bonusPolicyDetail.getAmount()) + " % of " + bonusPolicyDetail.getSalaryHeadID();
            }

            bonusPolicyDetailDTO.setRemarks(remarks);
            bonusPolicyDetailDTOS.add(bonusPolicyDetailDTO);
        }
        return bonusPolicyDetailDTOS;
    }

    @Override
    public List<BonusEffectiveDateDTO> getAllBonusEffectiveDateByRuleCode(String pBonusRuleCode) {
        List<BonusEffectiveDateDTO> bonusEffectiveDateDTOS = new ArrayList<>();
        List<BonusEffectiveDate> bonusEffectiveDates = bonusEffectiveDateRepository.getAllBonusEffectiveDatesByRuleCode(pBonusRuleCode);
        for (BonusEffectiveDate bonusEffectiveDate : bonusEffectiveDates) {
            BonusEffectiveDateDTO bonusEffectiveDateDTO = new BonusEffectiveDateDTO();
            bonusEffectiveDateDTO.setBonusCode(bonusEffectiveDate.getBonusCode());
            bonusEffectiveDateDTO.setEffectiveDate(bonusEffectiveDate.getEffectiveDate());
            bonusEffectiveDateDTO.setApproved(bonusEffectiveDate.isApproved());
            bonusEffectiveDateDTO.setApprovedBy(bonusEffectiveDate.getApprovedBy());
            bonusEffectiveDateDTO.setApprovedDate(bonusEffectiveDate.getApprovedDate());
            bonusEffectiveDateDTOS.add(bonusEffectiveDateDTO);
        }
        return bonusEffectiveDateDTOS;
    }

    @Override
    public BonusRuleDTO getBonusPolicyDetailInfoById(String pBonusRuleCode, long bonusPaymentPolicyId) {
        BonusRuleDTO bonusRuleDTO = new BonusRuleDTO();
        BonusPolicyMaster bonusPolicyMaster = bonusPolicyMasterRepository.getBonusPolicyByBonusCode(pBonusRuleCode);
        bonusRuleDTO.setBonusCode(bonusPolicyMaster.getBonusCode());
        bonusRuleDTO.setAvailFrom(bonusPolicyMaster.getAvailFrom());
        bonusRuleDTO.setActive(bonusPolicyMaster.isActive());
        bonusRuleDTO.setCalculationAfter(bonusPolicyMaster.getCalculationAfter());
        bonusRuleDTO.setDescription(bonusPolicyMaster.getDescription());

        BonusEffectiveDate bonusEffectiveDate = bonusEffectiveDateRepository.getBonusEffectiveDatesByRuleCode(pBonusRuleCode);
        try {
            bonusRuleDTO.setBonusEffectiveId(bonusEffectiveDate.getId());
        }
        catch (Exception e){
            bonusRuleDTO.setBonusEffectiveId(0);
        }

        try {
            bonusRuleDTO.setEffectiveDate(bonusEffectiveDate.getEffectiveDate());
        }
        catch (Exception e){
            bonusRuleDTO.setEffectiveDate(null);
        }

//        BonusPolicyDetail bonusPolicyDetail = bonusPolicyDetailRepository.findOne(bonusPaymentPolicyId);
        BonusPolicyDetail bonusPolicyDetail = bonusPolicyDetailRepository.getOne(bonusPaymentPolicyId);
        try {
            bonusRuleDTO.setBonusPaymentPolicyId(bonusPolicyDetail.getId());
        }
        catch (Exception e){
            bonusRuleDTO.setBonusPaymentPolicyId(0);
        }
        bonusRuleDTO.setStaffCategory(bonusPolicyDetail.getBonusCriteriaValue());
        bonusRuleDTO.setMaxServiceLen(bonusPolicyDetail.getMaxServiceLen());
        bonusRuleDTO.setMinServiceLen(bonusPolicyDetail.getMinServiceLen());
        bonusRuleDTO.setFixedCalculation(bonusPolicyDetail.isFixedCalculation());
        bonusRuleDTO.setAmount(bonusPolicyDetail.getAmount());
        bonusRuleDTO.setSalaryHeadID(bonusPolicyDetail.getSalaryHeadID());
        bonusRuleDTO.setsCriteria(bonusPolicyDetail.getsCriteria());
        return bonusRuleDTO;
    }
}
