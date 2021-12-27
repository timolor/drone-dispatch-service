package com.musalasoft.dispatchservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DroneMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private DroneMedicationKey id;

    @ManyToOne
    @MapsId("droneId")
    @JoinColumn(name = "droneId")
    Drone drone;

    @ManyToOne
    @MapsId("medicationId")
    @JoinColumn(name = "medicationId")
    Medication medication;
}
