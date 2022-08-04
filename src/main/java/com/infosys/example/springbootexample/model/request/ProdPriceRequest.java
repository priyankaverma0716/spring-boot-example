package com.infosys.example.springbootexample.model.request;


import lombok.Data;

@Data
public class ProdPriceRequest {
    Long id;
    Double wholesalePrice;
    Double sellingPrice;
    Double costPrice;
}
