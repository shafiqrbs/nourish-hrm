package com.erp.hrm.api;

import com.erp.hrm.domain.CurrencyRule;
import com.erp.hrm.service.CurrencyRuleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/currencyRules")
public class CurrencyRuleApi {
    private CurrencyRuleService currencyRuleService;
    public CurrencyRuleApi(CurrencyRuleService currencyRuleService){
        this.currencyRuleService = currencyRuleService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public CurrencyRule findOne(Long id){
        return currencyRuleService.findOne(id);
    }

    @RequestMapping(value = "/findAllCurrencyRule", method = RequestMethod.GET)
    public List<CurrencyRule> findAllCurrencyRule(){
        return currencyRuleService.findAllCurrencyRule();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CurrencyRule> findAll(){
        return currencyRuleService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CurrencyRule save(@RequestBody CurrencyRule currencyRule){
        return currencyRuleService.save(currencyRule);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public CurrencyRule update(@RequestBody CurrencyRule currencyRule){
        return currencyRuleService.update(currencyRule);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Long id){
        currencyRuleService.delete(id);
    }
}