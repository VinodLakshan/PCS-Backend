package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ErrorResponseDto;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.service.EmployeeService;
import com.esoft.pcs.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> employeeLogin(@RequestBody Employee employee){
        log.info("Employee is logging in");
        return new ResponseEntity<>(jwtUtil.authenticate(employee), HttpStatus.OK);
    }

    @PostMapping("/register")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> registerEmployee(Employee employee){

        log.info("Employee is being registered");
        try {
            Employee createdEmployee = employeeService.createEmployee(employee);
            return new ResponseEntity<>(jwtUtil.authenticate(createdEmployee), HttpStatus.OK);

        } catch (Exception e) {
            
            log.error(e.getMessage());
            return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.CONFLICT, e.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public List<Employee> getAllEmployees(){
        log.info("Retrieving all employees");
        return employeeService.getAllEmployees();
    }

}
