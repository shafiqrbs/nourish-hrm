package com.erp.hrm.service.overtime;

import com.erp.hrm.domain.OTSlab;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */
public interface OTSlabService {
    ActionResult save(OTSlab otSlab);

    ActionResult update(OTSlab otSlab);

    List<OTSlab> getAllOTSlab();

    OTSlab findOne(Long id);

    void delete(Long id);
}
