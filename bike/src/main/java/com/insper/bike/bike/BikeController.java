package com.insper.bike.bike;

import com.insper.bike.bike.dto.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PutMapping("/{id}/utility")
    public BikeReturnDTO editStatusUtilBike(@PathVariable Integer id){
        return bikeService.editStatusUtilBike(id);
    }

    @PutMapping("/{id}/occupation")
    public BikeReturnDTO editStatusOcupBike(@PathVariable Integer id){
        return bikeService.editStatusOcupBike(id);
    }

    @GetMapping("/available")
    public BikeApiIntegrationReturnDTO getAvailableBike(){
        return bikeService.getAvailableBike();
    }

    @GetMapping("/{id}")
    public BikeReturnDTO getBike(@PathVariable Integer id){
        return bikeService.getBike(id);
    }

    @GetMapping
    public Page<BikeReturnDTO> listBikes(@RequestParam(name = "status",required = false) BikeStatusUtil bikeStatusUtil, Pageable pageable){
        return bikeService.listBikes(bikeStatusUtil,pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteBike(@PathVariable Integer id){
        bikeService.deleteBike(id);
    }
}
