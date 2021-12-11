package com.esoft.pcs.service.impl;

import com.esoft.pcs.dto.DateRangeDto;
import com.esoft.pcs.repository.PaddyRepository;
import com.esoft.pcs.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService
{
    @Autowired
    private PaddyRepository paddyRepository;

    @Override
    public List<?> GetBranchPaddyCount(DateRangeDto dateRangeDto)
    {
        return paddyRepository.findAllByBranchPaddyCount(dateRangeDto.getStartDate(),dateRangeDto.getEndDate());
    }
}
