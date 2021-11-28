package com.esoft.pcs.controller;


import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Customer;
import com.esoft.pcs.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> createNewCustomer (@RequestBody Customer customer) {
        return new ResponseEntity(new ResponseDto(customerService.createCustomer(customer), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Customer> getAllCustomer() {
        log.info("Retrieving all Customer");
        return new ResponseEntity(new ResponseDto(customerService.getAllCustomers(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity(new ResponseDto(customerService.getCustomerById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/getByBranchID/{id}")
    public List<Customer> getAllCustomerByBranchID(@PathVariable Integer id) throws Exception
    {
        return customerService.getAllCustomer(id);
    }

    @PutMapping()
    public ResponseEntity<Customer> updateCustomer (@RequestBody Customer customer) {
        return new ResponseEntity(new ResponseDto(customerService.updateCustomer(customer), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer (@PathVariable Integer id) {
        return new ResponseEntity(new ResponseDto(customerService.deleteCustomer(id), HttpStatus.OK), HttpStatus.OK);
    }

}
