package com.esoft.pcs.controller;

import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/farmer")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping
    public @ResponseBody
    Farmer createNewFarmer (@RequestBody Farmer farmerInputDto) {
        return farmerService.createFarmer(farmerInputDto);
    }

    @GetMapping
    public @ResponseBody List<Farmer> getAllFarmers() {
        return farmerService.getAllFarmers();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Farmer getFarmerById(@PathVariable(value = "id") Integer userId) throws Exception{
        return farmerService.getFarmerById(userId);
    }

    @PutMapping
    public @ResponseBody
    Farmer updateFarmer (@RequestBody Farmer farmerInputDto) {
        return farmerService.updateFarmer(farmerInputDto);
    }

    @DeleteMapping
    public @ResponseBody boolean deleteFarmer (@RequestBody Farmer farmerInputDto) {
        return farmerService.deleteFarmer(farmerInputDto);
    }


}
