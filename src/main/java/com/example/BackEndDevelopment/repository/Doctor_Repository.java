package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Doctor_Repository extends JpaRepository<Doctor,String>{

}