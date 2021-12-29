package com.musalasoft.dispatchservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneDto {
    private Long id;
    private String serialNumber;
    private String model;
    private Double weightLimit;
    private Double batteryCapacity;
}
