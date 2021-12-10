package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.PaddyTransfer;
import com.esoft.pcs.repository.BranchRepository;
import com.esoft.pcs.repository.PaddyTransferRepository;
import com.esoft.pcs.service.PaddyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PaddyTransferServiceImpl implements PaddyTransferService
{
    @Autowired
    private PaddyTransferRepository paddyTransferRepository;

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public PaddyTransfer SavePaddyTransfer(PaddyTransfer paddyTransfer)
    {
        paddyTransfer.setDate(LocalDate.now());
        paddyTransfer.setStatus(0);
        return paddyTransferRepository.save(paddyTransfer);
    }

    @Override
    public List<PaddyTransfer> GetAllPaddyTransfer()
    {
        return paddyTransferRepository.findAll();
    }

    @Override
    public PaddyTransfer UpdatePaddyTransfer(PaddyTransfer paddyTransfer)
    {
        Optional<Branch> DBBranchFrom = branchRepository.findById(paddyTransfer.getBranch().getId());
        DBBranchFrom.ifPresent(branchFrom -> branchFrom.setStock(branchFrom.getStock()-paddyTransfer.getStock()));

        Optional<Branch> DBBranchTo = branchRepository.findById(paddyTransfer.getToBranch().getId());
        DBBranchTo.ifPresent(branchTo -> branchTo.setStock(branchTo.getStock()+paddyTransfer.getStock()));
        return paddyTransferRepository.save(paddyTransfer);
    }
}
