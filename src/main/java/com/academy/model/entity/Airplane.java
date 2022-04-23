package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_aircompany")
    private AirCompany airCompany;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "airplane_route",
            joinColumns = {@JoinColumn(name = "id_airplane")},
            inverseJoinColumns = {@JoinColumn(name = "id_route")}
    )
    private List<Route> routes = new ArrayList<>();

    public void addRoute(Route route) {
        this.routes.add(route);
        route.getAirplanes().add(this);
    }

    public void removeRoute(Route route) {
        this.routes.remove(route);
        route.getAirplanes().remove(this);
    }
}
