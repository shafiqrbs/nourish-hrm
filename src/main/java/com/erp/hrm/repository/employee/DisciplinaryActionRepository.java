package com.erp.hrm.repository.employee;

//import com.erp.hrm.api.dto.DisciplinaryActionDTO;
import com.erp.hrm.domain.DisciplinaryAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */

@Repository
public interface DisciplinaryActionRepository extends JpaRepository<DisciplinaryAction, Long>{
    @Query("SELECT dpa FROM DisciplinaryAction dpa WHERE dpa.employeeInfo.employeeCode= :pEmployeeCode")
    List<DisciplinaryAction> findAllDisciplinaryActionByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);
}
