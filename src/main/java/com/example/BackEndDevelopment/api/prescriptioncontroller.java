package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.pharmacy.Prescription;
import com.example.BackEndDevelopment.service.Prescription_Service;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/prescription/")
public class prescriptioncontroller {

    @Autowired
    private Prescription_Service prescription_service;

    @GetMapping("/statuscount/{pharmacy_id}/{status}")
    public int getPrescriptionCount(@PathVariable String pharmacy_id,@PathVariable String status){
        return this.prescription_service.getPrescriptionCount(pharmacy_id,status);
    }

    @GetMapping("/list/{pharmacyid}/{status}")
    public List<Prescription> getStatuList(@PathVariable String pharmacyid,@PathVariable String status){
        return this.prescription_service.getPrescriptions(pharmacyid,status);
    }

    @PutMapping("changestatus/{pharmacyid}/{prescription_ID}/{response_state}")
    public void setPrescriptionResponseStatus(@PathVariable String pharmacyid, @PathVariable String prescription_ID, @PathVariable String response_state){
        this.prescription_service.setPrescriptionResponseStatus(pharmacyid,prescription_ID,response_state);
    }

}