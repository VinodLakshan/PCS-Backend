package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Role;
import com.esoft.pcs.repository.RoleRepository;
import com.esoft.pcs.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
