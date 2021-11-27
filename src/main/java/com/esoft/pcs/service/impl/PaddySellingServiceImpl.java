package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddySale;

import com.esoft.pcs.repository.PaddySaleRepository;
import com.esoft.pcs.service.PaddySellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaddySellingServiceImpl implements PaddySellingService {
  @Autowired
  private PaddySaleRepository paddySaleRepository;


    @Override

    public List<PaddySale> getAllSellingPaddy(Integer branchID) {
      Branch branch = new Branch();
      branch.setId(branchID);
      return paddySaleRepository.findPaddySaleByBranch(branch);
    }
}
