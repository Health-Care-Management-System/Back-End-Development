package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Hospital_Repository extends JpaRepository<Hospital , Long> {

    Optional<Hospital> FindByEmail(String email);

}
