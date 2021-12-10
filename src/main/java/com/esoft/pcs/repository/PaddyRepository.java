package com.esoft.pcs.repository;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddyPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PaddyRepository extends JpaRepository<PaddyPurchase, Integer>
{
    @Query(value = "SELECT sum(weight) AS TotalQuantity, branch_id FROM pcsdb.paddy_purchase where date between :startDate AND :endDate group by branch_id;",nativeQuery = true)
    List<?> findAllByBranchPaddyCount(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<PaddyPurchase> findAllByBranchOrderByIdDesc(Branch branch);
}
