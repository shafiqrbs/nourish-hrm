package com.erp.hrm.service;

import com.erp.hrm.domain.SectionInfo;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface SectionInfoService {
    ActionResult save(SectionInfo sectionInfo);

    ActionResult update(SectionInfo sectionInfo);

    List<SectionInfo> findAllSection();

    SectionInfo findOne(Long id);

    void delete(Long id);
}
