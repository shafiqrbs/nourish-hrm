package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.MaternityLeaveTransInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaternityLeaveTransactionRepository extends JpaRepository<MaternityLeaveTransInfo, Long> {
    @Query("SELECT mtl.employeeInfo.employeeCode,mtl.maternityLeaveRuleID,mtl.fromDate,mtl.toDate,mtl.isBenefitGiven," +
            "mtl.totalLeaveAvail,mtl.EDD,mtl.maternityPayment.tranId,mtl.days,mtl.approvedBy,mtl.dateApproved," +
            "mtl.hrdMemoNo,mtl.hrdMemoDate,remarks " +
            "FROM MaternityLeaveTransInfo mtl WHERE mtl.employeeInfo.employeeCode = :employeeCode")
    List<Object[]> getAllByEmployeeCode(@Param("employeeCode")String employeeCode);

    @Query("SELECT COUNT(mtl) FROM MaternityLeaveTransInfo mtl WHERE mtl.employeeInfo.employeeCode = :employeeCode")
    int getLeaveCountByEmployeeCode(@Param("employeeCode")String employeeCode);

}
