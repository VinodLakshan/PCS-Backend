package com.esoft.pcs.controller;

import com.esoft.pcs.dto.DateRangeDto;
import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.service.AnalyticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Analytics")
@Slf4j
public class AnalyticsController
{
    @Autowired
    private AnalyticsService analyticsService;

    @PostMapping("BranchPurchaseCount")
    public ResponseEntity<?> GetAllBranchPaddyPurchaseCount(@RequestBody DateRangeDto dateRangeDto)
    {
        return new ResponseEntity<>(new ResponseDto(analyticsService.GetBranchPaddyCount(dateRangeDto), HttpStatus.OK), HttpStatus.OK);
    }
}
