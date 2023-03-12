package com.example.BackEndDevelopment.controller;

import com.example.BackEndDevelopment.exception.ResourceNotFoundException;
import com.example.BackEndDevelopment.models.Doctor;
import com.example.BackEndDevelopment.repository.Doctor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")

public class doctorcontroller {

    @Autowired
    private Doctor_Repository doc_repo;

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorbyID(@PathVariable long id){
        Doctor doct = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Does Not Exist with id: "+id));
        return ResponseEntity.ok(doct);
    }
}
