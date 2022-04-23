package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // to complete
    @ManyToOne
    private Route route;

    @OneToOne
    private Order order;

    @Column(name = "passport_data")
    private String passportData;
}
