package com.esoft.pcs.service;

import com.esoft.pcs.dto.ReportBuyingOutputDto;
import com.esoft.pcs.dto.ReportIncomeOutputDto;
import com.esoft.pcs.dto.ReportSellingOutputDto;
import com.esoft.pcs.dto.ReportStockOutputDto;

import java.util.List;

public interface ReportService {

    List<ReportStockOutputDto> getStockReport();

    List<ReportBuyingOutputDto> getBuyingReport();

    List<ReportSellingOutputDto> getSellingReport();

    List<ReportIncomeOutputDto> getIncomeReport();
}
