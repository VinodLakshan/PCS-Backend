package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.repository.PaddyPriceRepository;
import com.esoft.pcs.service.PaddyPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaddyPriceServiceImpl implements PaddyPriceService
{
    @Autowired
    PaddyPriceRepository paddyPriceRepository;

    @Override
    public PaddyPrice TodayPaddyPrice()
    {
        return paddyPriceRepository.getTopByDate(LocalDate.now().toString());
    }

    @Override
    public PaddyPrice PaddyPriceSave(PaddyPrice paddyPrice)
    {
        PaddyPrice PaddyPriceDB = paddyPriceRepository.getTopByDate(paddyPrice.getDate());
        if(PaddyPriceDB == null)
        {
            return paddyPriceRepository.save(paddyPrice);
        }
        else
        {
            PaddyPriceDB.setBuyingPrice(paddyPrice.getBuyingPrice());
            PaddyPriceDB.setSellingPrice(paddyPrice.getSellingPrice());
            return paddyPriceRepository.save(PaddyPriceDB);
        }
    }


}
