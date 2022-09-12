package com.erp.hrm.service;

import com.erp.hrm.api.dto.HeadTypeDTO;
import com.erp.hrm.domain.HeadType;
import com.erp.hrm.domain.SalaryHead;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface SalaryHeadService {
    ActionResult save(SalaryHead salaryHead);

    ActionResult update(SalaryHead salaryHead);

    List<SalaryHead> getAllSalaryHead();

    List<HeadType> getAllHeadType();

    SalaryHead findOne(Long id);

    void delete(Long id);
}
