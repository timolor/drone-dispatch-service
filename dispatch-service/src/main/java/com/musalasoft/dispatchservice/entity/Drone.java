package com.musalasoft.dispatchservice.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musalasoft.dispatchservice.model.enums.DroneModel;
import com.musalasoft.dispatchservice.model.enums.DroneState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "drones")
@AllArgsConstructor
@NoArgsConstructor
public class Drone implements Serializable {
    private static final long serialVersionUID = 4471777119419172871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private DroneModel model;

    private Double weightLimit;
    private Double batteryCapacity;

    @Enumerated(EnumType.STRING)
    private DroneState state;

    @OneToMany(mappedBy = "drone")
    private Set<DroneMedication> droneMedications;

}
