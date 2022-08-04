package com.infosys.example.springbootexample.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;

@Data
@Entity

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long supplierId;
    String name;
    String org;
    @Email(message = "please enter correct email id")
    String email;
    String phoneNumber;

}


