package com.example.BackEndDevelopment.api;


import com.example.BackEndDevelopment.entity.Appointments;
import com.example.BackEndDevelopment.service.Appoinment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/")
@RestController
public class AppoinmentController {

    @Autowired
    private Appoinment_Service appoinment_service;


    @GetMapping({"/getAppoinments"})
    public List<Appointments> getAppoinments(){
        return appoinment_service.getAppoinments();
    }

    @GetMapping({"/getAppoinmentDetails"})
    public List<Appointments> getAppoinmentDetails(){
        return appoinment_service.getAppoinmentDetails();
    }
}
