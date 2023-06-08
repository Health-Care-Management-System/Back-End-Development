package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Appoinment.Appoinment;
import com.example.BackEndDevelopment.repository.AppoinmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppoinmentService {
    @Autowired

    private AppoinmentRepo appoinmentRepo;
    public Appoinment addBLMethod(Appoinment appoinment){
        return appoinmentRepo.save(appoinment);

    }
    public Iterable<Appoinment> findAll(){
        return appoinmentRepo.findAll();
    }


    public Optional<Appoinment> findById(Integer id){
        return appoinmentRepo.findById(id);
    }

    public Appoinment update(Integer id, Appoinment newHospital){
        Optional<Appoinment> AppoinmentOptional = appoinmentRepo.findById(id);
        if (AppoinmentOptional.isPresent()){
            Appoinment existingAppoinment = AppoinmentOptional.get();

//            existingAppoinment.setBookingDate(newAppoinment.getBookingDate());
//            existingAppoinment.setBookingTime(newAppoinment.getBookingTime());
//            existingAppoinment.setAppoinment(newAppoinment.getAppoinment());


            return appoinmentRepo.save(existingAppoinment);
        }
        else{
            return null;
        }
    }
    public void delete(Appoinment appoinment){
        appoinmentRepo.delete(appoinment);
    }

}

