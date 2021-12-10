package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Customer;
import com.esoft.pcs.models.PaddySale;

import com.esoft.pcs.models.Payment;
import com.esoft.pcs.repository.CustomerRepository;
import com.esoft.pcs.repository.PaddySaleRepository;
import com.esoft.pcs.repository.PaymentRepository;
import com.esoft.pcs.service.PaddySellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    paddySale.getPayment().setDate(LocalDate.now().toString());
    Payment savedPayment = paymentRepository.save(paddySale.getPayment());
    paddySale.setPayment(savedPayment);

    paddySale.setDate(LocalDate.now().toString());
    paddySale.setStatus(0);

    return paddySaleRepository.save(paddySale);
  }
}
