package com.esoft.pcs.repository;

import com.esoft.pcs.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUserName(String userName);
    Boolean existsByUserName(String userName);
}
