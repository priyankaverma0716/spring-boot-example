package com.infosys.example.springbootexample.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_specification")
public class ProdSpecfication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_spec_id")
    Long prodSpecId;
    String color;
    String model;
}
