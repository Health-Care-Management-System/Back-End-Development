package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.hospital.Hospital;
import com.example.BackEndDevelopment.repository.Hospital_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class Hospital_Service {

    @Autowired
    private Hospital_Repository  hospitalRepository;

    public List<Hospital> getHospital() {
        return (List<Hospital>) hospitalRepository.findAll();
    }

    public Hospital getHospitalDetailsById(Long hospitalid){
        return hospitalRepository.findById(hospitalid).get();
    }

    public Hospital updateHospital(Hospital hospital){
       Long hospitalid = hospital.getHospitalid();
       Hospital hsptl = hospitalRepository.findById(hospitalid).get();
       hsptl.setName(hospital.getName());
       hsptl.setEmail(hospital.getEmail());
       hsptl.setRegistrationnumber(hospital.getRegistrationnumber());
       hsptl.setPhonenumber(hospital.getPhonenumber());
       hsptl.setCity(hospital.getCity());
       hsptl.setDistrict(hospital.getDistrict());
       hsptl.setStreet(hospital.getStreet());

       return hospitalRepository.save(hsptl);
    }

    public void deleteHospital(Long hospitalid){
        hospitalRepository.deleteById(hospitalid);
    }
}

