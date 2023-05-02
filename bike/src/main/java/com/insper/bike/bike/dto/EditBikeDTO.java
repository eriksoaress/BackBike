package com.insper.bike.bike.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EditBikeDTO {
    private String model;
    private String type;
    private Float price_p_hour;
}
