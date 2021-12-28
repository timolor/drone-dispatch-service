package com.musalasoft.dispatchservice.service;

import java.util.List;

import com.musalasoft.dispatchservice.entity.DroneMedication;
import com.musalasoft.dispatchservice.model.dto.DroneDto;
import com.musalasoft.dispatchservice.model.dto.LoadMedicationDto;
import com.musalasoft.dispatchservice.model.dto.MedicationDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;
import com.musalasoft.dispatchservice.model.response.Response;

public interface DroneService {
    Response<Long> register(RegisterDroneDto registerDroneDto);
    Response<List<DroneMedication>> load(LoadMedicationDto loadMedicationDto);
    Response<List<MedicationDto>> getMedications(long droneId);
    Response<List<DroneDto>> getAvailableDrones();
    Response<Double> getBatteryLevel(long droneId);
}
