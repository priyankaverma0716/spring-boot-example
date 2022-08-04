package com.infosys.example.springbootexample.repositories;


import com.infosys.example.springbootexample.entities.ERole;
import com.infosys.example.springbootexample.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(ERole name);
    }

