package com.infosys.example.springbootexample.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Phone")
public class Phone
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

        @Column(name="work_no")
        String workNo;

        @Column(name="mobile_no")
        String mobileNo;




}
