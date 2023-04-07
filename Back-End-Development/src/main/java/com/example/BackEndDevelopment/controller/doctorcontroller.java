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
        Doctor doct = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));
        return ResponseEntity.ok(doct);
    }

    @PutMapping("/doctors/{id}/{column}/{data}")
    public ResponseEntity<Doctor> updateDoctorColumn(@PathVariable long id, @PathVariable String column, @PathVariable String data) {
        Doctor doctor = doc_repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));

        switch (column.toLowerCase()) {
            case "address":
                doctor.setAddress(data);
                break;
            case "contactnumber":
                doctor.setContactnumber(data);
                break;
            case "emailid":
                doctor.setEmailID(data);
                break;
            case "experiences":
                doctor.setExperience(data);
                break;
            default:
                throw new IllegalArgumentException("Invalid column: " + column);
        }

        Doctor updatedDoctor = doc_repo.save(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @PostMapping("/doctors/{id}/photo")
    public ResponseEntity<String> addPhotoToDoctor(@PathVariable long id, @RequestParam("file") MultipartFile file) throws IOException {
        try {
            Doctor doctor = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));

            doctor.setImage(file.getBytes());

            doctor.setImageapi("http://localhost:8080/api/doctors/" + id + "/photo");

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

