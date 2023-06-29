package com.ladera.utcl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TruckModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long truckId;

    private String truckNumber;

}
