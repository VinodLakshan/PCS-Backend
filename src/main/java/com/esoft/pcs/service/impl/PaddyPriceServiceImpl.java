package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.repository.PaddyPriceRepository;
import com.esoft.pcs.service.PaddyPriceService;
import org.springframework.stereotype.Service;

@Service
public class PaddyPriceServiceImpl implements PaddyPriceService {

    private final PaddyPriceRepository paddyPriceRepository;

    public PaddyPriceServiceImpl(PaddyPriceRepository paddyPriceRepository) {
        this.paddyPriceRepository = paddyPriceRepository;
    }

    @Override
    public PaddyPrice getLatestPaddyPrices() {
        return paddyPriceRepository.findTopByOrderByIdDesc();
    }
}
