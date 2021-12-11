package com.esoft.pcs.service;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import com.esoft.pcs.models.PaddySale;

import java.util.List;

public interface FarmerService {

    Long getCountOfFarmers();

    Farmer createFarmer(Farmer farmer);

    List<Farmer> getAllFarmers();

    List<Farmer> getAllFarmer(Integer branchID);

    Farmer getFarmerById(Integer id) throws Exception;

    String deleteFarmer(Integer id);

    Farmer updateFarmer(Farmer farmer);

}


