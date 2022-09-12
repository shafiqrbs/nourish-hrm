package com.erp.hrm.service.impl.report;

import com.erp.hrm.domain.Customer;
import com.erp.hrm.repository.CustomerRepository;
import com.erp.hrm.service.report.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 18/04/2018.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
