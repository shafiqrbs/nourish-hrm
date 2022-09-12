package com.erp.hrm.service.impl;

import com.erp.hrm.domain.StaffCategory;
import com.erp.hrm.repository.StaffCategoryRepository;
import com.erp.hrm.service.StaffCategoryService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class StaffCategoryServiceImpl implements StaffCategoryService {
    private StaffCategoryRepository staffCategoryRepository;
    public StaffCategoryServiceImpl(StaffCategoryRepository staffCategoryRepository){
        this.staffCategoryRepository = staffCategoryRepository;
    }

    @Override
    public ActionResult save(StaffCategory staffCategory) {
        ActionResult actionResult = new ActionResult();

        try{
            staffCategoryRepository.save(staffCategory);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Staff category saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(StaffCategory staffCategory) {
        ActionResult actionResult = new ActionResult();

        try{
            staffCategoryRepository.save(staffCategory);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Staff category updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<StaffCategory> findAllStaffCategory() {
        return staffCategoryRepository.findAllStaffCategory();
    }

    @Override
    public StaffCategory findOne(Long id) {
        return staffCategoryRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        staffCategoryRepository.deleteById(id);//.delete(id);
    }
}
