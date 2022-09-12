package com.erp.hrm.service;

import com.erp.hrm.domain.InsuranceInfo;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface InsuranceInfoService {
    InsuranceInfo save(InsuranceInfo insuranceInfo);

    InsuranceInfo update(InsuranceInfo insuranceInfo);

    List<InsuranceInfo> findAllInsuranceInfo();

    List<InsuranceInfo> findAll();

    InsuranceInfo findOne(Long id);

    void delete(Long id);
}
