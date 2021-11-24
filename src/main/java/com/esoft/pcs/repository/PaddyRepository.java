package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddyPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaddyRepository extends JpaRepository<PaddyPurchase, Integer> {

    List<PaddyPurchase> findAllByBranchOrderByIdDesc(Branch branch);
}
