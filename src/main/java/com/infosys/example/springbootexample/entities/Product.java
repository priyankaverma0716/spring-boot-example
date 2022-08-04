package com.infosys.example.springbootexample.entities;

import com.infosys.example.springbootexample.model.response.ProdSpecResponse;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long productId;
    String productName;
    String size;
    String diameter;

    @Enumerated(EnumType.STRING)
    ProductType productType;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    ProdPriceEntity prodPriceEntity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = " prod_spec_id")
    List<ProdSpecfication> prodSpecfication;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = " prod_features_id")
    List<ProductFeaturesEntity> productFeaturesEntity;

    @OneToOne(cascade = CascadeType.ALL)
    Supplier supplier;

    @Enumerated(EnumType.STRING)
    RingFeature ringFeature;



}