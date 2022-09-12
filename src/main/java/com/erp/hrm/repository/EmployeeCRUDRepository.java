package com.erp.hrm.repository;

import com.erp.hrm.domain.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeCRUDRepository extends JpaRepository<EmployeeInfo, Long> {
}
