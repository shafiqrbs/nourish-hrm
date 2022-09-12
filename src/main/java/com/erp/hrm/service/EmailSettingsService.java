package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.EmailSettingsDTO;
import com.erp.hrm.domain.EmailSettings;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface EmailSettingsService {
    ActionResult save(EmailSettings emailSettings);

    ActionResult update(EmailSettings emailSettings);

    List<EmailSettingsDTO> findAllEmailSettings();

    EmailSettingsDTO findOne(Integer id);

    void delete(Integer id);
}
