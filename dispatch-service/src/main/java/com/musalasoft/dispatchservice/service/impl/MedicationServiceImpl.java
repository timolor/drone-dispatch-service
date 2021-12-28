package com.musalasoft.dispatchservice.service.impl;

import com.musalasoft.dispatchservice.entity.Medication;
import com.musalasoft.dispatchservice.model.dto.NewMedicationDto;
import com.musalasoft.dispatchservice.model.response.Response;
import com.musalasoft.dispatchservice.respository.MedicationRepository;
import com.musalasoft.dispatchservice.service.MedicationService;
import com.musalasoft.dispatchservice.shared.converters.MedicationConverter;

import org.springframework.stereotype.Service;

@Service
public class MedicationServiceImpl implements MedicationService {

    private final MedicationRepository medicationRepository;
    private final MedicationConverter medicationConverter;

    public MedicationServiceImpl(MedicationRepository medicationRepository, MedicationConverter medicationConverter){
        this.medicationRepository = medicationRepository;
        this.medicationConverter = medicationConverter;
    }


    @Override
    public Response<Long> add(NewMedicationDto newMedicationDto) {
        Medication medication = medicationConverter.mapToEntity(newMedicationDto);
        medication = medicationRepository.save(medication);
        
        return Response.build(medication.getId());
    }
    
}
