package com.insper.bike.bike;

import com.insper.bike.bike.dto.BikeReturnDTO;
import com.insper.bike.bike.dto.SaveBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    }}
