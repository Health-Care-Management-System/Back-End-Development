package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.entity.hospital.Hospital;
import com.example.BackEndDevelopment.repository.DoctorInvitation_Repository;
import com.example.BackEndDevelopment.repository.Hospital_Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Hospital_Service {

    @Autowired
    private Hospital_Repository hospital_repository;
    @Autowired
    private DoctorInvitation_Repository doctorInvitationRepository;

    public void saveHospital(Hospital hospital){
        hospital_repository.save(hospital);
    }

    public void sendInvitation(Long hospitalId , Doctor_Invitation doctor_invitation){
        Optional<Hospital> hospital = hospital_repository.findById(hospitalId);
        if (!hospital.isPresent()){
            throw new RuntimeException("Hospital not found");
        }
        doctor_invitation.setHospital(hospital.get());
        doctorInvitationRepository.save(doctor_invitation);
    }

}

