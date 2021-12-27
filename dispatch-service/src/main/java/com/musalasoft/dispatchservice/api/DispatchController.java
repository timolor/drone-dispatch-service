package com.musalasoft.dispatchservice.api;

import javax.validation.Valid;

import com.musalasoft.dispatchservice.model.dto.NewMedicationDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.service.DroneService;
import com.musalasoft.dispatchservice.service.MedicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dispatch")
public class DispatchController {
    
    private final DroneService droneService;
    private final MedicationService medicationService;

    @Autowired
    public DispatchController(DroneService droneService, MedicationService medicationService){
        this.droneService = droneService;
        this.medicationService = medicationService;
    }

    public Response<?> registerDrone(@RequestBody @Valid RegisterDroneDto registerDroneDto){
        return droneService.register(registerDroneDto);
    }


    public Response<?> createMedication(@RequestBody @Valid NewMedicationDto medicationDto){
        return medicationService.add(medicationDto);
    }

}
