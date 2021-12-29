package com.musalasoft.dispatchservice.model.dto;

import javax.validation.constraints.DecimalMax;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateDroneBatteryDto {
    private Long droneId;

    @DecimalMax(value = "100.0", message = "battery level must not be greater than 100%")
    private Double batteryLevel;
}