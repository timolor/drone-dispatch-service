package com.musalasoft.dispatchservice.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "drones_medications")
@AllArgsConstructor
@NoArgsConstructor
public class DroneMedication {
    @EmbeddedId
    private DroneMedicationKey id = new DroneMedicationKey(); 

    @ManyToOne
    @MapsId("droneId")
    @JoinColumn(name = "drone_id")
    Drone drone;

    @ManyToOne
    @MapsId("medicationId")
    @JoinColumn(name = "medication_id")
    Medication medication;

    private Boolean active;
}
