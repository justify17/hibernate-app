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
    @Column
    private int idDeparture;
    @Column
    private int idArrival;

    private List<Airplane> airplanes;
}
