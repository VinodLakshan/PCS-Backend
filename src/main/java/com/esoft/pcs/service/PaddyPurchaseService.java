package com.esoft.pcs.service;

import com.esoft.pcs.models.PaddyPurchase;

import java.util.List;

public interface PaddyPurchaseService {
    List<PaddyPurchase> getAllPaddyPurchase(Integer branchID);
}
