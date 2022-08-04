package com.infosys.example.springbootexample.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name ="price")
public class ProdPriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long priceId;
    Double wholesalePrice;
    Double sellingPrice;
    Double costPrice;


}

