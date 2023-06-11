package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.hospital.Hospital;
import com.example.BackEndDevelopment.service.Hospital_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private Hospital_Service hospitalService;

    @GetMapping({"/getHospitals"})
    public List<Hospital> getHospitals(){
        return hospitalService.getHospital();
    }

    @GetMapping({"/getHospitalDetailsById/{hospitalid}"})
    public Hospital getHospitalDetailsById(@PathVariable("hospitalid") Long hospitalid){
        return hospitalService.getHospitalDetailsById(hospitalid);
    }

    @PutMapping({"/updateHospital"})
    public Hospital updateHospital(@RequestBody Hospital hospital){
        return hospitalService.updateHospital(hospital);
    }

    @DeleteMapping({"/deleteHospital"})
    public void deleteHospital(@RequestParam Long hospitalid){
        hospitalService.deleteHospital(hospitalid);
    }
}
