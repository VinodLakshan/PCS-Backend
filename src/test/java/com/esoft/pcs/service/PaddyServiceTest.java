package com.esoft.pcs.service;

import com.esoft.pcs.models.*;
import com.esoft.pcs.repository.BranchRepository;
import com.esoft.pcs.repository.FarmerRepository;
import com.esoft.pcs.repository.PaddyRepository;
import com.esoft.pcs.service.impl.PaddyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Matchers.any;

public class PaddyServiceTest {

    @Mock
    private PaddyRepository paddyRepository;

    @Mock
    private BranchRepository branchRepository;

    @Mock
    private FarmerRepository farmerRepository;

    @InjectMocks
    private PaddyServiceImpl paddyService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        paddyService = new PaddyServiceImpl(paddyRepository, branchRepository, farmerRepository);
    }

    @Test
    @DisplayName("Test Create Purchase Paddy Order")
    void createPurchasePaddyOrderTest(){

        Farmer farmer = new Farmer(1);
        PaddyPrice paddyPrice = new PaddyPrice(1);
        Branch branch = new Branch(1);
        branch.setStock(20.00);
        Payment payment = new Payment("2021-12-05", 2500.00, "COM BANK", "Pending");

        PaddyPurchase paddyPurchase = new PaddyPurchase("2012-12-05", 12.00, farmer, paddyPrice, branch, payment, 0);
        Mockito.when(paddyRepository.save(paddyPurchase)).thenReturn(paddyPurchase);
        Mockito.when(branchRepository.findById(1)).thenReturn(java.util.Optional.of(branch));
        Mockito.when(branchRepository.save(any(Branch.class))).thenReturn(branch);
        Mockito.when(farmerRepository.findById(1)).thenReturn(java.util.Optional.of(farmer));
        Mockito.when(farmerRepository.save(any(Farmer.class))).thenReturn(farmer);

        Assertions.assertNotNull(paddyService.savePurchase(paddyPurchase));
    }
}
