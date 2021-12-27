package com.musalasoft.dispatchservice.respository;

import com.musalasoft.dispatchservice.entity.Drone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {

}
