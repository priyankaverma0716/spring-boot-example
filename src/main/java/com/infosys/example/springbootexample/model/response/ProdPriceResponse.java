package com.infosys.example.springbootexample.model.response;

import lombok.Data;

@Data
public class ProdPriceResponse {
    Long priceId;
    Double wholesalePrice;
    Double sellingPrice;
    Double costPrice;
}
