package com.erp.hrm.service.impl.overtime;

import com.erp.hrm.domain.OTSlab;
import com.erp.hrm.repository.overtime.OTSlabRepository;
import com.erp.hrm.service.overtime.OTSlabService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OTSlabServiceImpl implements OTSlabService {

    private OTSlabRepository otSlabRepository;

    public OTSlabServiceImpl(OTSlabRepository otSlabRepository) {
        this.otSlabRepository = otSlabRepository;
    }

    @Override
    public ActionResult save(OTSlab otSlab) {
        return null;
    }

    @Override
    public ActionResult update(OTSlab otSlab) {
        return null;
    }

    @Override
    public List<OTSlab> getAllOTSlab() {
        return null;
    }

    @Override
    public OTSlab findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
