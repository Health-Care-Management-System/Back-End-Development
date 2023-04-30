package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Patient_Repository extends JpaRepository<Patient,Long> {

}
