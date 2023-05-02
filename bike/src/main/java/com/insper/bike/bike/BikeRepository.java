package com.insper.bike.bike;

import com.insper.bike.bike.dto.BikeReturnDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike,Integer> {
    Page<Bike> findByStatusUtil(BikeStatusUtil statusUtil, Pageable pageable);
    Bike findByIdentifier(String identifier);
}
