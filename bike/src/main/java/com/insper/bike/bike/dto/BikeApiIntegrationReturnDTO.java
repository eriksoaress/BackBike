package com.insper.bike.bike.dto;

import com.insper.bike.bike.Bike;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeApiIntegrationReturnDTO {
    private Integer id;
    private Float pricePHour;
    private String model;
    private String type;

    public static BikeApiIntegrationReturnDTO convert(Bike bike){
        BikeApiIntegrationReturnDTO bikeApiIntegrationReturnDTO = new BikeApiIntegrationReturnDTO();
        bikeApiIntegrationReturnDTO.id = bike.getId();
        bikeApiIntegrationReturnDTO.pricePHour = bike.getPricePHour();
        bikeApiIntegrationReturnDTO.model = bike.getModel();
        bikeApiIntegrationReturnDTO.type = bike.getType();
        return bikeApiIntegrationReturnDTO;
    }
}
