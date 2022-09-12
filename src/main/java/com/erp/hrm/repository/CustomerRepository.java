package com.erp.hrm.repository;

import com.erp.hrm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sohag on 18/04/2018.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
