package com.esoft.pcs.service.impl;

import com.esoft.pcs.dto.ReportBuyingOutputDto;
import com.esoft.pcs.dto.ReportIncomeOutputDto;
import com.esoft.pcs.dto.ReportSellingOutputDto;
import com.esoft.pcs.dto.ReportStockOutputDto;
import com.esoft.pcs.models.*;
import com.esoft.pcs.repository.BranchRepository;
import com.esoft.pcs.repository.PaddyRepository;
import com.esoft.pcs.repository.PaddySaleRepository;
import com.esoft.pcs.repository.PaymentRepository;
import com.esoft.pcs.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final BranchRepository branchRepository;

    private final PaddyRepository paddyRepository;

    private final PaddySaleRepository paddySaleRepository;

    private final PaymentRepository paymentRepository;

    public ReportServiceImpl(BranchRepository branchRepository, PaddyRepository paddyRepository,
                             PaddySaleRepository paddySaleRepository, PaymentRepository paymentRepository){
        this.branchRepository = branchRepository;
        this.paddyRepository = paddyRepository;
        this.paddySaleRepository = paddySaleRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<ReportStockOutputDto> getStockReport() {
        List<Branch> allBranches = branchRepository.findAll();
        List<ReportStockOutputDto> stockOutputDtos = new ArrayList<>();
        for (Branch branch: allBranches) {
            stockOutputDtos.add(new ReportStockOutputDto(branch.getAddress(), branch.getStock(),
                    branch.getMonthlyExpectedStock(), branch.getMaximumCapacity(),
                    branch.getTotalMonthlyPaddyLimitPerFarmer()));
        }
        return stockOutputDtos;
    }

    @Override
    public List<ReportBuyingOutputDto> getBuyingReport() {
        List<PaddyPurchase> paddyPurchases = paddyRepository.findAll();
        List<ReportBuyingOutputDto> buyingOutputDtos = new ArrayList<>();
        for (PaddyPurchase paddyPurchase: paddyPurchases) {
            buyingOutputDtos.add(new ReportBuyingOutputDto(paddyPurchase.getDate(), paddyPurchase.getWeight(),
                    paddyPurchase.getFarmer(), paddyPurchase.getPaddyPrice(), paddyPurchase.getBranch(),
                    paddyPurchase.getPayment()));
        }
        return buyingOutputDtos;
    }

    @Override
    public List<ReportSellingOutputDto> getSellingReport() {
        List<PaddySale> paddySaleList = paddySaleRepository.findAll();
        List<ReportSellingOutputDto> sellingOutputDtos = new ArrayList<>();
        for (PaddySale paddySale: paddySaleList) {
            sellingOutputDtos.add(new ReportSellingOutputDto(paddySale.getDate(), paddySale.getWeight(),
                    paddySale.getPaddyPrice(), paddySale.getBranch(), paddySale.getCustomer(),
                    paddySale.getPayment()));
        }
        return sellingOutputDtos;
    }

    @Override
    public List<ReportIncomeOutputDto> getIncomeReport() {
        List<Payment> allPayments = paymentRepository.findAll();
        List<ReportIncomeOutputDto> incomeOutputDtos = new ArrayList<>();
        for (Payment payment: allPayments) {
            incomeOutputDtos.add(new ReportIncomeOutputDto(payment.getDate(), payment.getAmount(),
                    payment.getBank(), payment.getStatus()));
        }
        return incomeOutputDtos;
    }
}
