package com.esoft.pcs.controller;

import com.esoft.pcs.dto.PurchasePaddyDto;
import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.*;
import com.esoft.pcs.service.PaddyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/paddy")
@Slf4j
public class PaddyController {

    private final PaddyService paddyService;

    public PaddyController(PaddyService paddyService) {
        this.paddyService = paddyService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('Collection_Officer')")
    public ResponseEntity<?> makePurchaseOrder(@RequestBody PurchasePaddyDto purchasePaddyDto){

        log.info("Saving paddy purchase");
        Branch branch = new Branch(purchasePaddyDto.getBranchId());
        Farmer farmer = new Farmer(purchasePaddyDto.getFarmerId());
        PaddyPrice paddyPrice = new PaddyPrice(purchasePaddyDto.getPaddyPriceId());
        Payment payment = new Payment(purchasePaddyDto.getDate(), purchasePaddyDto.getPaymentAmount(), "COM Bank", "Pending");

        PaddyPurchase paddyPurchase = new PaddyPurchase(purchasePaddyDto.getDate(), purchasePaddyDto.getWeight(),
                farmer, paddyPrice, branch, payment);
        return new ResponseEntity<>(new ResponseDto(paddyService.savePurchase(paddyPurchase), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{branchId}")
    @PreAuthorize("hasAuthority('Collection_Officer')")
    public ResponseEntity<?> getAllPaddyPurchasesByBranch(@PathVariable Integer branchId){

        log.info("Retrieving Paddy Purchases for branch id: " + branchId);
        return new ResponseEntity<>(new ResponseDto(paddyService.findAllByBranch(new Branch(branchId)), HttpStatus.OK),
                HttpStatus.OK);
    }

}
