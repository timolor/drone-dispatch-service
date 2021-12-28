package com.musalasoft.dispatchservice.model.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RegisterDroneDto {
    @NotBlank(message = "serial number is required")
    @Size(min = 2, message = "Min 2 characters is required for serial number")
    @Size(max = 100, message = "Max 100 characters is allowed for serial number")
    private String serialNumber;
    private String model;
    @DecimalMin(value = "1.0", message = "weight limit must be greater than 1gr")
    @DecimalMax(value = "500.0", message = "weight limit must not be greater than 500gr")
    private double weightLimit;
    @DecimalMin(value = "1.0", message = "battery capacity must be greater than 1%")
    @DecimalMax(value = "100.0", message = "battery capacity must not be greater than 100%")
    private double batteryCapacity;
}