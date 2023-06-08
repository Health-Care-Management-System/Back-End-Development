package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Appoinment.Appoinment;
import com.example.BackEndDevelopment.service.AppoinmentService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apiappoinment")
public class AppoinmentController {
    @Autowired
    private AppoinmentService appoinmentService;
    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody Appoinment appoinment) {
        appoinmentService.addBLMethod(appoinment);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Appoinment> findAllRecord(){
        return appoinmentService.findAll ();
    }


    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<Appoinment> findById(@PathVariable Integer id) {
        Optional<Appoinment> record = appoinmentService.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appoinment> updateById(@PathVariable Integer id, @RequestBody Appoinment updatedRecord) {
        Optional<Appoinment> record = appoinmentService.findById(id);
        if (record.isPresent()) {
            Appoinment existingRecord = record.get();
            existingRecord.setBookingDate(updatedRecord.getBookingDate());
            existingRecord.setBookingTime(updatedRecord.getBookingTime());



            Appoinment savedRecord = appoinmentService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id ){
        Optional<Appoinment> record = appoinmentService.findById(id);
        if (record.isPresent()) {
            appoinmentService.delete(record.get());
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }}




