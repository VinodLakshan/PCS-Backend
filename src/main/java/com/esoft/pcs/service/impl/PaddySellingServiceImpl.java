package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.*;

import com.esoft.pcs.repository.CustomerRepository;
import com.esoft.pcs.repository.PaddySaleRepository;
import com.esoft.pcs.repository.PaymentRepository;
import com.esoft.pcs.service.PaddySellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaddySellingServiceImpl implements PaddySellingService {

  @Autowired
  private PaddySaleRepository paddySaleRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private PaymentRepository paymentRepository;

    @Override
    public List<PaddySale> getAllSellingPaddy(Integer branchID) {
      Branch branch = new Branch();
      branch.setId(branchID);
      return paddySaleRepository.findPaddySaleByBranch(branch);
    }
  @Override
  public PaddySale PaddySaleSave(PaddySale paddySale)
  {
    Customer savedCustomer = customerRepository.save(paddySale.getCustomer());
    paddySale.setCustomer(savedCustomer);

    Payment savedPayment = paymentRepository.save(paddySale.getPayment());
    paddySale.setPayment(savedPayment);

    return paddySaleRepository.save(paddySale);
  }
  @Override
  public PaddySale updatePaddySale(PaddySale paddySale)
  {
    PaddySale pendingSale = paddySaleRepository.findById(paddySale.getId()).orElse(null);
    pendingSale.setStatus(paddySale.getStatus());

    return paddySaleRepository.save(pendingSale);
  }
}
