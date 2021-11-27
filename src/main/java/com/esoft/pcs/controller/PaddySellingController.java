package com.esoft.pcs.controller;

import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.models.PaddySale;
import com.esoft.pcs.service.PaddySellingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/paddySelling")
@Slf4j
public class PaddySellingController {
    @Autowired
    private PaddySellingService paddySellingService;

    @GetMapping("/getByBranchID/{ID}")
    public List<PaddySale> getAllPaddySalesByBranchID(@PathVariable Integer ID) throws Exception
    {
        return paddySellingService.getAllSellingPaddy(ID);
    }
}
