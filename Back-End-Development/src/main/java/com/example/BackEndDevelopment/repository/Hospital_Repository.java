package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hospital_Repository extends JpaRepository< Hospital , Long> {


}
