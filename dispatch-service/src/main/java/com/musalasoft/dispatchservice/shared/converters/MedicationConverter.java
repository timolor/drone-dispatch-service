package com.musalasoft.dispatchservice.shared.converters;

import com.musalasoft.dispatchservice.entity.Medication;
import com.musalasoft.dispatchservice.model.dto.MedicationDto;
import com.musalasoft.dispatchservice.model.dto.NewMedicationDto;

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

    public Medication mapToEntity(final NewMedicationDto newMedicationDto){
        Medication medication = new Medication();
        medication.setCode(newMedicationDto.getCode());
        medication.setName(newMedicationDto.getName());
        medication.setImageUrl(newMedicationDto.getImageUrl());
        medication.setWeight(newMedicationDto.getWeight());
        
        return medication;
    }
}
