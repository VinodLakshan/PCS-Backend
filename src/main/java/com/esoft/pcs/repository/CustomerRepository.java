package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findCustomerByBranch(Branch branch);

}
