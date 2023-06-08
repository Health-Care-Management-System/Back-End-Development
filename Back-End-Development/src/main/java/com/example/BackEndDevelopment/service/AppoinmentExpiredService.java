package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Appoinment.Appoinment;
import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentExpired;
import com.example.BackEndDevelopment.repository.AppoinmentExpiredRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppoinmentExpiredService {
    @Autowired

    private AppoinmentExpiredRepo appoinmentExpiredRepo;
    public AppoinmentExpired addBLMethod(AppoinmentExpired appoinmentExpired){
        return appoinmentExpiredRepo.save(appoinmentExpired);

    }
    public Iterable<AppoinmentExpired> findAll(){
        return appoinmentExpiredRepo.findAll();
    }


    public Optional<AppoinmentExpired> findById(Integer id){
        return appoinmentExpiredRepo.findById(id);
    }

    public AppoinmentExpired update(Integer id, Appoinment newHospital){
        Optional<AppoinmentExpired> AppoinmentExpiredOptional = appoinmentExpiredRepo.findById(id);
        if (AppoinmentExpiredOptional.isPresent()){
            AppoinmentExpired existingAppoinmentExpired = AppoinmentExpiredOptional.get();

//            existingAppoinment.setBookingDate(newAppoinment.getBookingDate());
//            existingAppoinment.setBookingTime(newAppoinment.getBookingTime());
//            existingAppoinment.setAppoinment(newAppoinment.getAppoinment());


            return appoinmentExpiredRepo.save(existingAppoinmentExpired);
        }
        else{
            return null;
        }
    }
    public void delete(AppoinmentExpired appoinmentExpired){
        appoinmentExpiredRepo.delete(appoinmentExpired);
    }

}

