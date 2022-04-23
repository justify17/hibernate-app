package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "airport.order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Integer number;

    @Column(name = "order_date")
    private String orderDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_user")
    private User user;
}
