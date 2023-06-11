package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.entity.hospital.Hospital;
import com.example.BackEndDevelopment.repository.DoctorInvitation_Repository;
import com.example.BackEndDevelopment.repository.Doctor_Repository;
import com.example.BackEndDevelopment.repository.Hospital_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorInvitationService {

    @Autowired
    private DoctorInvitation_Repository doctorInvitationRepository;

    @Autowired
    private Doctor_Repository doctorRepository;

    @Autowired
    private Hospital_Repository hospitalRepository;

    public Doctor_Invitation addToInvitationList(String doctorId){
        Doctor doctor = doctorRepository.findById(doctorId).get();
       // String hospitalid = JwtRequestFilter.CURRENT_USER;

        Hospital hospital = null;
//        if (hospitalid != null){
//            Hospital hospital = hospitalRepository.findById(hospitalid).get();
//        }

        if (doctor != null && hospital!=null){
            Doctor_Invitation doctor_invitation = new Doctor_Invitation(hospital , doctor);
            return doctorInvitationRepository.save(doctor_invitation);
        }
        return null;
    }

    public List<Doctor_Invitation> getInvitationDetails(){
        //String doc_id = JwtRequestFilter.CURRENT_USER;
       // Doctor doctor = DoctorRepository.findById(doc_id).get();
        //Doctor doctor = null;

        String doc_id ="doc1";
        Doctor doctor = doctorRepository.findById(doc_id).get();
        return doctorInvitationRepository.findByDoctor(doctor);
    }
}