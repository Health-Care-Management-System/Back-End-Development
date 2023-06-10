package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Appointments;
import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.entity.hospital.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appointments , Long> {

    public List<Appointments> findByHospital(Hospital hospital);

    public List<Appointments> findByDoctor(Doctor doctor);
}
