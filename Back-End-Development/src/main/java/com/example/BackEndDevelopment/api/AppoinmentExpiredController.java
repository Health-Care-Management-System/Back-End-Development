package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentExpired;
import com.example.BackEndDevelopment.service.AppoinmentExpiredService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apiappoinmentexpired")
public class AppoinmentExpiredController {
    @Autowired
    private AppoinmentExpiredService appoinmentExpiredService;
    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody AppoinmentExpired appoinmentexpired) {
        appoinmentExpiredService.addBLMethod(appoinmentexpired);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<AppoinmentExpired> findAllRecord(){
        return appoinmentExpiredService.findAll ();
    }


    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<AppoinmentExpired> findById(@PathVariable Integer id) {
        Optional<AppoinmentExpired> record = appoinmentExpiredService.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppoinmentExpired> updateById(@PathVariable Integer id, @RequestBody AppoinmentExpired updatedRecord) {
        Optional<AppoinmentExpired> record = appoinmentExpiredService.findById(id);
        if (record.isPresent()) {
            AppoinmentExpired existingRecord = record.get();
            existingRecord.setBookingDate(updatedRecord.getBookingDate());
            existingRecord.setBookingTime(updatedRecord.getBookingTime());



            AppoinmentExpired savedRecord = appoinmentExpiredService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id ){
        Optional<AppoinmentExpired> record = appoinmentExpiredService.findById(id);
        if (record.isPresent()) {
            appoinmentExpiredService.delete(record.get());
            appoinmentExpiredService.addBLMethod(record.get());
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }}




