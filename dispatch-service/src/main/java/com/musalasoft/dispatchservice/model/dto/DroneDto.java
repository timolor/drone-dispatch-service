package com.musalasoft.dispatchservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneDto {
    private long id;
    private String serialNumber;
    private String model;
    private double weightLimit;
    private double batteryCapacity;
}
