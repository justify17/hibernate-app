package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany(mappedBy = "routes")
    private List<Airplane> airplanes = new ArrayList<>();

    public void addAirplane(Airplane airplane){
        this.airplanes.add(airplane);
        airplane.getRoutes().add(this);
    }

    public void removeAirplane(Airplane airplane){
        this.airplanes.remove(airplane);
        airplane.getRoutes().remove(this);
    }
}
