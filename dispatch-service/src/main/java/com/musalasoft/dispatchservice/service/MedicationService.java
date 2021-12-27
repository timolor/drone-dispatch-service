package com.musalasoft.dispatchservice.service;

import com.musalasoft.dispatchservice.model.dto.NewMedicationDto;
import com.musalasoft.dispatchservice.model.response.Response;

public interface MedicationService {
    Response<Long> add(NewMedicationDto newMedicationDto);
}
