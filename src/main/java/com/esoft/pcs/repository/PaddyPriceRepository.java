package com.esoft.pcs.repository;

import com.esoft.pcs.models.PaddyPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaddyPriceRepository extends JpaRepository<PaddyPrice, Integer>
{
    PaddyPrice getTopByDate(String date);
}
