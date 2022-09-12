package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.EmployeeLeaveMaster;
//import com.erp.hrm.domain.LeaveYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeLeaveMasterRepository extends JpaRepository<EmployeeLeaveMaster, Long> {
    @Query("SELECT ly FROM EmployeeLeaveMaster ly")
    List<EmployeeLeaveMaster> findAll();

    @Query("SELECT el FROM EmployeeLeaveMaster el" +
            " WHERE el.employeeInfo.employeeCode= :pEmpCode AND el.leavePolicyInfo.leavePolicyID= :pLeaveProcessId " +
            " AND el.availFrom = :pFromDate  AND el.availTo = :pToDate ")
    EmployeeLeaveMaster findOneAll(@Param("pEmpCode")String pEmpCode, @Param("pLeaveProcessId")String pLeaveProcessId, 
    		@Param("pFromDate")Date pFromDate , @Param("pToDate") Date pToDate );
}
