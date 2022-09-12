package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeGeneralInfoRepository extends JpaRepository<EmployeeInfo, String> {
}
