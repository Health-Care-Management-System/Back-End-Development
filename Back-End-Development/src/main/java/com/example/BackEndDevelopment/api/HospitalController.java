package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Hospital;
import com.example.BackEndDevelopment.service.HospitalServices;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apihospital")

public class HospitalController {
    @Autowired
    private HospitalServices hospitalServices1;
    @Autowired
    searchservice searchservice1;
    @PostMapping("/add")
    public Hospital addOrUpdateRecord(@RequestBody Hospital hospital1){
        return hospitalServices1.addBLMethod(hospital1);

    }

    @GetMapping("/all")
    public Iterable<Hospital> findAllRecord(){
        return hospitalServices1.findAll ();
    }

    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> findById(@PathVariable Integer id) {
        Optional<Hospital> record = hospitalServices1.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospital> updateById(@PathVariable Integer id, @RequestBody Hospital updatedRecord) {
        Optional<Hospital> record = hospitalServices1.findById(id);
        if (record.isPresent()) {
            Hospital existingRecord = record.get();
            existingRecord.setFavorite(updatedRecord.isFavorite());
            Hospital savedRecord = hospitalServices1.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id ){
        Optional<Hospital> record = hospitalServices1.findById(id);
        if (record.isPresent()) {
            hospitalServices1.delete(record.get());
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }}


