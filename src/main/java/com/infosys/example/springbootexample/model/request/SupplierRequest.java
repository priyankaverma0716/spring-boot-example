package com.infosys.example.springbootexample.model.request;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
public class SupplierRequest {
    Long supplierId;

    String supplierName;
    String org;
    String email;
    String phoneNumber;


}
