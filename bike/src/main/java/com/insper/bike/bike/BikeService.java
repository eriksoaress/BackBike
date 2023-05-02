package com.insper.bike.bike;

import com.insper.bike.bike.dto.BikeReturnDTO;
import com.insper.bike.bike.dto.EditBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public Bike saveBike(Bike bike){
        return  null;
    }

    public BikeReturnDTO editBike(String identifier, EditBikeDTO editBikeDTO){
        Bike bikeBD = bikeRepository.findByBikeIdentifier(identifier);

        bikeBD.setModel(editBikeDTO.getModel());
        bikeBD.setType(editBikeDTO.getType());
        bikeBD.setPrice_p_hour(editBikeDTO.getPrice_p_hour());

        Bike bike = bikeRepository.save(bikeBD);
        return BikeReturnDTO.covert(bike);

    }

}
