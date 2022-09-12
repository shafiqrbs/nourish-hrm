package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.LeaveYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveYearRepository extends JpaRepository<LeaveYear, Long> {
    @Query("SELECT ly FROM LeaveYear ly")
    List<LeaveYear> findAll();

    @Query("SELECT ly FROM LeaveYear ly WHERE ly.isActive=true")
    LeaveYear getActiveLeaveYear();
}
