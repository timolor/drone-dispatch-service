package com.musalasoft.dispatchservice.shared.converters;

import com.musalasoft.dispatchservice.entity.Medication;
import com.musalasoft.dispatchservice.model.dto.MedicationDto;

import org.springframework.stereotype.Component;

@Component
public class MedicationConverter {

    public MedicationDto mapToDto(final Medication medication) {
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setId(medication.getId());
        medicationDto.setName(medication.getName());
        medicationDto.setCode(medication.getCode());
        medicationDto.setImageUrl(medication.getImageUrl());
        medicationDto.setWeight(medication.getWeight());

        return medicationDto;
    }
}
