package com.erp.hrm.repository;

import com.erp.hrm.domain.CompanySettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface CompanySettingsRepository extends JpaRepository<CompanySettings, Integer>{
    @Query("SELECT comSetting FROM CompanySettings comSetting WHERE comSetting.isDelete = false")
    List<CompanySettings> findAllCompanySettings();

    @Query("SELECT comSetting FROM CompanySettings comSetting WHERE comSetting.companyName = :pCompanyName")
    CompanySettings getCompanySettingsByName(@Param("pCompanyName")String pCompanyName);

    @Transactional
    @Modifying
    @Query("UPDATE CompanySettings CS SET CS.isActive = :isActive WHERE CS.id= :id")
    public void RecordStatusUpdateById(@Param("isActive")Boolean isActive, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE CompanySettings CS SET CS.isDelete = true WHERE CS.id= :id")
    public void RecordIsDeleteStatusUpdateById(@Param("id")Integer id);

}
