package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "airCompany", cascade = CascadeType.ALL)
    private List<Airplane> airplanes = new ArrayList<>();

    public void addAirplane(Airplane airplane){
        this.airplanes.add(airplane);
        airplane.setAirCompany(this);
    }

    public void removeAirplane(Airplane airplane){
        this.airplanes.remove(airplane);
        airplane.setAirCompany(null);
    }
}
