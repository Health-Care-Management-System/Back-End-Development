package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.service.Doctor_Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")

public class doctorcontroller {

    @Autowired
    private Doctor_Service doc_serv;

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorbyID(@PathVariable String doc_id) {
        return doc_serv.getDoctorbyID(doc_id);
    }

    @GetMapping({"/getAllDoctors"})
    public List<Doctor> getAllDoctors() {
        return doc_serv.getAllDoctors();
    }

    @PutMapping("/doctors/{id}/{column}/{data}")
    public ResponseEntity<Doctor> updateDoctorColumn(@PathVariable String doc_id, @PathVariable String column, @PathVariable String data) {
        return doc_serv.updateDoctorColumn(doc_id,column,data);
    }

    @PostMapping("/doctors/{id}/photo")
    public ResponseEntity<String> addPhotoToDoctor(@PathVariable String doc_id, @RequestParam("file") MultipartFile file) throws IOException {
        return doc_serv.addPhotoToDoctor(doc_id,file);
    }

    @GetMapping("/doctors/{id}/photo")
    public ResponseEntity<byte[]> getDoctorPhoto(@PathVariable String doc_id) {
        return doc_serv.getDoctorPhoto(doc_id);
    }
}