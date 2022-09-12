package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Country;
import com.erp.hrm.domain.Nationality;
import com.erp.hrm.repository.NationalityRepository;
import com.erp.hrm.service.NationalityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class NationalityServiceImpl implements NationalityService {
    private NationalityRepository nationalityRepository;
    public NationalityServiceImpl(NationalityRepository nationalityRepository){
        this.nationalityRepository = nationalityRepository;
    }

    @Override
    public List<Nationality> findAll() {
        return nationalityRepository.findAll();
    }
}
