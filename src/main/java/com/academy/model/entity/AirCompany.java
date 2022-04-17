package com.academy.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aircompany")
public class AirCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
