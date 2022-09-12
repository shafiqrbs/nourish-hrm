package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.SMSSettingsDTO;
import com.erp.hrm.domain.SMSSettings;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface SMSSettingsService {
    ActionResult save(SMSSettings smsSettings);

    ActionResult update(SMSSettings smsSettings);

    List<SMSSettingsDTO> findAllSMSSettings();

    SMSSettingsDTO findOne(Integer id);

    void delete(Integer id);
}
