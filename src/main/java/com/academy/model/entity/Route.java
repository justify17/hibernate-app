package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "id_departure")
    private Integer idDeparture;
    @Column(name = "id_arrival")
    private Integer idArrival;

//    private List<Airplane> airplanes;
}
