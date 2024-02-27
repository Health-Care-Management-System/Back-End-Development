package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.pharmacy.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Prescription_Repository extends JpaRepository<Prescription,String> {

    @Query("SELECT p FROM Prescription p WHERE p.response_state = :status")
    List<Prescription> findByResponseState(String status);


}
