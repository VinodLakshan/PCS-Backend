package com.esoft.pcs.service;

import com.esoft.pcs.models.Customer;
import java.util.List;


public interface CustomerService {

    Customer createNewCustomer(Customer customer);

    List<Customer> getAllCustomers();

    List<Customer> getAllCustomer(Integer branchID);

    Customer getCustomerById(Integer id) throws Exception;

    String deleteCustomer(Integer id);

    Customer updateCustomer(Customer customer);

    Customer createNewCustomer(Customer customer);





    long GetCustomerTotalCount();
}
