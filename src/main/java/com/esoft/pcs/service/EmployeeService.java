package com.esoft.pcs.service;

import com.esoft.pcs.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeByUserName(String userName);

    boolean deleteEmployee(Employee employee);

    boolean isUseNameAlreadyExist(String userName);

    Employee updateEmployee(Employee employee);
}
