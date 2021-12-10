package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.repository.BranchRepository;
import com.esoft.pcs.repository.PaddyRepository;
import com.esoft.pcs.service.PaddyPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaddyPurchaseServiceImpl implements PaddyPurchaseService {

    @Autowired
    private PaddyRepository paddyRepository;

    @Autowired
    private BranchRepository branchRepository;


    @Override
    public List<PaddyPurchase> getAllPaddyPurchase(Integer branchID) {
        Branch branch = new Branch();
        branch.setId(branchID);
        return paddyRepository.findAllByBranchOrderByIdDesc(branch);
    }

    @Override
    public PaddyPurchase PaddyPurchaseSave(PaddyPurchase paddyPurchase) {
        return null;
    }

    @Override
    public PaddyPurchase updatePaddyPurchase(PaddyPurchase paddyPurchase)
    {
        PaddyPurchase pendingPurchase = paddyRepository.findById(paddyPurchase.getId()).orElse(null);
        pendingPurchase.setStatus(paddyPurchase.getStatus());
        Optional<Branch> dbBranch = branchRepository.findById(pendingPurchase.getBranch().getId());
        dbBranch.get().setStock(dbBranch.get().getStock()+pendingPurchase.getWeight());
        branchRepository.save(dbBranch.get());
        return paddyRepository.save(pendingPurchase);
    }
}
