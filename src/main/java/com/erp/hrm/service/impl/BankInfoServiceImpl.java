package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Bank;
import com.erp.hrm.domain.Designation;
import com.erp.hrm.repository.BankInfoRepository;
import com.erp.hrm.repository.DesignationRepository;
import com.erp.hrm.service.BankInfoService;
import com.erp.hrm.service.DesignationService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class BankInfoServiceImpl implements BankInfoService {
    private BankInfoRepository bankInfoRepository;
    public BankInfoServiceImpl(BankInfoRepository bankInfoRepository){
        this.bankInfoRepository = bankInfoRepository;
    }

    @Override
    public List<Bank> findAllBank() {
        return bankInfoRepository.findAll();
    }
}
