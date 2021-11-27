package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.repository.PaddyRepository;
import com.esoft.pcs.service.PaddyPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaddyPurchaseServiceImpl implements PaddyPurchaseService {

    @Autowired
    private PaddyRepository paddyRepository;


    @Override
    public List<PaddyPurchase> getAllPaddyPurchase(Integer branchID) {
        Branch branch = new Branch();
        branch.setId(branchID);
        return paddyRepository.findAllByBranchOrderByIdDesc(branch);
    }
}
