package com.erp.hrm.repository.employee;

import com.erp.hrm.api.dto.PromotionDTO;
import com.erp.hrm.domain.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>{
    @Query("SELECT pmt FROM Promotion pmt WHERE pmt.employeeInfo.employeeCode= :pEmployeeCode")
    List<Promotion> findAllPromotionByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);
}
