package com.esoft.pcs.repository;

import com.esoft.pcs.models.PaddyTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaddyTransferRepository extends JpaRepository<PaddyTransfer,Integer>
{
}
