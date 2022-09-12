package com.erp.hrm.service.bonus;

import com.erp.hrm.api.dto.bonus.BonusEffectiveDateDTO;
import com.erp.hrm.api.dto.bonus.BonusPolicyDetailDTO;
import com.erp.hrm.api.dto.bonus.BonusRuleCodeDTO;
import com.erp.hrm.api.dto.bonus.BonusRuleDTO;
import com.erp.hrm.domain.BonusPolicyMaster;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */
public interface BonusRuleService {
    ActionResult save(BonusRuleDTO bonusRuleDTO);

    ActionResult update(BonusRuleDTO bonusRuleDTO);

    List<BonusRuleCodeDTO> getAllBonusRuleCode();

    BonusRuleDTO getBonusRuleByCode(String pBonusRuleCode);

    List<BonusPolicyDetailDTO> getAllBonusPolicyDetailByRuleCode(String pBonusRuleCode);

    List<BonusEffectiveDateDTO> getAllBonusEffectiveDateByRuleCode(String pBonusRuleCode);

    BonusRuleDTO getBonusPolicyDetailInfoById(String pBonusRuleCode,long bonusPaymentPolicyId);
}
