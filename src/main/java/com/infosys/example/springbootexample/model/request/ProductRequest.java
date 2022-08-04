package com.infosys.example.springbootexample.model.request;

import com.infosys.example.springbootexample.entities.Clarity;
import com.infosys.example.springbootexample.entities.Cut;
import com.infosys.example.springbootexample.entities.Shape;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProductRequest {

    String productName;
    String size;
    String diameter;
    String productType;
    String shape;
    String ringFeature;
    ProdPriceRequest prodPriceRequest;
    private List<ProdSpecRequest> prodSpecRequest;
    private List<ProductFeatureRequest> productFeatureRequests;
    SupplierRequest supplierRequest;


    @Enumerated(EnumType.STRING)
    Shape shape1;
    @Enumerated(EnumType.STRING)
    Clarity clarity;

    @Enumerated(EnumType.STRING)
    Cut cut;


}
