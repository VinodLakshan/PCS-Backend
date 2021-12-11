package com.esoft.pcs.controller;

import com.esoft.pcs.dto.ResponseDto;
import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.PaddySale;
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
        log.info("New Farmer Has been Created");
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

    @GetMapping("/getByBranchID/{id}")
    public List<Farmer> getAllFarmerByBranchID(@PathVariable Integer id) throws Exception
    {
        return farmerService.getAllFarmer(id);
    }

    @PutMapping()
    public ResponseEntity<Farmer> updateFarmer (@RequestBody Farmer farmer) {
        log.info("A Farmer has been Updated");
        return new ResponseEntity(new ResponseDto(farmerService.updateFarmer(farmer), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Farmer> deleteFarmer (@PathVariable Integer id) {
        log.info("A Farmer has been Deleted");
        return new ResponseEntity(new ResponseDto(farmerService.deleteFarmer(id), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<?> deleteFarmer () {
        return new ResponseEntity(new ResponseDto(farmerService.getCountOfFarmers(), HttpStatus.OK), HttpStatus.OK);
    }

}
