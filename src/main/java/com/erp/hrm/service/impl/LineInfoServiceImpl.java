package com.erp.hrm.service.impl;

import com.erp.hrm.domain.LineInfo;
import com.erp.hrm.repository.LineInfoRepository;
import com.erp.hrm.service.LineInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class LineInfoServiceImpl implements LineInfoService {
    private LineInfoRepository lineInfoRepository;
    public LineInfoServiceImpl(LineInfoRepository lineInfoRepository){
        this.lineInfoRepository = lineInfoRepository;
    }

    @Override
    public LineInfo save(LineInfo lineInfo) {
        return lineInfoRepository.save(lineInfo);
    }

    @Override
    public LineInfo update(LineInfo lineInfo) {
        return lineInfoRepository.save(lineInfo);
    }

    @Override
    public List<LineInfo> findAllLineInfo() {
        return lineInfoRepository.findAllLineInfo();
    }

    @Override
    public List<LineInfo> findAll() {
        return lineInfoRepository.findAll();
    }

    @Override
    public LineInfo findOne(Long id) {
        return lineInfoRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        lineInfoRepository.deleteById(id);//.delete(id);
    }
}
