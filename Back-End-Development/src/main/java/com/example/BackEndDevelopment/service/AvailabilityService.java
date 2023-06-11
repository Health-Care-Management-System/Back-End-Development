package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Availability;
import com.example.BackEndDevelopment.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }

    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public Availability updateAvailability(Long id, Availability availability) {
        Availability existingAvailability = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found with id: " + id));

        existingAvailability.setDay(availability.getDay());
        existingAvailability.setAvailable(availability.isAvailable());
        existingAvailability.setTimeInterval(availability.getTimeInterval());

        return availabilityRepository.save(existingAvailability);
    }

}

