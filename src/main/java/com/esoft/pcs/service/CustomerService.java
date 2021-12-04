package com.esoft.pcs.service;

import com.esoft.pcs.models.Customer;
import java.util.List;


public interface CustomerService {

    Customer createNewCustomer(Customer customer);

    List<Customer> getAllCustomers();
}
