package com.erp.hrm.api;

import com.erp.hrm.domain.StaffCategory;
import com.erp.hrm.service.StaffCategoryService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/staffCategories")
public class StaffCategoryApi {
    private StaffCategoryService staffCategoryService;
    public StaffCategoryApi(StaffCategoryService staffCategoryService){
        this.staffCategoryService = staffCategoryService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public StaffCategory findOne(Long id){
        return staffCategoryService.findOne(id);
    }

    @RequestMapping(value = "/getAllStaffCategory", method = RequestMethod.GET)
    public List<StaffCategory> findAllStaffCategory(){
        return staffCategoryService.findAllStaffCategory();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody StaffCategory staffCategory){
        return staffCategoryService.save(staffCategory);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody StaffCategory staffCategory){
        return staffCategoryService.update(staffCategory);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        staffCategoryService.delete(id);
    }
}