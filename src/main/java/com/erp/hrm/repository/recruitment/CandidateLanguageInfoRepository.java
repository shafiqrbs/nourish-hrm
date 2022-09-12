package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateLanguageInfoRepository extends JpaRepository<Language, Long> {
    @Query("SELECT EO FROM Language EO WHERE EO.employeeInfo.employeeCode=?1")
    public List<Language> getAllByEmployeeCode(String pEmployeeCode);

    @Query("SELECT EO FROM Language EO WHERE EO.id=?1")
    public Language get(Long Id);
}
