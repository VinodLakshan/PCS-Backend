package com.esoft.pcs.service.impl;

import com.esoft.pcs.dto.AuthEmployeeDto;
import com.esoft.pcs.exception.UsernameAlreadyExistException;
import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Role;
import com.esoft.pcs.repository.EmployeeRepository;
import com.esoft.pcs.service.BranchService;
import com.esoft.pcs.service.EmployeeService;
import com.esoft.pcs.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    private final EmployeeRepository employeeRepository;
    private final RoleService roleService;
    private final BranchService branchService;
    private final PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, RoleService roleService, BranchService branchService, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.roleService = roleService;
        this.branchService = branchService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Employee createEmployee(Employee employee) throws UsernameAlreadyExistException, CloneNotSupportedException {

        if (!employeeRepository.existsByUserName(employee.getUserName())) {
            Employee emp = (Employee) employee.clone();
            emp.setPassword(passwordEncoder.encode(emp.getPassword()));
            Employee savedEmployee = employeeRepository.save(emp);
            savedEmployee.setRole(roleService.getRoleById(savedEmployee.getRole().getId()));
            savedEmployee.setBranch(branchService.getBranchById(savedEmployee.getBranch().getId()));
            return savedEmployee;

        } else {
            throw new UsernameAlreadyExistException("Username is already taken");
        }

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByUserName(String userName) {
        return employeeRepository.findByUserName(userName);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public boolean isUserNameAlreadyExist(String userName) {
        return employeeRepository.existsByUserName(userName);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Employee employee = this.getEmployeeByUserName(userName);
        if (employee == null) {
            log.error("Employee not found");
            throw new UsernameNotFoundException("Employee not Found.");
        }
        log.info("Employee Found");

        return new AuthEmployeeDto(employee);
    }

}
