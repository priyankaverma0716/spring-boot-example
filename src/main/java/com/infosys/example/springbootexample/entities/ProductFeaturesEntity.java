package com.infosys.example.springbootexample.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_Features")
public class ProductFeaturesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prod_feature_id")
    Long prodFeatureId;
    String color;
    String metal;
   // String shape;
    Float carat;
    @Enumerated(EnumType.STRING)
    Shape shape1;
    @Enumerated(EnumType.STRING)
    Clarity clarity;

    @Enumerated(EnumType.STRING)
    Cut cut;




}
