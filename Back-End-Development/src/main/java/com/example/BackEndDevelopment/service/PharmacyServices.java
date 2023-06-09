package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Pharmacy;
import com.example.BackEndDevelopment.repository.PharmacyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PharmacyServices {

    @Autowired

    private PharmacyRepo pharmacyrepo1;
    public Pharmacy addBLMethod(Pharmacy pharmacy1){
        return pharmacyrepo1.save(pharmacy1);

    }
    public Iterable<Pharmacy> findAll(){
        return pharmacyrepo1.findAll();
    }

    //    public searchdemo findById(Integer id){
//        return searchrepo1.getById(id);
//    }
    public Optional<Pharmacy> findById(Integer id){
        return pharmacyrepo1.findById(id);
    }

    public Pharmacy update(Integer id, Pharmacy newPharmacy){
        Optional<Pharmacy> PharmacyOptional = pharmacyrepo1.findById(id);
        if (PharmacyOptional.isPresent()){
            Pharmacy existingPharmacy = PharmacyOptional.get();
            existingPharmacy.setName(newPharmacy.getName());
            existingPharmacy.setCity(newPharmacy.getCity());
            existingPharmacy.setDistrict(newPharmacy.getDistrict());
            existingPharmacy.setHospital(newPharmacy.getHospital());

            existingPharmacy.setpImage(newPharmacy.getpImage());
            return pharmacyrepo1.save(existingPharmacy);
        }
        else{
            return null;
        }
    }
    public void delete(Pharmacy pharmacy){
        pharmacyrepo1.delete(pharmacy);
    }

}

