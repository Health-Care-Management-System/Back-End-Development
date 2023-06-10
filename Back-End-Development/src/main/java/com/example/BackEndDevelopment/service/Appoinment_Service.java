package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Appointments;
import com.example.BackEndDevelopment.entity.hospital.Hospital;
import com.example.BackEndDevelopment.repository.AppoinmentRepository;
import com.example.BackEndDevelopment.repository.Hospital_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Appoinment_Service {

    @Autowired
    private AppoinmentRepository appoinmentRepository;

    @Autowired
    private Hospital_Repository hospitalRepository;

    public List<Appointments> getAppoinments(){
        return (List<Appointments>) appoinmentRepository.findAll();
    }

    public List<Appointments> getAppoinmentDetails(){
        //Long hospitalid = JwtRequestFilter.CURRENT_USER;
       // Hospital hospital = hospitalRepository.findById(hospitalid).get();
        Hospital hospital = hospitalRepository.findById(2L).get();
//        Hospital hospital = null;
        return appoinmentRepository.findByHospital(hospital);
    }


}
