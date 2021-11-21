package com.esoft.pcs.controller;

import com.esoft.pcs.models.PaddyPrice;
import com.esoft.pcs.service.PaddyPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/paddyPrice")
public class PaddyPriceController
{
    @Autowired
    private PaddyPriceService paddyPriceService;

    @GetMapping("/TodayPaddyPriceGet")
    public PaddyPrice TodayPaddyPriceGet(HttpServletRequest request) throws Exception
    {
        return paddyPriceService.TodayPaddyPrice();
    }
}
