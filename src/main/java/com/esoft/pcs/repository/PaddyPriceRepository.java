package com.esoft.pcs.repository;

import com.esoft.pcs.models.PaddyPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaddyPriceRepository extends JpaRepository<PaddyPrice, Long>
{
    PaddyPrice getTopByDate(String date);
}
