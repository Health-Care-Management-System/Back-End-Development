package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.entity.hospital.HospitalDoctorId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorInvitation_Repository extends JpaRepository<Doctor_Invitation , HospitalDoctorId> {
    List<Doctor_Invitation> findByIdDoctorId(Long doctorId);
    List<Doctor_Invitation> findByIdHospitalId(Long hospitalId);
}
