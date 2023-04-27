package com.insper.bike.bike;

import jakarta.persistence.Entity;

@Entity
public class Bike {
    private String modelo;
    private String tipo;
    private Float preco_por_hora;

}
