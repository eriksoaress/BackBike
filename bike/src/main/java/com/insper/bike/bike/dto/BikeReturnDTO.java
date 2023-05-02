package com.insper.bike.bike.dto;

import com.insper.bike.bike.Bike;
import com.insper.bike.bike.BikeStatusOcupation;
import com.insper.bike.bike.BikeStatusUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeReturnDTO {
    private String model;
    private String type;
    private Float price_p_hour;
    private BikeStatusUtil status_util;
    private BikeStatusOcupation status_ocupation;
    public static BikeReturnDTO covert(Bike bike) {
        BikeReturnDTO bikeReturnDTO = new BikeReturnDTO();
        bikeReturnDTO.setModel(bike.getModel());
        bikeReturnDTO.setType(bike.getType());
        bikeReturnDTO.setPrice_p_hour(bike.getPrice_p_hour());
        bikeReturnDTO.setStatus_util(bike.getStatus_util());
        bikeReturnDTO.setStatus_ocupation(bike.getStatus_ocupation());
        return bikeReturnDTO;
    }
}
