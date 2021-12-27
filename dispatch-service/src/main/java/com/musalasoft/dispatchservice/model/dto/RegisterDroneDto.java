package com.musalasoft.dispatchservice.model.dto;

import lombok.Data;

@Data
public class RegisterDroneDto {
    private String serialNumber;
    private String model;
    private double weightLimit;
    private double batteryCapacity;
}