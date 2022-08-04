package com.infosys.example.springbootexample.model.response;

import com.infosys.example.springbootexample.entities.ProductType;
import com.infosys.example.springbootexample.entities.RingFeature;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
public class ProductResponse {

    String productName;
    String size;
    String diameter;

    @Enumerated(EnumType.STRING)
    ProductType productType;

    @Enumerated(EnumType.STRING)
    RingFeature ringFeature;

    List <ProdSpecResponse> prodSpecResponse;

    SupplierResponse supplierResponse;

    ProdPriceResponse prodPriceResponse;

    List<ProductFeatureResponse>  productFeatureResponse;


}
