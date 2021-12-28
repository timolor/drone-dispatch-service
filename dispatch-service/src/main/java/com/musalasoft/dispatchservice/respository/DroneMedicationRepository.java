package com.musalasoft.dispatchservice.respository;

import java.util.List;

import com.musalasoft.dispatchservice.entity.Drone;
import com.musalasoft.dispatchservice.entity.DroneMedication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneMedicationRepository extends JpaRepository<DroneMedication, Long> {
    List<DroneMedication> findByDroneAndActiveTrue(Drone drone);
}
