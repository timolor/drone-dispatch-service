package com.musalasoft.dispatchservice.respository;

import java.util.List;

import com.musalasoft.dispatchservice.entity.Drone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findByStateIs(String state);
}
