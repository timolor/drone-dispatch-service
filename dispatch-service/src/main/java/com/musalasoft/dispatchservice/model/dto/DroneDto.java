package com.musalasoft.dispatchservice.model.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DroneDto {
    private long id;

    @Size(min = 2, message = "Min 2 characters is required")
    @Size(max = 100, message = "Max 100 characters is allowed")
    private String serialNumber;
    private String model;

    @DecimalMin("0.0")
    @DecimalMax("500.0")
    private double weightLimit;
    private double batteryCapacity;
}
