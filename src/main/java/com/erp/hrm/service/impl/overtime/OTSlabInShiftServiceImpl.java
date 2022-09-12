package com.erp.hrm.service.impl.overtime;

import com.erp.hrm.domain.OTSlabInShift;
import com.erp.hrm.repository.overtime.OTSlabInShiftRepository;
import com.erp.hrm.service.overtime.OTSlabInShiftService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OTSlabInShiftServiceImpl implements OTSlabInShiftService {

    private OTSlabInShiftRepository otSlabInShiftRepository;

    public OTSlabInShiftServiceImpl(OTSlabInShiftRepository otSlabInShiftRepository) {
        this.otSlabInShiftRepository = otSlabInShiftRepository;
    }

    @Override
    public ActionResult save(OTSlabInShift otSlabInShift) {
        return null;
    }

    @Override
    public ActionResult update(OTSlabInShift otSlabInShift) {
        return null;
    }

    @Override
    public List<OTSlabInShift> getAllOTSlabInShift() {
        return null;
    }

    @Override
    public OTSlabInShift findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
