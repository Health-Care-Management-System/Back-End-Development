package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Hospital;
import com.example.BackEndDevelopment.repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HospitalServices {

    @Autowired

    private HospitalRepo hospitalrepo1;
    public Hospital addBLMethod(Hospital hospital){
        return hospitalrepo1.save(hospital);

    }
    public Iterable<Hospital> findAll(){
        return hospitalrepo1.findAll();
    }

    //    public searchdemo findById(Integer id){
//        return searchrepo1.getById(id);
//    }
    public Optional<Hospital> findById(Integer id){
        return hospitalrepo1.findById(id);
    }

    public Hospital update(Integer id, Hospital newHospital){
        Optional<Hospital> HospitalOptional = hospitalrepo1.findById(id);
        if (HospitalOptional.isPresent()){
            Hospital existingHospital = HospitalOptional.get();
            existingHospital.setName(newHospital.getName());
            existingHospital.setCity(newHospital.getCity());
            existingHospital.setDistrict(newHospital.getDistrict());
            existingHospital.setHospital(newHospital.getHospital());

            existingHospital.sethImage(newHospital.gethImage());
            return hospitalrepo1.save(existingHospital);
        }
        else{
            return null;
        }
    }
    public void delete(Hospital hospital){
        hospitalrepo1.delete(hospital);
    }

}


