package com.erp.hrm.service;
import com.erp.hrm.domain.Country;
import com.erp.hrm.domain.Nationality;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface NationalityService {
    List<Nationality> findAll();
}
