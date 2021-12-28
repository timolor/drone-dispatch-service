package com.musalasoft.dispatchservice.model.dto;

import lombok.Data;
import lombok.Value;

@Data
public class MedicationDto {
    private Long id;
    private String name;
    private double weight;
    private String code;
    private String imageUrl;
}
