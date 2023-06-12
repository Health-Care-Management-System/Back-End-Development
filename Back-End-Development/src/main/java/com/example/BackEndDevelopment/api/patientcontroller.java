package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.patient.Patient;
import com.example.BackEndDevelopment.service.Patient_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
public class patientcontroller {


    @Autowired
    private Patient_Service patient_serv;


    @GetMapping("patients/{id}")
    public ResponseEntity<Patient> getPatientbyID(@PathVariable String id) {
        return patient_serv.getPatientbyID(id);
    }

    @PutMapping("/patients/{id}/{column}/{data}")
    public ResponseEntity<Patient> updateDoctorColumn(@PathVariable String id, @PathVariable String column, @PathVariable String data) {
        return  patient_serv.updateDoctorColumn(id,column,data);
    }

    @PostMapping("/patients/{id}/photo")
    public ResponseEntity<String> addPhotoToPatient(@PathVariable String id, @RequestParam("file") MultipartFile file) throws IOException {
        return patient_serv.addPhotoToPatient(id,file);
    }

    @GetMapping("/patients/{id}/photo")
    public ResponseEntity<byte[]> getPatientPhoto(@PathVariable String id) {
        return patient_serv.getPatientPhoto(id);
    }

    @GetMapping("/patient/countAll")
    public int getPatientCount(){
        return this.patient_serv.getPatientCount();
    }

    @GetMapping("/patient/getAllPatient")
    public List<Patient> getAllPatient(){
        return this.patient_serv.getAllPatient();
    }

    @DeleteMapping("/patients/delete/{id}")
    public void deleteById(@PathVariable String id){
        this.patient_serv.deletePatientbyID(id);
    }

}
