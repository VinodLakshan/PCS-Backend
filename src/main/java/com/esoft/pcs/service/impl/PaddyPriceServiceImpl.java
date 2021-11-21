package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.repository.PaddyPriceRepository;
import com.esoft.pcs.service.PaddyPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaddyPriceServiceImpl implements PaddyPriceService
{
    @Autowired
    PaddyPriceRepository paddyPriceRepository;

    @Override
    public ResponseEntity<PaddyPrice> TodayPaddyPrice()
    {
        return new ResponseEntity<PaddyPrice>(paddyPriceRepository.getTopByDate(LocalDate.now().toString()), HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity<PaddyPrice> PaddyPriceSave(PaddyPrice paddyPrice)
    {
        PaddyPrice PaddyPriceDB = paddyPriceRepository.getTopByDate(paddyPrice.getDate());
        if(PaddyPriceDB == null)
        {
            return ResponseEntity.ok(paddyPriceRepository.save(paddyPrice));
        }
        else
        {
            PaddyPriceDB.setBuyingPrice(paddyPrice.getBuyingPrice());
            PaddyPriceDB.setSellingPrice(paddyPrice.getSellingPrice());
            return ResponseEntity.ok(paddyPriceRepository.save(PaddyPriceDB));
        }
    }


}
