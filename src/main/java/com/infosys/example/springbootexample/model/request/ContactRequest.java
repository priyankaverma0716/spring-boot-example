package com.infosys.example.springbootexample.model.request;

import com.infosys.example.springbootexample.entities.Address;
import lombok.Data;

import javax.validation.constraints.Email;
import java.util.List;

@Data
public class ContactRequest {

    Long id;
    String name;
    String rollNo;

    @Email(message="Email must be valid")
    String email;
    private List<AddressRequest> addresses;
    private PhoneRequest phoneRequest;

}
