package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Branch;
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

//  To Save a Single Farmer (Post Method)
    @Override
    public Long getCountOfFarmers() {
        return farmerRepository.count();
    }

    @Override
    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

//   To Fetch All Farmer Object from the Database (Get Method)
    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

//   To Fetch All Farmer Object from the Database (Get Method)
    @Override
    public Farmer getFarmerById(Integer id) throws Exception {
        return farmerRepository.findById(id).
                orElseThrow(() -> new Exception("Farmer not found for id = " + id));
    }

//    @Override
//    public boolean deleteFarmer(Farmer farmer) {
//        farmerRepository.delete(farmer);
//        return true;
//    }

    @Override
    public String deleteFarmer(Integer id){
        farmerRepository.deleteById(id);
        return "Farmer With ID" + id + " Has Been Removed Successfully";
    }

    @Override
    public Farmer updateFarmer(Farmer farmer) {
        Farmer existingFarmer = farmerRepository.findById(farmer.getId()).orElse(null);
        existingFarmer.setName(farmer.getName());
//        existingFarmer.setRegistrationNumber(farmer.getRegistrationNumber());
        existingFarmer.setAddress(farmer.getAddress());
        existingFarmer.setTelephoneNumber(farmer.getTelephoneNumber());
        return farmerRepository.save(existingFarmer);
    }

}
