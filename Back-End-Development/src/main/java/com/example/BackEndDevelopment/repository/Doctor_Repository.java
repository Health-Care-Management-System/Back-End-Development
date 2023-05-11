package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Doctor_Repository extends JpaRepository<Doctor,Long>{

    Optional<Doctor> findByEmail(String email);
    //the use of optinal is a way to indicate that the returned value may be null.
    // It is used as a container object to potentially wrap a non-null value and indicate whether a value is present or not.

}