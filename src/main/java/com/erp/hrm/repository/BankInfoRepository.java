package com.erp.hrm.repository;

import com.erp.hrm.domain.Bank;
import com.erp.hrm.domain.Designation;
import com.erp.hrm.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */

@Repository
public interface BankInfoRepository extends JpaRepository<Bank, Long>{
}
