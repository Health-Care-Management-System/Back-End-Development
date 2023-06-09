package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Appoinment.Appoinment;
import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentDeleted;
import com.example.BackEndDevelopment.repository.AppoinmentDeletedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppoinmentDeletedService {
    @Autowired

    private AppoinmentDeletedRepo appoinmentDeletedRepo;
    public AppoinmentDeleted addBLMethod(AppoinmentDeleted appoinmentDeleted){
        return appoinmentDeletedRepo.save(appoinmentDeleted);

    }
    public Iterable<AppoinmentDeleted> findAll(){
        return appoinmentDeletedRepo.findAll();
    }


    public Optional<AppoinmentDeleted> findById(Integer id){
        return appoinmentDeletedRepo.findById(id);
    }

    public AppoinmentDeleted update(Integer id, Appoinment newHospital){
        Optional<AppoinmentDeleted> AppoinmentDeletedOptional = appoinmentDeletedRepo.findById(id);
        if (AppoinmentDeletedOptional.isPresent()){
            AppoinmentDeleted existingAppoinmentDeleted = AppoinmentDeletedOptional.get();

//            existingAppoinment.setBookingDate(newAppoinment.getBookingDate());
//            existingAppoinment.setBookingTime(newAppoinment.getBookingTime());
//            existingAppoinment.setAppoinment(newAppoinment.getAppoinment());


            return appoinmentDeletedRepo.save(existingAppoinmentDeleted);
        }
        else{
            return null;
        }
    }
    public void delete(AppoinmentDeleted appoinmentDeleted){
        appoinmentDeletedRepo.delete(appoinmentDeleted);
    }

}
