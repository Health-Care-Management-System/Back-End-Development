package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Doctor;
import com.example.BackEndDevelopment.service.Doctor_Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")

public class doctorcontroller {

    @Autowired
    private Doctor_Service doc_serv;

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorbyID(@PathVariable long id) {
        return doc_serv.getDoctorbyID(id);
    }

    @PutMapping("/doctors/{id}/{column}/{data}")
    public ResponseEntity<Doctor> updateDoctorColumn(@PathVariable long id, @PathVariable String column, @PathVariable String data) {
        return doc_serv.updateDoctorColumn(id,column,data);
    }

    @PostMapping("/doctors/{id}/photo")
    public ResponseEntity<String> addPhotoToDoctor(@PathVariable long id, @RequestParam("file") MultipartFile file) throws IOException {
        return doc_serv.addPhotoToDoctor(id,file);
    }

    @GetMapping("/doctors/{id}/photo")
    public ResponseEntity<byte[]> getDoctorPhoto(@PathVariable long id) {
        return doc_serv.getDoctorPhoto(id);
    }
}