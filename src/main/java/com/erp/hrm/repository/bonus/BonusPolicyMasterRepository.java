package com.erp.hrm.repository.bonus;

import com.erp.hrm.domain.BonusPolicyMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */
@Repository
public interface BonusPolicyMasterRepository extends JpaRepository<BonusPolicyMaster, Long>{

    @Query("SELECT BPM FROM BonusPolicyMaster BPM WHERE bonusCode= :pBonusRuleCode")
    BonusPolicyMaster getBonusPolicyByBonusCode(@Param("pBonusRuleCode")String pBonusRuleCode);

    @Query("SELECT BPM.bonusCode FROM BonusPolicyMaster BPM WHERE BPM.isActive=true")
    List<Object[]> getAllBonusRuleCode();
}
