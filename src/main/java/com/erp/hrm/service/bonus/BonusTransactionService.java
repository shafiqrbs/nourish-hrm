package com.erp.hrm.service.bonus;

import com.erp.hrm.domain.BonusTransaction;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */
public interface BonusTransactionService {
    ActionResult save(BonusTransaction bonusTransaction);

    ActionResult update(BonusTransaction bonusTransaction);

    List<BonusTransaction> getAllBonusTransaction();

    BonusTransaction findOne(Long id);

    void delete(Long id);
}
