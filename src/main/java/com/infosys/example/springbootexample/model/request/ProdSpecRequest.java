package com.infosys.example.springbootexample.model.request;

import lombok.Data;

@Data
public class ProdSpecRequest {
    Long prod_specId;
    String color;
    String model;
}

