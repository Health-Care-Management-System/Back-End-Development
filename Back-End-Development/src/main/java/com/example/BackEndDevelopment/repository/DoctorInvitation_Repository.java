package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.entity.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DoctorInvitation_Repository extends JpaRepository< Doctor_Invitation , Integer> {
    public List<Doctor_Invitation> findByDoctor(Doctor doctor);
}
