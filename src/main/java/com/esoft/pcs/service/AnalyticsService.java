package com.esoft.pcs.service;

import com.esoft.pcs.dto.DateRangeDto;

import java.util.List;

public interface AnalyticsService
{
    List<?> GetBranchPaddyCount(DateRangeDto dateRangeDto);
}
