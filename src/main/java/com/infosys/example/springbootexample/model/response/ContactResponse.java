package com.infosys.example.springbootexample.model.response;

import com.infosys.example.springbootexample.entities.Address;
import lombok.Data;

import java.util.List;

@Data
public class ContactResponse {

    Long id;
    String name;
    String rollNo;
    private List<AddressResponse> addresses;
    private PhoneResponse phoneResponse;


}
