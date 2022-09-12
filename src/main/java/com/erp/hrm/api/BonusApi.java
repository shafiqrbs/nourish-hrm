package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.CountryDTO;
import com.erp.hrm.api.dto.bonus.BonusEffectiveDateDTO;
import com.erp.hrm.api.dto.bonus.BonusPolicyDetailDTO;
import com.erp.hrm.api.dto.bonus.BonusRuleCodeDTO;
import com.erp.hrm.api.dto.bonus.BonusRuleDTO;
import com.erp.hrm.service.CountryService;
import com.erp.hrm.service.bonus.BonusRuleService;
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
@RequestMapping("/api/v1/bonus")
public class BonusApi {
    private BonusRuleService bonusRuleService;
    public BonusApi(BonusRuleService bonusRuleService){
        this.bonusRuleService = bonusRuleService;
    }

    @RequestMapping(value = "/bonusRule/get", method = RequestMethod.GET)
    public List<BonusRuleCodeDTO> getAllBonusRuleCode(){
        return bonusRuleService.getAllBonusRuleCode();
    }

    @RequestMapping(value = "/bonusRule/getByCode", method = RequestMethod.GET)
    public BonusRuleDTO getBonusRuleByCode(String pBonusRuleCode){
        return bonusRuleService.getBonusRuleByCode(pBonusRuleCode);
    }

    @RequestMapping(value = "/bonusRule/getPolicyDetailsByCode", method = RequestMethod.GET)
    public List<BonusPolicyDetailDTO> getAllBonusPolicyDetailByRuleCode(String pBonusRuleCode){
        return bonusRuleService.getAllBonusPolicyDetailByRuleCode(pBonusRuleCode);
    }

    @RequestMapping(value = "/bonusRule/getBonusEffectiveDateByCode", method = RequestMethod.GET)
    public List<BonusEffectiveDateDTO> getAllBonusEffectiveDateByRuleCode(String pBonusRuleCode){
        return bonusRuleService.getAllBonusEffectiveDateByRuleCode(pBonusRuleCode);
    }

    @RequestMapping(value = "/bonusRule/getBonusPolicyDetailByCode", method = RequestMethod.GET)
    public BonusRuleDTO getBonusPolicyDetailInfoById(String pBonusRuleCode, long pBonusPaymentPolicyId){
        return bonusRuleService.getBonusPolicyDetailInfoById(pBonusRuleCode,pBonusPaymentPolicyId);
    }

    @RequestMapping(value = "/bonusRule/save", method = RequestMethod.POST)
    public ActionResult saveBonusRule(@RequestBody BonusRuleDTO bonusRuleDTO){
        return bonusRuleService.save(bonusRuleDTO);
    }

    @RequestMapping(value = "/bonusRule/update", method = RequestMethod.PUT)
    public ActionResult updateBonusRule(@RequestBody BonusRuleDTO bonusRuleDTO){
        return bonusRuleService.update(bonusRuleDTO);
    }
}