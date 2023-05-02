package com.insper.bike.bike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public Bike saveBike(Bike bike){
        return  null;
    }

}
