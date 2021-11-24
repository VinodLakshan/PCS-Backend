package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ErrorResponseDto;
import com.esoft.pcs.exception.UsernameAlreadyExistException;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.service.EmployeeService;
import com.esoft.pcs.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> employeeLogin(@RequestBody Employee employee) {
        log.info("Employee is logging in");
        return new ResponseEntity<>(jwtUtil.authenticate(employee), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {

        log.info("Employee is being registered");
        try {
            Employee createdEmployee = employeeService.createEmployee(employee);
            if (createdEmployee != null) {
                log.info("Employee registered");
                return new ResponseEntity<>(jwtUtil.authenticate(employee), HttpStatus.OK);

            } else {
                log.error("Employee registration failed");
                return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.EXPECTATION_FAILED, "Employee registration failed"),
                        HttpStatus.EXPECTATION_FAILED);
            }

        } catch (UsernameAlreadyExistException e) {

            log.error(e.getMessage());
            return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.CONFLICT, e.getMessage()), HttpStatus.CONFLICT);

        } catch (CloneNotSupportedException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getEmployeeByUsername(@PathVariable String username){
        return new ResponseEntity<>(employeeService.getEmployeeByUserName(username), HttpStatus.OK);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<?> getAllEmployees() {
        log.info("Retrieving all employees");
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

}
