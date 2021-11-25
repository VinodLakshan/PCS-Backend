package com.esoft.pcs.controller;


import com.esoft.pcs.dto.ReportBuyingOutputDto;
import com.esoft.pcs.dto.ReportIncomeOutputDto;
import com.esoft.pcs.dto.ReportSellingOutputDto;
import com.esoft.pcs.dto.ReportStockOutputDto;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/report")
@Slf4j
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService){this.reportService= reportService;}

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
