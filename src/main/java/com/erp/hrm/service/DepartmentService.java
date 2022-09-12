package com.erp.hrm.service;

import com.erp.hrm.domain.Department;
import com.erp.hrm.util.ActionResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface DepartmentService {
    ActionResult save(Department department);

    ActionResult update(Department department);

    List<Department> findAllDepartment();

    Department findOne(Long id);

    void delete(Long id);
}
