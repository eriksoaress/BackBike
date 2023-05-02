package com.insper.bike.bike.dto;

import com.insper.bike.bike.BikeStatusOcupation;
import com.insper.bike.bike.BikeStatusUtil;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EditStatusBikeDTO {
    private BikeStatusUtil statusUtil;
}
