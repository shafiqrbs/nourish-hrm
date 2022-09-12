package com.erp.hrm.service.impl;

import com.erp.hrm.domain.CurrencyRule;
import com.erp.hrm.repository.CurrencyRuleRepository;
import com.erp.hrm.service.CurrencyRuleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class CurrencyRuleServiceImpl implements CurrencyRuleService {
    private CurrencyRuleRepository currencyRuleRepository;
    public CurrencyRuleServiceImpl(CurrencyRuleRepository currencyRuleRepository){
        this.currencyRuleRepository = currencyRuleRepository;
    }

    @Override
    public CurrencyRule save(CurrencyRule currencyRule) {
        return currencyRuleRepository.save(currencyRule);
    }

    @Override
    public CurrencyRule update(CurrencyRule currencyRule) {
        return currencyRuleRepository.save(currencyRule);
    }

    @Override
    public List<CurrencyRule> findAllCurrencyRule() {
        return currencyRuleRepository.findAllCurrencyRule();
    }

    @Override
    public List<CurrencyRule> findAll() {
        return currencyRuleRepository.findAll();
    }

    @Override
    public CurrencyRule findOne(Long id) {
        return currencyRuleRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        currencyRuleRepository.deleteById(id);
    }
}
