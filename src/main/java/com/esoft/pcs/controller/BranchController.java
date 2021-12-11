package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.service.BranchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/branch")
@Slf4j
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/{id}")
    private ResponseEntity<?> getBranchDetails(@PathVariable Integer id){
        return new ResponseEntity<>(new ResponseDto(branchService.getBranchById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBranch()
    {
        return new ResponseEntity<>(new ResponseDto(branchService.getAllBranches(), HttpStatus.OK), HttpStatus.OK);
    }
}
