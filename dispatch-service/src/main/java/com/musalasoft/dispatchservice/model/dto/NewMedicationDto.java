package com.musalasoft.dispatchservice.model.dto;

import javax.validation.constraints.Pattern;

import lombok.Value;

@Value
public class NewMedicationDto {
    @Pattern(regexp="^[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*+(?:_[a-zA-Z0-9]+)*$",message="Only letters, numbers, ‘-‘, ‘_’ are allowed")  
    private String name;
    private double weight;
    @Pattern(regexp="^[A-Z0-9]+(?:_[A-Z0-9]+)*$",message="Only upper case letters, underscore and numbers are allowed")
    private String code;
    private String imageUrl;
}
