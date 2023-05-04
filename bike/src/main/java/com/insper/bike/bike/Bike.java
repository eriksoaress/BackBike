package com.insper.bike.bike;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identifier = UUID.randomUUID().toString();
    private String model;
    private String type;
    private Float pricePHour;

    private BikeStatusUtil statusUtil;

    private BikeStatusOccupation statusOccupation;

}
