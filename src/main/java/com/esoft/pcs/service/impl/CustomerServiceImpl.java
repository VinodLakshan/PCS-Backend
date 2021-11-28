package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Customer;
import com.esoft.pcs.repository.CustomerRepository;
import com.esoft.pcs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getAllCustomer(Integer branchID) {
        Branch branch = new Branch();
        branch.setId(branchID);
        return customerRepository.findCustomerByBranch(branch);
    }

    @Override
    public Customer getCustomerById(Integer id) throws Exception {
        return customerRepository.findById(id).
                orElseThrow(() -> new Exception("Customer not found for the provided ID: " + id));
    }

    @Override
    public String deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
        return "Customer with ID " + id + "Has Been Successfully Removed";
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setAddress(customer.getAddress());
//      existingCustomer.setName(customer.getName());
        return customerRepository.save(existingCustomer);

    }
}
