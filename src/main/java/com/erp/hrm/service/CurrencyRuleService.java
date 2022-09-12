package com.erp.hrm.service;

import com.erp.hrm.domain.CurrencyRule;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface CurrencyRuleService {
    CurrencyRule save(CurrencyRule currencyRule);

    CurrencyRule update(CurrencyRule currencyRule);

    List<CurrencyRule> findAllCurrencyRule();

    List<CurrencyRule> findAll();

    CurrencyRule findOne(Long id);

    void delete(Long id);
}
