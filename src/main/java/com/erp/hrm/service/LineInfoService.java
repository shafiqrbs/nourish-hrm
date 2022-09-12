package com.erp.hrm.service;

import com.erp.hrm.domain.LineInfo;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface LineInfoService {
    LineInfo save(LineInfo lineInfo);

    LineInfo update(LineInfo lineInfo);

    List<LineInfo> findAllLineInfo();

    List<LineInfo> findAll();

    LineInfo findOne(Long id);

    void delete(Long id);
}
