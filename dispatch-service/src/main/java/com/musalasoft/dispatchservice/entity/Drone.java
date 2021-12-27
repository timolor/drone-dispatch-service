package com.musalasoft.dispatchservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.musalasoft.dispatchservice.model.enums.DroneModel;
import com.musalasoft.dispatchservice.model.enums.DroneState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Drone implements Serializable {
    private static final long serialVersionUID = 4471777119419172871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private DroneModel model;

    private Double weightLimit;
    private Double bateryCapacity;

    @Enumerated(EnumType.STRING)
    private DroneState state;
}
