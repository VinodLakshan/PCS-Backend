package com.esoft.pcs.service.impl;

import com.esoft.pcs.dto.AuthEmployeeDto;
import com.esoft.pcs.exception.UsernameAlreadyExistException;
import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.Role;
import com.esoft.pcs.repository.EmployeeRepository;
import com.esoft.pcs.service.BranchService;
import com.esoft.pcs.service.EmployeeService;
import com.esoft.pcs.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    @Autowired
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
    public Employee createEmployee(Employee employee) throws UsernameAlreadyExistException, 
            CloneNotSupportedException {

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
    public Employee getEmployeeById(Integer id) throws Exception {
        return employeeRepository.findById(id).
                orElseThrow(() -> new Exception("Employee not found for id = " + id));
    }

    @Override
    public List<Employee> getAllEmployee(Integer branchID) {
        Branch branch = new Branch();
        branch.setId(branchID);
        return employeeRepository.findEmployeeByBranch(branch);
    }

    @Override
    public boolean deleteEmployee(Employee employeeDto) {
        return false;
    }

    @Override
    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee with ID " + id + " Has Been Removed Successfully";
    }

    @Override
    public boolean isUserNameAlreadyExist(String userName) {
        return employeeRepository.existsByUserName(userName);
    }

    @Override
    public Employee updateEmp(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
//        existingEmployee.setRegistrationNumber(employee.getRegistrationNumber());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setUserId(employee.getUserId());
        existingEmployee.setBranch(employee.getBranch());
        existingEmployee.setPassword(passwordEncoder.encode(existingEmployee.getPassword()));
        existingEmployee.setRole(employee.getRole());
        return employeeRepository.save(existingEmployee);
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
