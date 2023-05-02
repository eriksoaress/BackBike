package com.insper.bike.bike;

import com.insper.bike.bike.dto.BikeReturnDTO;
import com.insper.bike.bike.dto.EditBikeDTO;
import com.insper.bike.bike.dto.EditStatusBikeDTO;
import com.insper.bike.bike.dto.SaveBikeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    private BikeService bikeService;
    @PostMapping
    public BikeReturnDTO saveBike(@RequestBody SaveBikeDTO bike){
        return bikeService.saveBike(bike);
    }
    @PutMapping("/{id}")
    public BikeReturnDTO editBike(@PathVariable Integer id, @RequestBody EditBikeDTO bike){
        return bikeService.editBike(id, bike);
    }

    @PutMapping("/status/{id}")
    public BikeReturnDTO editStatusBike(@PathVariable Integer id, @RequestBody EditStatusBikeDTO bike){
        return bikeService.editStatusBike(id, bike);
    }


}
