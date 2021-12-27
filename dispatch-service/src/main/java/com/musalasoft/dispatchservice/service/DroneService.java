package com.musalasoft.dispatchservice.service;

import java.util.List;

import com.musalasoft.dispatchservice.model.dto.DroneDto;
import com.musalasoft.dispatchservice.model.dto.LoadMedicationDto;
import com.musalasoft.dispatchservice.model.dto.MedicationDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;

public interface DroneService {
    Long register(RegisterDroneDto registerDroneDto);
    void load(LoadMedicationDto loadMedicationDto);
    List<MedicationDto> getMedications(long droneId);
    List<DroneDto> getAvailableDrones();
    double getBatteryLevel(long droneId);
}
