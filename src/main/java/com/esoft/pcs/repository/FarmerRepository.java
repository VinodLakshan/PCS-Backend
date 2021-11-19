package com.esoft.pcs.repository;

import com.esoft.pcs.models.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
}
