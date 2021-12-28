package com.musalasoft.dispatchservice.api;

import javax.validation.Valid;

import com.musalasoft.dispatchservice.model.dto.LoadMedicationDto;
import com.musalasoft.dispatchservice.model.dto.NewMedicationDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.service.DroneService;
import com.musalasoft.dispatchservice.service.MedicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO Audit Log
// Add auditable timestamps
// Logger
// Unit tests
// Ensure all validations are done
// Job to check battery
// Seeder
// Validate DroneModel Enum properly

@RestController
@RequestMapping("/api/dispatch/")
public class DispatchController {

    private final DroneService droneService;
    private final MedicationService medicationService;

    @Autowired
    public DispatchController(DroneService droneService, MedicationService medicationService) {
        this.droneService = droneService;
        this.medicationService = medicationService;
    }

    @PostMapping(path = "register-drone", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> registerDrone(@RequestBody @Valid RegisterDroneDto registerDroneDto) {
        return droneService.register(registerDroneDto);
    }

    @PostMapping(path = "load-drone", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> loadDrone(@RequestBody @Valid LoadMedicationDto loadMedicationDto) {
        return droneService.load(loadMedicationDto);
    }

    @GetMapping(path = "medications/{droneId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> fetchMedications(@PathVariable("droneId") long droneId) {
        return droneService.getMedications(droneId);
    }

    @GetMapping(path = "available-drones", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> getAvailableDrones() {
        return droneService.getAvailableDrones();
    }

    @GetMapping(path = "battery-level/{droneId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> getBatteryLevel(@PathVariable("droneId") long droneId) {
        return droneService.getBatteryLevel(droneId);
    }

    @PostMapping(path = "create-medication", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response<?> createMedication(@RequestBody @Valid NewMedicationDto medicationDto) {
        return medicationService.add(medicationDto);
    }

}
