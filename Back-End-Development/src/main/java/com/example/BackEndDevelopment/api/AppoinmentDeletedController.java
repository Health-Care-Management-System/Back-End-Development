package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentDeleted;
import com.example.BackEndDevelopment.service.AppoinmentDeletedService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apiappoinmentdeleted")
public class AppoinmentDeletedController {



    @Autowired
    private AppoinmentDeletedService appoinmentDeletedService;
    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody AppoinmentDeleted appoinmentdeleted) {
        appoinmentDeletedService.addBLMethod(appoinmentdeleted);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<AppoinmentDeleted> findAllRecord(){
        return appoinmentDeletedService.findAll ();
    }


    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<AppoinmentDeleted> findById(@PathVariable Integer id) {
        Optional<AppoinmentDeleted> record = appoinmentDeletedService.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppoinmentDeleted> updateById(@PathVariable Integer id, @RequestBody AppoinmentDeleted updatedRecord) {
        Optional<AppoinmentDeleted> record = appoinmentDeletedService.findById(id);
        if (record.isPresent()) {
            AppoinmentDeleted existingRecord = record.get();
            existingRecord.setBookingDate(updatedRecord.getBookingDate());
            existingRecord.setBookingTime(updatedRecord.getBookingTime());



            AppoinmentDeleted savedRecord = appoinmentDeletedService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id ){
        Optional<AppoinmentDeleted> record = appoinmentDeletedService.findById(id);
        if (record.isPresent()) {
            appoinmentDeletedService.delete(record.get());
            appoinmentDeletedService.addBLMethod(record.get());
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }}

