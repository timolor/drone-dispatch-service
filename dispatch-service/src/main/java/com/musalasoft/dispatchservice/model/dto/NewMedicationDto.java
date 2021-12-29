package com.musalasoft.dispatchservice.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewMedicationDto {
    @NotBlank(message = "name is required")
    @Pattern(regexp="^[a-zA-Z0-9]+(?:-[a-zA-Z0-9]+)*+(?:_[a-zA-Z0-9]+)*$",message="Only letters, numbers, ‘-‘, ‘_’ are allowed")  
    private String name;
    private Double weight;
    @NotBlank(message = "code is required")
    @Pattern(regexp="^[A-Z0-9]+(?:_[A-Z0-9]+)*$",message="Only upper case letters, underscore and numbers are allowed")
    private String code;
    private String imageUrl;
}
