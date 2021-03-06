package com.musalasoft.dispatchservice.shared.converters;

import com.musalasoft.dispatchservice.entity.Drone;
import com.musalasoft.dispatchservice.model.dto.DroneDto;
import com.musalasoft.dispatchservice.model.dto.RegisterDroneDto;
import com.musalasoft.dispatchservice.model.enums.DroneState;

import org.springframework.stereotype.Component;

@Component
public class DroneConverter {
    
    public Drone mapToEntity(final RegisterDroneDto registerDroneDto){
        Drone drone = new Drone();
        drone.setBatteryCapacity(registerDroneDto.getBatteryCapacity());
        drone.setModel(registerDroneDto.getModel());
        drone.setWeightLimit(registerDroneDto.getWeightLimit());
        drone.setSerialNumber(registerDroneDto.getSerialNumber());
        drone.setState(DroneState.IDLE);

        return drone;
    }

    public DroneDto mapToDto(final Drone drone){
        DroneDto droneDto = new DroneDto();
        droneDto.setId(drone.getId());
        droneDto.setSerialNumber(drone.getSerialNumber());
        droneDto.setModel(drone.getModel().name());
        droneDto.setWeightLimit(drone.getWeightLimit());
        droneDto.setBatteryCapacity(drone.getBatteryCapacity());
        
        return droneDto;
    }
}