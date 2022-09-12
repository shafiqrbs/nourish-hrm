package com.erp.hrm.service.overtime;

import com.erp.hrm.domain.OTSlabInShift;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */
public interface OTSlabInShiftService {
    ActionResult save(OTSlabInShift otSlabInShift);

    ActionResult update(OTSlabInShift otSlabInShift);

    List<OTSlabInShift> getAllOTSlabInShift();

    OTSlabInShift findOne(Long id);

    void delete(Long id);
}
