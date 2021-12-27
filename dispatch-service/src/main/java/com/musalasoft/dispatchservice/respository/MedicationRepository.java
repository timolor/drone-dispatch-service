package com.musalasoft.dispatchservice.respository;

import com.musalasoft.dispatchservice.entity.Medication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
