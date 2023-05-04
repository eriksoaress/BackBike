package com.insper.bike.bike;

import com.insper.bike.bike.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public BikeReturnDTO saveBike(SaveBikeDTO saveBikeDTO){

        Bike bike = new Bike();
        bike.setModel(saveBikeDTO.getModel());
        bike.setType(saveBikeDTO.getType());
        bike.setPricePHour(saveBikeDTO.getPricePHour());
        bike.setStatusOcupation(BikeStatusOcupation.AVAILABLE);
        bike.setStatusUtil(BikeStatusUtil.WORKING);
        bikeRepository.save(bike);
        return BikeReturnDTO.convert(bike);
    }

    public Page<BikeReturnDTO> listBikes(BikeStatusUtil bikeStatusUtil, Pageable pageable){
        if (bikeStatusUtil != null){
            Page<Bike> bikes = bikeRepository.findByStatusUtil(bikeStatusUtil, pageable);
            return bikes.map(bike -> BikeReturnDTO.convert(bike));
        }
        Page<Bike> bikes = bikeRepository.findAll(pageable);
        return bikes.map(bike -> BikeReturnDTO.convert(bike));
    }

    public BikeReturnDTO editBike(Integer id, EditBikeDTO editBikeDTO){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        if (bikeBD.isPresent()) {
            bikeBD.get().setModel(editBikeDTO.getModel());
            bikeBD.get().setType(editBikeDTO.getType());
            bikeBD.get().setPricePHour(editBikeDTO.getPricePHour());

            Bike bike = bikeRepository.save(bikeBD.get());
            return BikeReturnDTO.convert(bike);
        }
        return null;
    }

    public BikeReturnDTO editStatusBike(Integer id, EditStatusBikeDTO editStatusBikeDTO){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        if (bikeBD.isPresent()){
            if (editStatusBikeDTO.getStatusUtil() != null){bikeBD.get().setStatusUtil(editStatusBikeDTO.getStatusUtil());}
            if (editStatusBikeDTO.getStatusOcupation() != null){bikeBD.get().setStatusOcupation(editStatusBikeDTO.getStatusOcupation());}

            Bike bike = bikeRepository.save(bikeBD.get());
            return BikeReturnDTO.convert(bike);
        }
        return null;
    }

    public BikeApiIntegrationReturnDTO getAvailableBike(){
        List<Bike> bikes = bikeRepository.findAll();
        if (bikes.size() > 0){
            for (Bike bike: bikes){
                if (bike.getStatusUtil().equals(BikeStatusUtil.WORKING)  & bike.getStatusOcupation().equals(BikeStatusOcupation.AVAILABLE)){
                    return BikeApiIntegrationReturnDTO.convert(bike);
                }
            }
        }
        return null;
    }

    public void deleteBike(Integer id){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        bikeBD.ifPresent(bike -> bikeRepository.delete(bike));
    }
}
