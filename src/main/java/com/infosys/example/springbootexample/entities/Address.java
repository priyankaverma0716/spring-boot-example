package com.infosys.example.springbootexample.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "person_id")
    private Long personId;

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "type")
    private String type;

    @Column(name = "address_line_1")
    private String addressLine1;

    @Column(name = "address_line_2")
    private String addressLine2;

    @Column(name = "address_line_3")
    private String addressLine3;

    @Column(name = "address_line_4")
    private String addressLine4;

    @Column(name = "city")
    private String city;

    @Column(name = "region")
    private String region;

    @Column(name = "state")
    private String state;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "formatted_address")
    private String formattedAddress;

    @Column(name = "is_primary")
    private String isPrimary;

    @Column(name = "citizenship")
    private String citizenship;

//    @Column(name="created_at")
//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
//    private Date createdAt;
//
//    @Column(name="updated_at")
//    @UpdateTimestamp
//    @Temporal(TemporalType.DATE)
//    private Date updatedAt;

}
