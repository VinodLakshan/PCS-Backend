package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Customer;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){this.customerService= customerService;}

    @PostMapping()
    public ResponseEntity<Customer> createNewCustomer (@RequestBody Customer customer) {
        return new ResponseEntity(new ResponseDto(customerService.createNewCustomer(customer), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Farmer> getAllCustomers() {
        return new ResponseEntity(new ResponseDto(customerService.getAllCustomers(), HttpStatus.OK), HttpStatus.OK);
    }

}
