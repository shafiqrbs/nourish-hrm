package com.erp.hrm.service.impl;

import com.erp.hrm.domain.InsuranceInfo;
import com.erp.hrm.repository.InsuranceInfoRepository;
import com.erp.hrm.service.InsuranceInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class InsuranceInfoServiceImpl implements InsuranceInfoService {
    private InsuranceInfoRepository insuranceInfoRepository;
    public InsuranceInfoServiceImpl(InsuranceInfoRepository insuranceInfoRepository){
        this.insuranceInfoRepository = insuranceInfoRepository;
    }

    @Override
    public InsuranceInfo save(InsuranceInfo insuranceInfo) {
        return insuranceInfoRepository.save(insuranceInfo);
    }

    @Override
    public InsuranceInfo update(InsuranceInfo insuranceInfo) {
        return insuranceInfoRepository.save(insuranceInfo);
    }

    @Override
    public List<InsuranceInfo> findAllInsuranceInfo() {
        return insuranceInfoRepository.findAllInsuranceInfo();
    }

    @Override
    public List<InsuranceInfo> findAll() {
        return insuranceInfoRepository.findAll();
    }

    @Override
    public InsuranceInfo findOne(Long id) {
        return insuranceInfoRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
//        insuranceInfoRepository.delete(id);
    	insuranceInfoRepository.deleteById(id);
    }
}
