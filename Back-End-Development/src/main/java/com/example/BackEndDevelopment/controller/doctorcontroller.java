package com.example.BackEndDevelopment.controller;

import com.example.BackEndDevelopment.exception.ResourceNotFoundException;
import com.example.BackEndDevelopment.models.Doctor;
import com.example.BackEndDevelopment.repository.Doctor_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")

public class doctorcontroller {

    @Autowired
    private Doctor_Repository doc_repo;

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorbyID(@PathVariable long id) {
        Doctor doct = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Does Not Exist with id: " + id));
        return ResponseEntity.ok(doct);
    }

    @PostMapping("/doctors/{id}/photo")
    public ResponseEntity<String> addPhotoToDoctor(@PathVariable long id, @RequestParam("file") MultipartFile file) throws IOException {
        try {
            Doctor doctor = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));

            // Set the image byte array to the uploaded file content
            doctor.setImage(file.getBytes());

            // Set the imageapi field with the id of the doctor
            doctor.setImageapi("http://localhost:8080/api/doctors/" + id + "/photo");

            // Save the doctor entity to update the image and imageapi fields in the database
            doc_repo.save(doctor);

            return ResponseEntity.ok("Photo added successfully to Doctor with ID: " + id);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body("Error: Data Integrity Violation occurred. Please check your input.");
        }
    }


    @GetMapping("/doctors/{id}/photo")
    public ResponseEntity<byte[]> getDoctorPhoto(@PathVariable long id) {
        Doctor doctor = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));

        byte[] image = doctor.getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);

    }

}

