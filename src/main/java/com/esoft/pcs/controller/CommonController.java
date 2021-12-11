package com.esoft.pcs.controller;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Role;
import com.esoft.pcs.service.BranchService;
import com.esoft.pcs.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/common")
@Slf4j
public class CommonController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private BranchService branchService;

    @GetMapping("/rolesAndBranches")
    public ResponseEntity<?> getAllRolesAndBranches(){

        List<Role> allRoles = roleService.getAllRoles();
        List<Branch> allBranches = branchService.getAllBranches();

        Map<String, List<?>> map = new HashMap<>();
        map.put("roles", allRoles);
        map.put("branches", allBranches);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
