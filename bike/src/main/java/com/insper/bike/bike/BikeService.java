package com.insper.bike.bike;

import com.insper.bike.bike.dto.BikeReturnDTO;
import com.insper.bike.bike.dto.SaveBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public BikeReturnDTO saveBike(SaveBikeDTO saveBikeDTO){

        Bike bike = new Bike();
        bike.setModel(saveBikeDTO.getModel());
        bike.setType(saveBikeDTO.getType());
        bike.setPrice_p_hour(saveBikeDTO.getPrice_p_hour());
        bike.setStatus_ocupation(BikeStatusOcupation.AVAILABLE);
        bike.setStatus_util(BikeStatusUtil.WORKING);
        bikeRepository.save(bike);
        return BikeReturnDTO.convert(bike);
    }

}
