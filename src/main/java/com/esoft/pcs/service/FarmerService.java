package com.esoft.pcs.service;

import com.esoft.pcs.models.Farmer;
import java.util.List;

public interface FarmerService {

    Farmer createFarmer(Farmer farmer);

    List<Farmer> getAllFarmers();

    Farmer getFarmerById(Integer id) throws Exception;

    boolean deleteFarmer(Farmer farmer);

    Farmer updateFarmer(Farmer farmer);
}
