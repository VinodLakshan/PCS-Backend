package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Customer;
import com.esoft.pcs.repository.CustomerRepository;
import com.esoft.pcs.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createNewCustomer(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
}
