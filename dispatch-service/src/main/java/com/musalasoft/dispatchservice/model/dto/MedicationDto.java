package com.musalasoft.dispatchservice.model.dto;

import lombok.Value;

@Value
public class MedicationDto {
    private Long id;
    private String name;
    private double weight;
    private String code;
    private String imageUrl;
}
