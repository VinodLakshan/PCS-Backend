package com.esoft.pcs.controller;


import com.esoft.pcs.dto.ReportBuyingOutputDto;
import com.esoft.pcs.dto.ReportIncomeOutputDto;
import com.esoft.pcs.dto.ReportSellingOutputDto;
import com.esoft.pcs.dto.ReportStockOutputDto;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/stock-report")
    public @ResponseBody List<ReportStockOutputDto> getStockReport() {
        return reportService.getStockReport();
    }

    @GetMapping("/buying-report")
    public @ResponseBody List<ReportBuyingOutputDto> getBuyingReport() {
        return reportService.getBuyingReport();
    }

    @GetMapping("/selling-report")
    public @ResponseBody List<ReportSellingOutputDto> getSellingReport() {
        return reportService.getSellingReport();
    }

    @GetMapping("/income-report")
    public @ResponseBody List<ReportIncomeOutputDto> getIncomeReport() {
        return reportService.getIncomeReport();
    }
}
