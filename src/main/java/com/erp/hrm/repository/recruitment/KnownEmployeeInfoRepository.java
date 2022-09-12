package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.KnownEmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KnownEmployeeInfoRepository extends JpaRepository<KnownEmployeeInfo, Long> {
    @Query("SELECT EO FROM KnownEmployeeInfo EO WHERE EO.employeeCode=?1")
    KnownEmployeeInfo getByEmpCode(String pEmployeeCode);

}
