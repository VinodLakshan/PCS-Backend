package com.esoft.pcs.service;

import com.esoft.pcs.models.Branch;
import com.esoft.pcs.models.Farmer;
import java.util.List;

public interface FarmerService {

    Farmer createFarmer(Farmer farmer);

    List<Farmer> saveFarmers(List<Farmer> farmers);

    List<Farmer> getAllFarmers();

    Farmer getFarmerById(Integer id) throws Exception;

    String deleteFarmer(Integer id);

    Farmer updateFarmer(Farmer farmer);

}


