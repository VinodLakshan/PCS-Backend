package com.esoft.pcs.service.impl;

import com.esoft.pcs.models.Vehicle;
import com.esoft.pcs.repository.VehicleRepository;
import com.esoft.pcs.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService
{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> GetAllVehicles()
    {
        return vehicleRepository.findAll();
    }
}
