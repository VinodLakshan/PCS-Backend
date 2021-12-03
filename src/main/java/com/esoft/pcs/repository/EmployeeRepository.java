package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUserName(String userName);
    Boolean existsByUserName(String userName);
    List<Employee> findEmployeeByBranch(Branch branch);

}
