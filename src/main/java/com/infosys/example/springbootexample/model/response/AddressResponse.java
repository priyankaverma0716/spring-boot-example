package com.infosys.example.springbootexample.model.response;

import lombok.Data;

@Data

public class AddressResponse {
    private Long personId;
    private String country;
    private String countryCode;
    private String type;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String addressLine4;
    private String city;
    private String region;
    private String state;
    private String postalCode;
    private String formattedAddress;
    private String isPrimary;
    private String citizenship;

}
