package com.insper.bike.bike.dto;

import com.insper.bike.bike.Bike;
import com.insper.bike.bike.BikeRepository;
import com.insper.bike.bike.BikeStatusOccupation;
import com.insper.bike.bike.BikeStatusUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeReturnDTO {
    private Integer id;
    private String model;
    private String type;
    private Float pricePHour;
    private BikeStatusUtil statusUtil;
    private BikeStatusOccupation statusOccupation;


    public static BikeReturnDTO convert(Bike bike) {
        BikeReturnDTO bikeReturnDTO = new BikeReturnDTO();
        bikeReturnDTO.setId(bike.getId());
        bikeReturnDTO.setModel(bike.getModel());
        bikeReturnDTO.setType(bike.getType());
        bikeReturnDTO.setPricePHour(bike.getPricePHour());
        bikeReturnDTO.setStatusUtil(bike.getStatusUtil());
        bikeReturnDTO.setStatusOccupation(bike.getStatusOccupation());
        return bikeReturnDTO;
    }
}
