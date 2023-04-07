package com.example.BackEndDevelopment.controller;

import com.example.BackEndDevelopment.exception.ResourceNotFoundException;
import com.example.BackEndDevelopment.models.Doctor;
import com.example.BackEndDevelopment.models.Patient;
import com.example.BackEndDevelopment.repository.Patient_Repository;
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
public class patientcontroller {


    @Autowired
    private Patient_Repository patient_repo;

    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> getPatientbyID(@PathVariable long id) {
        Patient patient = patient_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/patients/{id}/{column}/{data}")
    public ResponseEntity<Patient> updateDoctorColumn(@PathVariable long id, @PathVariable String column, @PathVariable String data) {
        Patient patient = patient_repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));

        switch (column.toLowerCase()) {
            case "address":
                patient.setAddress(data);
                break;
            case "contactnumber":
                patient.setContactnumber(data);
                break;
            case "emailid":
                patient.setEmailID(data);
                break;
            default:
                throw new IllegalArgumentException("Invalid column: " + column);
        }

        Patient updatedPatient = patient_repo.save(patient);
        return ResponseEntity.ok(updatedPatient);
    }

    @PostMapping("/patients/{id}/photo")
    public ResponseEntity<String> addPhotoToPatient(@PathVariable long id, @RequestParam("file") MultipartFile file) throws IOException {
        try {
            Patient patient = patient_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));

            patient.setImage(file.getBytes());

            patient.setImageapi("http://localhost:8080/api/patients/" + id + "/photo");

            patient_repo.save(patient);

            return ResponseEntity.ok("Photo added successfully to Patient with ID: " + id);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body("Error: Data Integrity Violation occurred. Please check your input.");
        }
    }

    @GetMapping("/patients/{id}/photo")
    public ResponseEntity<byte[]> getPatientPhoto(@PathVariable long id) {
        Patient patient = patient_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));

        byte[] image = patient.getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

}
