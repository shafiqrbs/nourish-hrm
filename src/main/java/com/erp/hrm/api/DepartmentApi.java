package com.erp.hrm.api;

import com.erp.hrm.domain.Department;
import com.erp.hrm.service.DepartmentService;
import com.erp.hrm.util.ActionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentApi {
    private DepartmentService departmentService;
    public DepartmentApi(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Department findOne(Long id){
        return departmentService.findOne(id);
    }

    @RequestMapping(value = "/getAllDepartment", method = RequestMethod.GET)
    public List<Department> findAllDepartment(){
        return departmentService.findAllDepartment();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody Department department){
        return departmentService.save(department);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody Department department){
        return departmentService.update(department);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        departmentService.delete(id);
    }
}