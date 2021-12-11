package com.esoft.pcs.service;

import com.esoft.pcs.exception.UsernameAlreadyExistException;
import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Role;
import com.esoft.pcs.repository.EmployeeRepository;
import com.esoft.pcs.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.mockito.ArgumentMatchers.any;

public class EmployeeServiceTest {

    @Mock
    private RoleService roleService;

    @Mock
    private BranchService branchService;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository, roleService, branchService, new BCryptPasswordEncoder());
    }

    @Test
    @DisplayName("Test Register Employee")
    void registerEmployeeTest() throws UsernameAlreadyExistException, CloneNotSupportedException {

        Branch branch = new Branch(1);
        Role role = new Role();
        role.setId(1);

        Employee employee = new Employee();
        employee.setName("TestUser");
        employee.setUserName("TestUserName");
        employee.setPassword("TestPassword");
        employee.setRole(role);
        employee.setBranch(branch);

        Mockito.when(employeeRepository.existsByUserName(employee.getUserName())).thenReturn(false);
        Mockito.when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Mockito.when(roleService.getRoleById(ArgumentMatchers.anyInt())).thenReturn(role);
        Mockito.when(branchService.getBranchById(ArgumentMatchers.anyInt())).thenReturn(branch);

        Assertions.assertNotNull(employeeService.createEmployee(employee));
    }
}
