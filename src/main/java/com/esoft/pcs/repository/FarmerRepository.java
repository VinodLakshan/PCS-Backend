package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.PaddyPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
    List<Farmer> findAllByBranchOrderByIdDesc(Branch branch);
}
