package com.esoft.pcs.service;

import com.esoft.pcs.models.PaddyTransfer;

import java.util.List;

public interface PaddyTransferService
{
    PaddyTransfer SavePaddyTransfer(PaddyTransfer paddyTransfer);

    List<PaddyTransfer> GetAllPaddyTransfer();

    PaddyTransfer UpdatePaddyTransfer(PaddyTransfer paddyTransfer);
}
