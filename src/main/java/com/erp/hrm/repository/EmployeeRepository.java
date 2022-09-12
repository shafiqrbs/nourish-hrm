package com.erp.hrm.repository;

import com.erp.hrm.domain.Department;
import com.erp.hrm.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
    @Query("SELECT e FROM Employee e")
    List<Employee> findAllEmployee();

}
