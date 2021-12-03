package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Employee;
import com.esoft.pcs.models.PaddyPurchase;
import com.esoft.pcs.models.PaddySale;
import com.esoft.pcs.service.PaddySellingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping()
    public ResponseEntity<PaddySale> updatePaddySale (@RequestBody PaddySale paddySale) {
        return new ResponseEntity(new ResponseDto( paddySellingService.updatePaddySale(paddySale) , HttpStatus.OK), HttpStatus.OK);
    }
}
