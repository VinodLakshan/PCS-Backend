package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.models.PaddySale;
import com.esoft.pcs.service.PaddyPurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping()
    public ResponseEntity<PaddySale> updatePaddyPurchase (@RequestBody PaddyPurchase paddyPurchase) {
        return new ResponseEntity(new ResponseDto( paddyPurchaseService.updatePaddyPurchase(paddyPurchase), HttpStatus.OK), HttpStatus.OK);
    }
}
