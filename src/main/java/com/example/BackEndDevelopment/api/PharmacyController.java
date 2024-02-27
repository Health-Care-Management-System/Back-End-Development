package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Pharmacy;
import com.example.BackEndDevelopment.service.PharmacyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apipharmacy")

public class PharmacyController {

    @Autowired
    private PharmacyServices pharmacyservice1;
    @PostMapping("/add")
    public Pharmacy addOrUpdateRecord(@RequestBody Pharmacy pharmacy1){
        return pharmacyservice1.addBLMethod(pharmacy1);

    }

    @GetMapping("/all")
    public Iterable<Pharmacy> findAllRecord(){
        return pharmacyservice1.findAll ();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacy> findById(@  PathVariable Integer id) {
        Optional<Pharmacy> record = pharmacyservice1.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pharmacy> updateById(@PathVariable Integer id, @RequestBody Pharmacy updatedRecord) {
        Optional<Pharmacy> record = pharmacyservice1.findById(id);
        if (record.isPresent()) {
            Pharmacy existingRecord = record.get();
//            existingRecord.setName(updatedRecord.getName());
//            existingRecord.setCity(updatedRecord.getCity());
//            existingRecord.setDistrict(updatedRecord.getDistrict());
//            existingRecord.setHospital(updatedRecord.getHospital());
//
//            existingRecord.setpImage(updatedRecord.getpImage());
            existingRecord.setFavorite(updatedRecord.isFavorite());
            Pharmacy savedRecord = pharmacyservice1.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id ){
        Optional<Pharmacy> record = pharmacyservice1.findById(id);
        if (record.isPresent()) {
            pharmacyservice1.delete(record.get());
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getPharmacyCount")
    public int getPharmacyCount(){
        return this.pharmacyservice1.getPharmacyCount();
    }

}




