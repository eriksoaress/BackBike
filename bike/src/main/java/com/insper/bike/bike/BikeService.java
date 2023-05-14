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
        bike.setStatusOccupation(BikeStatusOccupation.AVAILABLE);
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

    public BikeReturnDTO editStatusUtilBike(Integer id){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        if (bikeBD.isPresent()){
            if (bikeBD.get().getStatusUtil().equals(BikeStatusUtil.MAINTENANCE)){
                bikeBD.get().setStatusUtil(BikeStatusUtil.WORKING);
            }else {
                bikeBD.get().setStatusUtil(BikeStatusUtil.MAINTENANCE);
            }
            Bike bike = bikeRepository.save(bikeBD.get());
            return BikeReturnDTO.convert(bike);
        }
        return null;
    }

    public BikeReturnDTO getBike(Integer id){
        Optional <Bike> bikeBD = bikeRepository.findById(id);
        Bike bike = bikeBD.get();
        return BikeReturnDTO.convert(bike);
    }
    public BikeReturnDTO editStatusOcupBike(Integer id){
        Optional<Bike> bikeBD = bikeRepository.findById(id);
        if (bikeBD.isPresent()){
            if (bikeBD.get().getStatusOccupation().equals(BikeStatusOccupation.AVAILABLE)){
                bikeBD.get().setStatusOccupation(BikeStatusOccupation.UNAVAILABLE);
            }else {
                bikeBD.get().setStatusOccupation(BikeStatusOccupation.AVAILABLE);
            }
            Bike bike = bikeRepository.save(bikeBD.get());
            return BikeReturnDTO.convert(bike);
        }
        return null;
    }

    public BikeApiIntegrationReturnDTO getAvailableBike(){
        List<Bike> bikes = bikeRepository.findAll();
        if (bikes.size() > 0){
            for (Bike bike: bikes){
                if (bike.getStatusUtil().equals(BikeStatusUtil.WORKING)  & bike.getStatusOccupation().equals(BikeStatusOccupation.AVAILABLE)){
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
