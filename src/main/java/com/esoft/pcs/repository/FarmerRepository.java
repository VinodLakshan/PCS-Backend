package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.models.PaddySale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {

    List<Farmer> findFarmerByBranch(Branch branch);

}
