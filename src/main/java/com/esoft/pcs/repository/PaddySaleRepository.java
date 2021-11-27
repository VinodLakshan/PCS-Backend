package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddySale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaddySaleRepository extends JpaRepository<PaddySale, Integer> {

}
