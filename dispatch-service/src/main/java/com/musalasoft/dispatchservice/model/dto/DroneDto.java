package com.musalasoft.dispatchservice.model.dto;

import lombok.Value;

@Value
public class DroneDto {
    private long id;
    private String serialNumber;
    private String model;
    private double weightLimit;
    private double batteryCapacity;
}
