package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ErrorResponseDto;
import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.exception.UsernameAlreadyExistException;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.Farmer;
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
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtUtil jwtUtil;

//    Zaid Starting
//    @GetMapping()
//    public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
//
//    log.info("Employee is being registered");
//    try {
//        Employee createdEmployee = employeeService.createEmployee(employee);
//        if (createdEmployee != null) {
//            log.info("Employee registered");
//            return new ResponseEntity<>(jwtUtil.authenticate(employee), HttpStatus.OK);
//
//        } else {
//            log.error("Employee registration failed");
//            return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.EXPECTATION_FAILED, "Employee registration failed"),
//                    HttpStatus.EXPECTATION_FAILED);
//        }
//
//    } catch (UsernameAlreadyExistException e) {
//
//        log.error(e.getMessage());
//        return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.CONFLICT, e.getMessage()), HttpStatus.CONFLICT);
//
//    } catch (CloneNotSupportedException e) {
//        log.error(e.getMessage());
//        return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}

    @GetMapping()
    public ResponseEntity<Employee> getAllEmployee() {
        log.info("Retrieving all Employees");
        return new ResponseEntity(new ResponseDto(employeeService.getAllEmployees(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity(new ResponseDto(employeeService.getEmployeeById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasAuthority('Admin')")
    public ResponseEntity<Employee> getEmployeeByUsername(@PathVariable String username){
        return new ResponseEntity<>(employeeService.getEmployeeByUserName(username), HttpStatus.OK);
    }

    @GetMapping("/getByBranchID/{id}")
    public List<Employee> getAllEmployeeByBranchID(@PathVariable Integer id) throws Exception
    {
        return employeeService.getAllEmployee(id);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee (@RequestBody Employee employee) {
        return new ResponseEntity(new ResponseDto(employeeService.updateEmp(employee), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee (@PathVariable Integer id) {
        return new ResponseEntity(new ResponseDto(employeeService.deleteEmployee(id), HttpStatus.OK), HttpStatus.OK);
    }

//    Zaid End

    @PostMapping("/login")
    public ResponseEntity<?> employeeLogin(@RequestBody Employee employee) {
        log.info("Employee is logging in");
        System.out.println(jwtUtil.authenticate(employee).getToken());
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



//    @GetMapping
//    public ResponseEntity<?> getAllEmployees() {
//        log.info("Retrieving all employees");
//        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
//    }



}
