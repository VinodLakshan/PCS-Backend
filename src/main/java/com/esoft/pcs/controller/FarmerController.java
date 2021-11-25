package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.service.FarmerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/farmer")
@Slf4j
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping()
    public ResponseEntity<Farmer> createNewFarmer (@RequestBody Farmer farmer) {
        return new ResponseEntity(new ResponseDto(farmerService.createFarmer(farmer), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Farmer> getAllFarmers() {
        log.info("Retrieving all farmers");
        return new ResponseEntity(new ResponseDto(farmerService.getAllFarmers(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Integer id) throws Exception {
        return new ResponseEntity(new ResponseDto(farmerService.getFarmerById(id), HttpStatus.OK), HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Farmer> updateFarmer (@RequestBody Farmer farmer) {
        return new ResponseEntity(new ResponseDto(farmerService.updateFarmer(farmer), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Farmer> deleteFarmer (@RequestBody Farmer farmer) {
        return new ResponseEntity(new ResponseDto(farmerService.deleteFarmer(farmer.getId()), HttpStatus.OK), HttpStatus.OK);
    }


}
