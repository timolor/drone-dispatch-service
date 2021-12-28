package com.musalasoft.dispatchservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.musalasoft.dispatchservice.entity.Drone;
import com.musalasoft.dispatchservice.entity.DroneMedication;
import com.musalasoft.dispatchservice.entity.Medication;
import com.musalasoft.dispatchservice.exception.MusalaResourceNotFoundException;
import com.musalasoft.dispatchservice.model.dto.DroneDto;
import com.musalasoft.dispatchservice.model.dto.LoadMedicationDto;
import com.musalasoft.dispatchservice.model.dto.MedicationDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;
import com.musalasoft.dispatchservice.model.enums.DroneState;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.model.response.ResponseCodes;
import com.musalasoft.dispatchservice.respository.DroneMedicationRepository;
import com.musalasoft.dispatchservice.respository.DroneRepository;
import com.musalasoft.dispatchservice.respository.MedicationRepository;
import com.musalasoft.dispatchservice.service.DroneService;
import com.musalasoft.dispatchservice.shared.CollectionUtils;
import com.musalasoft.dispatchservice.shared.converters.DroneConverter;
import com.musalasoft.dispatchservice.shared.converters.MedicationConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroneServiceImpl implements DroneService {

    private final DroneRepository droneRepository;
    private final MedicationRepository medicationRepository;
    private final DroneMedicationRepository droneMedicationRepository;
    private final DroneConverter droneConverter;
    private final MedicationConverter medicationConverter;

    @Autowired
    public DroneServiceImpl(
            DroneRepository droneRepository,
            MedicationRepository medicationRepository,
            DroneMedicationRepository droneMedicationRepository,
            DroneConverter droneConverter,
            MedicationConverter medicationConverter) {
        this.droneRepository = droneRepository;
        this.medicationRepository = medicationRepository;
        this.droneMedicationRepository = droneMedicationRepository;
        this.droneConverter = droneConverter;
        this.medicationConverter = medicationConverter;
    }

    @Override
    public Response<Long> register(RegisterDroneDto registerDroneDto) {
        Drone drone = droneConverter.mapToEntity(registerDroneDto);
        drone = droneRepository.save(drone);

        return Response.build(drone.getId());
    }

    @Override
    public Response<List<DroneMedication>> load(LoadMedicationDto loadMedicationDto) {
        List<DroneMedication> droneMedications = new ArrayList<>();

        Drone drone = getDroneById(loadMedicationDto.getDroneId());
        List<Medication> medications = medicationRepository.findAll();
        loadMedicationDto.medications.forEach(it -> {
            Optional<Medication> optionalMedication = medications.stream().filter(p -> p.getId().equals(it))
                    .findFirst();
            if (!optionalMedication.isPresent())
                return;

            DroneMedication droneMedication = new DroneMedication();
            droneMedication.setDrone(drone);
            droneMedication.setMedication(optionalMedication.get());
            droneMedication.setActive(true);

            droneMedications.add(droneMedication);
        });

        List<DroneMedication> resp = droneMedicationRepository.saveAll(droneMedications);

        drone.setState(DroneState.LOADED);
        droneRepository.save(drone);

        return Response.build(resp);
    }

    @Override
    public Response<List<MedicationDto>> getMedications(long droneId) {
        Drone drone = getDroneById(droneId);
        List<DroneMedication> droneMedications = droneMedicationRepository.findByDroneAndActiveTrue(drone);
        if (droneMedications.isEmpty())
            return Response.build(ResponseCodes.NOT_FOUND.getCode(), ResponseCodes.NOT_FOUND.getMessage(), null);

        List<MedicationDto> medicationDtos = CollectionUtils.mapToList(droneMedications,
                entitity -> medicationConverter.mapToDto(entitity.getMedication()));

        return Response.build(medicationDtos);
    }

    @Override
    public Response<List<DroneDto>> getAvailableDrones() {
        List<Drone> drones = droneRepository.findByStateIs(DroneState.IDLE.name());
        if (drones.isEmpty())
            return Response.build(ResponseCodes.NOT_FOUND.getCode(), ResponseCodes.NOT_FOUND.getMessage(), null);

        List<DroneDto> droneDtos = CollectionUtils.mapToList(drones, entitity -> droneConverter.mapToDto(entitity));

        return Response.build(droneDtos);
    }

    @Override
    public Response<Double> getBatteryLevel(long droneId) {
        Drone drone = getDroneById(droneId);
        double batteryLevel = drone.getBateryCapacity();

        return Response.build(batteryLevel);
    }

    private Drone getDroneById(long droneId) {
        Optional<Drone> optionalDrone = droneRepository.findById(droneId);
        if (!optionalDrone.isPresent())
            throw new MusalaResourceNotFoundException(String.format("Drone with id %d does not exist", droneId),
                    ResponseCodes.NOT_FOUND.getCode());

        return optionalDrone.get();
    }
}
