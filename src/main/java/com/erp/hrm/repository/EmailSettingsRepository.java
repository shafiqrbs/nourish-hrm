package com.erp.hrm.repository;

import com.erp.hrm.domain.EmailSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Repository
public interface EmailSettingsRepository extends JpaRepository<EmailSettings, Integer>{
    @Query("SELECT d FROM EmailSettings d")
    List<EmailSettings> findAllEmailSettings();
}
