package com.musalasoft.dispatchservice.model.dto;

import lombok.Data;

@Data
public class MedicationDto {
    private Long id;
    private String name;
    private double weight;
    private String code;
    private String imageUrl;
}
