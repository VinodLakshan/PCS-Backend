package com.esoft.pcs.controller;

import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.service.PaddyPurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/paddyPurchase")
@Slf4j
public class PaddyPurchaseController
{
    @Autowired
    private PaddyPurchaseService paddyPurchaseService;
    @GetMapping("/getByBranchID/{ID}")
    public List<PaddyPurchase> getAllPaddyPurchaseByBranchID(@PathVariable Integer ID) throws Exception
    {
        return paddyPurchaseService.getAllPaddyPurchase(ID);
    }
}
