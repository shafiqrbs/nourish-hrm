package com.erp.hrm.repository.payment;

import com.erp.hrm.api.dto.SalaryRuleCodeDTO;
import com.erp.hrm.domain.SalaryRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */
public interface SalaryRuleRepository extends JpaRepository<SalaryRule, Long>{
    @Query("SELECT SR.id,SR.salaryRuleCode,SR.salaryHeadID,SR.sCriteria,SR.parentHeadID,SR.parentHeadValue,SR.isFixed,SR.isHigher," +
            "SR.formula1,SR.formula2,SR.sequenceNo " +
            "FROM SalaryRule SR WHERE SR.salaryRuleCode=?1")
    List<Object[]> getAllSalaryRuleByRuleCode(String pSalaryRuleCode);

    @Query("SELECT SR.id,SR.salaryRuleCode,SR.salaryHeadID,SR.sCriteria,SR.parentHeadID,SR.parentHeadValue,SR.isFixed,SR.isHigher," +
            "SR.formula1,SR.formula2,SR.sequenceNo " +
            "FROM SalaryRule SR WHERE SR.id=?1")
    List<Object[]> getSalaryRuleById(long id);

    @Query("SELECT MAX(sr.sequenceNo) FROM SalaryRule sr")
    int getLastSequenceNo();

    @Query("SELECT COUNT(*) FROM SalaryRule sh WHERE sh.salaryRuleCode=?1 AND sh.salaryHeadID=?2")
    int getSalaryHeadCount(String pSalaryRuleCode, String pSalaryHeadId);

    @Query("SELECT DISTINCT sh.salaryRuleCode FROM SalaryRule sh")
    List<String> getAllSalaryRuleCode();

    @Query("SELECT SR.salaryRuleCode,SR.salaryHeadID,SR.sCriteria,SR.parentHeadID,SR.parentHeadValue,SR.isFixed "+
            "FROM SalaryRule SR WHERE SR.salaryRuleCode=?1 AND SR.salaryHeadID !='GROSS' " +
            "ORDER BY SR.sequenceNo ASC")
    List<Object[]> getAllSalaryRuleExceptGrossByRuleCode(String pSalaryRuleCode);

    @Query("SELECT SR.salaryRuleCode,SR.salaryHeadID,SR.sCriteria,SR.parentHeadID,SR.parentHeadValue,SR.isFixed "+
            "FROM SalaryRule SR WHERE SR.salaryRuleCode=?1 " +
            "ORDER BY SR.sequenceNo ASC")
    List<Object[]> getAllSalaryRuleWithGrossByRuleCode(String pSalaryRuleCode);

    @Query("SELECT sh FROM SalaryRule sh WHERE sh.salaryRuleCode=?1 AND sh.salaryHeadID=?2")
    SalaryRule getSalaryRuleByRuleAndSalaryHead(String pSalaryRuleCode, String pSalaryHeadId);
}
