package com.musalasoft.dispatchservice.service.impl;

import java.util.List;

import com.musalasoft.dispatchservice.model.dto.DroneDto;
import com.musalasoft.dispatchservice.model.dto.LoadMedicationDto;
import com.musalasoft.dispatchservice.model.dto.MedicationDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.service.DroneService;

public class DroneServiceImpl implements DroneService{

    @Override
    public Response<Long> register(RegisterDroneDto registerDroneDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void load(LoadMedicationDto loadMedicationDto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<MedicationDto> getMedications(long droneId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DroneDto> getAvailableDrones() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getBatteryLevel(long droneId) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
