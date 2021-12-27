package com.musalasoft.dispatchservice.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class DroneMedicationKey implements Serializable {
    private Long droneId;
    private Long medicationId;
}
