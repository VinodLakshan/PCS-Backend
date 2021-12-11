package com.esoft.pcs.service;

import com.esoft.pcs.exception.UsernameAlreadyExistException;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Farmer;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employeeDto) throws UsernameAlreadyExistException, CloneNotSupportedException;

    List<Employee> getAllEmployees();

    Employee getEmployeeByUserName(String userName);

    Employee getEmployeeById(Integer id) throws Exception;

    boolean deleteEmployee(Employee employeeDto);

    String deleteEmployee(Integer id);

    boolean isUserNameAlreadyExist(String userName);

    Employee updateEmp(Employee employee);

    List<Employee> getAllEmployee(Integer branchID);
}
