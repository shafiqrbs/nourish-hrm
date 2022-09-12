package com.erp.hrm.service;

import com.erp.hrm.domain.StaffCategory;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface StaffCategoryService {
    ActionResult save(StaffCategory staffCategory);

    ActionResult update(StaffCategory staffCategory);

    List<StaffCategory> findAllStaffCategory();

    StaffCategory findOne(Long id);

    void delete(Long id);
}
