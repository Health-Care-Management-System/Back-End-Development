package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import com.example.BackEndDevelopment.exception.ResourceNotFoundException;
import com.example.BackEndDevelopment.repository.DoctorInvitation_Repository;
import com.example.BackEndDevelopment.repository.Doctor_Repository;
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
import java.util.Optional;

@Service
public class Doctor_Service {

    @Autowired
    private Doctor_Repository doc_repo;

    public ResponseEntity<Doctor> getDoctorbyID(long id){
        Doctor doct = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));
        return ResponseEntity.ok(doct);
    }

    public ResponseEntity<Doctor> updateDoctorColumn(long id,String column,String data) {
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

    public ResponseEntity<String> addPhotoToDoctor(long id,MultipartFile file) throws IOException {
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

    public ResponseEntity<byte[]> getDoctorPhoto(long id) {
        Doctor doctor = doc_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor Does Not Exist with id: " + id));

        byte[] image = doctor.getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(image.length);

        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }


   ///////////////////doctor invitation methods///////////////////////////
    @Autowired
    private DoctorInvitation_Repository doctor_invitation_repo;

    public void saveDoctor(Doctor doctor){
        doc_repo.save(doctor);
    }
    public List<Doctor_Invitation> getDoctorInvitations(String email){
        Optional<Doctor> doctor  = doc_repo.findByEmail(email);
        if (!doctor.isPresent()){
            throw new RuntimeException("Doctor not found!");
        }
        Long doctorId = doctor.get().getId();
        return doctor_invitation_repo.findByIdDoctorId(doctorId);
    }

}


