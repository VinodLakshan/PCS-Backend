package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Employee;
import com.esoft.pcs.repository.EmployeeRepository;
import com.esoft.pcs.service.EmployeeService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
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
    public boolean isUseNameAlreadyExist(String userName) {

        Employee emp = employeeRepository.findByUserName(userName);
        return emp != null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Employee employee = this.getEmployeeByUserName(userName);
        if (employee == null) throw new UsernameNotFoundException("User not Found.");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(employee.getRole().getRoleName()));

        return new User(employee.getUserName(), employee.getPassword(), authorities);
    }
}
