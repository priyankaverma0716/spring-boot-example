package com.infosys.example.springbootexample.model.response;

import lombok.Data;

@Data
public class SupplierResponse {
    Long supplierId;
    String supplierName;
    String org;
    String email;
    String phoneNumber;


}
