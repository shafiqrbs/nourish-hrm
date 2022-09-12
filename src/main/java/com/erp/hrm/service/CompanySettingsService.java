package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.CompanySettingsDTO;
import com.erp.hrm.domain.CompanySettings;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface CompanySettingsService {
    ActionResult save(CompanySettings companySettings);

    ActionResult update(CompanySettings companySettings);

    List<CompanySettingsDTO> findAllCompanySettings();

    CompanySettingsDTO findOne(Integer id);

    ActionResult RecordStatusUpdateById(boolean isActive,Integer id);

    ActionResult RecordIsDeleteStatusUpdateById(Integer id);

    void delete(Integer id);

}
