package com.esoft.pcs.service;

import com.esoft.pcs.models.PaddyPrice;
import org.springframework.http.ResponseEntity;

public interface PaddyPriceService
{
    ResponseEntity<PaddyPrice> TodayPaddyPrice();

    ResponseEntity<PaddyPrice> PaddyPriceSave(PaddyPrice paddyPrice);
}
