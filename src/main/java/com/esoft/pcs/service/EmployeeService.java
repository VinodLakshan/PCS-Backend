package com.esoft.pcs.service;

import com.esoft.pcs.models.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employeeDto) throws Exception;

    List<Employee> getAllEmployees();

    Employee getEmployeeByUserName(String userName);

    boolean deleteEmployee(Employee employeeDto);

    boolean isUserNameAlreadyExist(String userName);

    Employee updateEmployee(Employee employeeDto);
}
