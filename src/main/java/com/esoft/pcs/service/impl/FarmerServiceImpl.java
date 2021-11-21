package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.repository.FarmerRepository;
import com.esoft.pcs.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    @Override
    public Farmer getFarmerById(Integer id) throws Exception {
        return farmerRepository.findById(id).
                orElseThrow(() -> new Exception("Farmer not found for id=" + id));
    }

    @Override
    public boolean deleteFarmer(Farmer farmer) {
        farmerRepository.delete(farmer);
        return true;
    }

    @Override
    public Farmer updateFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }
}
