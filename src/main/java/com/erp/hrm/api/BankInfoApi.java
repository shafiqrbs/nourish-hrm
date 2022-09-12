package com.erp.hrm.api;

import com.erp.hrm.domain.Bank;
import com.erp.hrm.domain.Designation;
import com.erp.hrm.service.BankInfoService;
import com.erp.hrm.service.DesignationService;
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
@RequestMapping("/api/v1/bankInfo")
public class BankInfoApi {
    private BankInfoService bankInfoService;
    public BankInfoApi(BankInfoService bankInfoService){
        this.bankInfoService = bankInfoService;
    }

    @RequestMapping(value = "/getAllBankInfo", method = RequestMethod.GET)
    public List<Bank> findAllBankInfo(){
        return bankInfoService.findAllBank();
    }
}