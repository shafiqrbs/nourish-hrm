package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Department;
import com.erp.hrm.repository.DepartmentRepository;
import com.erp.hrm.service.DepartmentService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ActionResult save(Department department) {
        ActionResult actionResult = new ActionResult();

        try{
            departmentRepository.save(department);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Department saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(Department department) {
        ActionResult actionResult = new ActionResult();

        try{
            departmentRepository.save(department);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Department updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAllDepartment();
    }

    @Override
    public Department findOne(Long id) {
        return departmentRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
