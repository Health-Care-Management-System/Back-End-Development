package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Availability;
import com.example.BackEndDevelopment.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping(value = "/all")
    public List<Availability> getAllAvailabilities() {
        return availabilityService.getAllAvailabilities();
    }

    @PostMapping(value = "/add")
    public Availability saveAvailability(@RequestBody Availability availability) {
        return availabilityService.saveAvailability(availability);
    }

    @PutMapping("/{id}")
    public Availability updateAvailability(@PathVariable("id") Long id, @RequestBody Availability availability) {
        return availabilityService.updateAvailability(id, availability);
    }
}


