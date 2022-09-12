package com.erp.hrm.repository.payment;

import com.erp.hrm.api.dto.HeadTypeDTO;
import com.erp.hrm.domain.HeadType;
import com.erp.hrm.domain.SalaryHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */
public interface SalaryHeadRepository extends JpaRepository<SalaryHead, Long>{
    @Query("SELECT sh FROM SalaryHead sh")
    List<SalaryHead> getAllSalaryHead();

    @Query("SELECT DISTINCT ht FROM HeadType ht")
    List<HeadType> getAllHeadType();

    @Query("SELECT MAX(sh.SequenceNo) FROM SalaryHead sh")
    int getLastSequenceNo();

    @Query("SELECT COUNT(*) FROM SalaryHead sh WHERE sh.SalaryHeadID=?1")
    int getSalaryHeadCountByHeadCode(String pSalaryHeadID);

    @Query("SELECT COUNT(*) FROM SalaryHead sh WHERE sh.id !=?1 AND sh.SalaryHeadID=?2")
    int getSalaryHeadCountByHeadCodeAndId(long Id,String pSalaryHeadID);
}
