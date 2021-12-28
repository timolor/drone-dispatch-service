package com.musalasoft.dispatchservice.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoadMedicationDto {
    public Long droneId;
    public List<Long> medications;
}
