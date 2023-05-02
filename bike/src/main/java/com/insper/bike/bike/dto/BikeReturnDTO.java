package com.insper.bike.bike.dto;

import com.insper.bike.bike.Bike;
import com.insper.bike.bike.BikeRepository;
import com.insper.bike.bike.BikeStatusOcupation;
import com.insper.bike.bike.BikeStatusUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeReturnDTO {
    private String model;
    private String type;
    private Float pricePHour;
    private BikeStatusUtil statusUtil;
    private BikeStatusOcupation statusOcupation;


    public static BikeReturnDTO convert(Bike bike) {
        BikeReturnDTO bikeReturnDTO = new BikeReturnDTO();
        bikeReturnDTO.setModel(bike.getModel());
        bikeReturnDTO.setType(bike.getType());
        bikeReturnDTO.setPricePHour(bike.getPricePHour());
        bikeReturnDTO.setStatusUtil(bike.getStatusUtil());
        bikeReturnDTO.setStatusOcupation(bike.getStatusOcupation());
        return bikeReturnDTO;
    }
}
