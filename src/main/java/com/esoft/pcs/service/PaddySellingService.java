package com.esoft.pcs.service;


import com.esoft.pcs.models.PaddySale;

import java.util.List;

public interface PaddySellingService {
    List<PaddySale> getAllSellingPaddy(Integer branchID);

    PaddySale PaddySaleSave(PaddySale paddySale);

    PaddySale updatePaddySale(PaddySale  paddySale);

}
