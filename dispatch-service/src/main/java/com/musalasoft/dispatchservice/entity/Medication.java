package com.musalasoft.dispatchservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Medication implements Serializable {
    private static final long serialVersionUID = 4471777119419172872L;

    @Id
    private Long id;
    private String name;
    private double weight;
    private String code;
    private String imageUrl; 
}
