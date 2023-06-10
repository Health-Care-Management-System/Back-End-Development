package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.pharmacy.Pharmacy;
import com.example.BackEndDevelopment.exception.ResourceNotFoundException;
import com.example.BackEndDevelopment.repository.Pharmacy_Repository;
import com.example.BackEndDevelopment.repository.Prescription_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Pharmacy_Service{

    @Autowired
    private Pharmacy_Repository pharmacy_repo;

    public ResponseEntity<String> savePharmacy(Pharmacy pharmacy) {
        try {
            this.pharmacy_repo.save(pharmacy);
            return ResponseEntity.ok("Successfully Added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save pharmacy: " + e.getMessage());
        }
    }

    public List<Pharmacy> getAllPharmacy(){
        return pharmacy_repo.findAll();
    }

    public Pharmacy getPharmacyById(String id) {
        return pharmacy_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }



}