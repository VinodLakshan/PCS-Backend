package com.esoft.pcs.controller;

import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.service.PaddyPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/paddyPrice")
@Slf4j
public class PaddyPriceController
{
    @Autowired
    private PaddyPriceService paddyPriceService;

    // Arun
    @GetMapping("/TodayPaddyPriceGet")
    public ResponseEntity<PaddyPrice> TodayPaddyPriceGet(HttpServletRequest request) throws Exception
    {
        return paddyPriceService.TodayPaddyPrice();
    }

    // Arun
    @PostMapping("/PaddyPriceSave")
    public ResponseEntity<PaddyPrice> PaddyPriceSave(@RequestBody PaddyPrice paddyPrice, HttpServletRequest request) throws Exception
    {
        return paddyPriceService.PaddyPriceSave(paddyPrice);
    }
}
