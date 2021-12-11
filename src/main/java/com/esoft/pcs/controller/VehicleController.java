package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Vehicle;
import com.esoft.pcs.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/Vehicle")
@RestController
public class VehicleController
{
    @Autowired
    public VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> GetAllVehicles()
    {
        return new ResponseEntity<>(new ResponseDto(vehicleService.GetAllVehicles(), HttpStatus.OK), HttpStatus.OK);
    }
}
