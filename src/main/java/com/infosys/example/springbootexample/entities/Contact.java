package com.infosys.example.springbootexample.entities;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String rollNo;

    @Email(message = "Email should be valid")
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Address> addresses;


    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private  Phone phone;





}

