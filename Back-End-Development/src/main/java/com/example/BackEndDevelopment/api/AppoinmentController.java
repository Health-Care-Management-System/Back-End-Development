package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Appoinment.Appoinment;
import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentExpired;
import com.example.BackEndDevelopment.service.AppoinmentExpiredService;
import com.example.BackEndDevelopment.service.AppoinmentService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apiappoinment")
public class AppoinmentController {
    @Autowired
    private AppoinmentService appoinmentService;

    @Autowired
    private AppoinmentExpiredService expiredAppointmentService;

    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody Appoinment appoinment) {
        appoinmentService.addBLMethod(appoinment);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Appoinment> findAllRecord(){
        var allAppointments = appoinmentService.findAll();

        // Filter expired appoinmnets from all apointmnets
        var expiredAppointments = new ArrayList<Appoinment>();
        allAppointments.forEach(app -> {
            var today = new Date();
            if (app.getBookingDate().compareTo(today) <0 ) {
                expiredAppointments.add(app);
            }
        });

        // Filter upcoming appointments from all appointmnets
        var upcomingAppointments = new ArrayList<Appoinment>();
        allAppointments.forEach(app -> {
            var today = new Date();
            if (app.getBookingDate().compareTo(today) >= 0 ) {
                upcomingAppointments.add(app);
            }
        });

        // Delete expired appointments from upcoming appointments
        for(int i = 0; i < expiredAppointments.size(); i++) {
            var ap = expiredAppointments.get(i);
            appoinmentService.delete(expiredAppointments.get(i));
        }

        for(int i = 0; i < expiredAppointments.size(); i++) {
            var ap = expiredAppointments.get(i);
            var expAppointment = new AppoinmentExpired();
            expAppointment.setSearchText(ap.getSearchText());
            expAppointment.setDoctorName(ap.getDoctorName());
            expAppointment.setDoctorSpeciality(ap.getDoctorSpeciality());
            expAppointment.setBookingDate(ap.getBookingDate());
            expAppointment.setBookingTime(ap.getBookingTime());
            expiredAppointmentService.addBLMethod(expAppointment);
        }
        return upcomingAppointments;
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
            existingRecord.setSearchText(updatedRecord.getSearchText());
            existingRecord.setPhone(updatedRecord.getPhone());



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






