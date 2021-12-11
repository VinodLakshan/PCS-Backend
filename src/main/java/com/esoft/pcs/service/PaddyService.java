package com.esoft.pcs.service;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddyPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaddyService {

    PaddyPurchase savePurchase(PaddyPurchase paddyPurchase);
    List<PaddyPurchase> findAllByBranch(Branch branch);
}
