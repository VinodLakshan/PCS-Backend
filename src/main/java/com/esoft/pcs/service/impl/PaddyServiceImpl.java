package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.repository.BranchRepository;
import com.esoft.pcs.repository.FarmerRepository;
import com.esoft.pcs.repository.PaddyRepository;
import com.esoft.pcs.service.PaddyService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaddyServiceImpl implements PaddyService {

    private final PaddyRepository paddyRepository;
    private final BranchRepository branchRepository;
    private final FarmerRepository farmerRepository;

    public PaddyServiceImpl(PaddyRepository paddyRepository, BranchRepository branchRepository, FarmerRepository farmerRepository) {
        this.paddyRepository = paddyRepository;
        this.branchRepository = branchRepository;
        this.farmerRepository = farmerRepository;
    }

    @Override
    public PaddyPurchase savePurchase(PaddyPurchase paddyPurchase) {

        PaddyPurchase savePurchase = paddyRepository.save(paddyPurchase);

        Branch branchById = branchRepository.findById(paddyPurchase.getBranch().getId()).orElse(null);
        Farmer farmerById = farmerRepository.findById(paddyPurchase.getFarmer().getId()).orElse(null);

        if (branchById != null && farmerById != null) {

            branchById.setStock(branchById.getStock() + savePurchase.getWeight());
            farmerById.setTotalMonthlyPaddyAmount(farmerById.getTotalMonthlyPaddyAmount() + paddyPurchase.getWeight());

            branchRepository.save(branchById);
            farmerRepository.save(farmerById);
        }

        return savePurchase;
    }

    @Override
    public List<PaddyPurchase> findAllByBranch(Branch branch) {
        return paddyRepository.findAllByBranchOrderByIdDesc(branch);
    }
}
