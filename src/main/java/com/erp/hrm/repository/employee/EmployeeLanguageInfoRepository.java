package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLanguageInfoRepository extends JpaRepository<Language, Long> {
    @Query("SELECT EO FROM Language EO WHERE EO.employeeInfo.employeeCode= :pEmployeeCode")
    public List<Language> getAllByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT EO FROM Language EO WHERE EO.id= :Id")
    public Language get(@Param("Id")Long Id);
}
