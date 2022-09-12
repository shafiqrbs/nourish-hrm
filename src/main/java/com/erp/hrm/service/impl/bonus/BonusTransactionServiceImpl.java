package com.erp.hrm.service.impl.bonus;

import com.erp.hrm.domain.BonusTransaction;
import com.erp.hrm.repository.bonus.BonusTransactionRepository;
import com.erp.hrm.service.bonus.BonusTransactionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusTransactionServiceImpl implements BonusTransactionService {

    private BonusTransactionRepository bonusTransactionRepository;

    public BonusTransactionServiceImpl(BonusTransactionRepository bonusTransactionRepository) {
        this.bonusTransactionRepository = bonusTransactionRepository;
    }

    @Override
    public ActionResult save(BonusTransaction bonusTransaction) {
        return null;
    }

    @Override
    public ActionResult update(BonusTransaction bonusTransaction) {
        return null;
    }

    @Override
    public List<BonusTransaction> getAllBonusTransaction() {
        return null;
    }

    @Override
    public BonusTransaction findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
