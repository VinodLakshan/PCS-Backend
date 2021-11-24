package com.esoft.pcs.service.impl;

import com.esoft.pcs.dto.ReportBuyingOutputDto;
import com.esoft.pcs.dto.ReportIncomeOutputDto;
import com.esoft.pcs.dto.ReportSellingOutputDto;
import com.esoft.pcs.dto.ReportStockOutputDto;
import com.esoft.pcs.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Override
    public List<ReportStockOutputDto> getStockReport() {
        return null;
    }

    @Override
    public List<ReportBuyingOutputDto> getBuyingReport() {
        return null;
    }

    @Override
    public List<ReportSellingOutputDto> getSellingReport() {
        return null;
    }

    @Override
    public List<ReportIncomeOutputDto> getIncomeReport() {
        return null;
    }
}
