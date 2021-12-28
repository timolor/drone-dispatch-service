package com.musalasoft.dispatchservice.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "medications")
@NoArgsConstructor
@AllArgsConstructor
public class Medication implements Serializable {
    private static final long serialVersionUID = 4471777119419172872L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    private Double weight;
    private String code;
    private String imageUrl;

    @OneToMany(mappedBy = "medication")
    private Set<DroneMedication> droneMedications;
}
