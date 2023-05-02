package com.insper.bike.bike;

import com.insper.bike.bike.dto.BikeReturnDTO;
import com.insper.bike.bike.dto.EditBikeDTO;
import com.insper.bike.bike.dto.EditStatusBikeDTO;
import com.insper.bike.bike.dto.SaveBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return BikeReturnDTO.covert(bike);
    }

    public BikeReturnDTO editBike(Integer id, EditBikeDTO editBikeDTO){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        if (bikeBD.isPresent()) {
            bikeBD.get().setModel(editBikeDTO.getModel());
            bikeBD.get().setType(editBikeDTO.getType());
            bikeBD.get().setPrice_p_hour(editBikeDTO.getPrice_p_hour());

            Bike bike = bikeRepository.save(bikeBD.get());
            return BikeReturnDTO.covert(bike);
        }
        return null;
    }

    public BikeReturnDTO editStatusBike(Integer id, EditStatusBikeDTO editStatusBikeDTO){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        if (bikeBD.isPresent()){
            bikeBD.get().setStatus_util(editStatusBikeDTO.getStatus_util());

            Bike bike = bikeRepository.save(bikeBD.get());
            return BikeReturnDTO.covert(bike);
        }
        return null;
    }


}
