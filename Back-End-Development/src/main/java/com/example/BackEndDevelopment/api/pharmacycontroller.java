package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.pharmacy.Pharmacy_;
import com.example.BackEndDevelopment.service.Pharmacy_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/pharmacy/")
public class pharmacycontroller {

    @Autowired
    private Pharmacy_Service pharmacy_service;

    @PostMapping("/savepharmacy")
    public ResponseEntity<String> savePharmacy(@RequestBody Pharmacy_ pharmacy)
    {
        return pharmacy_service.savePharmacy(pharmacy);
    }

    @GetMapping("/getpharmacylist")
    public List<Pharmacy_> savePharmacy()
    {
        return pharmacy_service.getAllPharmacy();
    }

    @GetMapping("/getPharmacyById/{id}")
    public Pharmacy_ getPharmacyById(@PathVariable String id){
        return pharmacy_service.getPharmacyById(id);
    }

}
