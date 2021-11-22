package com.esoft.pcs.service;

import com.esoft.pcs.models.Branch;

import java.util.List;

public interface BranchService {

    List<Branch> getAllBranches();

    Branch getBranchById(Integer id);
}
