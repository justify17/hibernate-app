package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
