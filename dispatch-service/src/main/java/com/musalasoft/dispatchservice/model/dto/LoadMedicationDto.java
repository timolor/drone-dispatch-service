package com.musalasoft.dispatchservice.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class LoadMedicationDto {
    public Long droneId;
    public List<Long> medications;
}
