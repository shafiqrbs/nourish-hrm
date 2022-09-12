package com.erp.hrm.repository.attendance;

import com.erp.hrm.domain.PunchMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sohag on 26/09/2018.
 */
@Repository
public interface PunchMachineRepository extends JpaRepository<PunchMachine, Long>{
}
