package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.patient.Patient;
import com.example.BackEndDevelopment.entity.pharmacy.Prescription;
import com.example.BackEndDevelopment.exception.ResourceNotFoundException;
import com.example.BackEndDevelopment.repository.Patient_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class Patient_Service {
    @Autowired
    private Patient_Repository patient_repo;

    public ResponseEntity<Patient> getPatientbyID(String id) {
        Patient patient = patient_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));
        return ResponseEntity.ok(patient);
    }

    public void deletePatientbyID(String id) {
        Patient p = this.patient_repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found user with id: "+id));
        this.patient_repo.delete(p);
    }

    public List<Patient> getAllPatient() {
        List<Patient> patient = patient_repo.findAll();
        return patient;
    }

    public ResponseEntity<Patient> updateDoctorColumn(String id,String column,String data) {
        Patient patient = patient_repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));

        switch (column.toLowerCase()) {
            case "address":
                patient.setAddress(data);
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

    public ResponseEntity<String> addPhotoToPatient(String id,MultipartFile file) throws IOException {
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

    public ResponseEntity<byte[]> getPatientPhoto(String id) {
        Patient patient = patient_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient Does Not Exist with id: " + id));

        byte[] image = patient.getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }

    public int getPatientCount(){
        int count = 0;
        List<Patient> patients = this.patient_repo.findAll();
        for(Patient patient : patients){
            count++;
        }
        return count;
    }

}
