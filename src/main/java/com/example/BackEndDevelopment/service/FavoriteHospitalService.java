package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.FavoriteHospital;
import com.example.BackEndDevelopment.repository.FavoriteHospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FavoriteHospitalService {
    @Autowired

    private FavoriteHospitalRepo favoriteHospitalRepo;
    public FavoriteHospital addBLMethod(FavoriteHospital favoriteHospital){
        return favoriteHospitalRepo.save(favoriteHospital);

    }
    public Iterable<FavoriteHospital> findAll(){
        return favoriteHospitalRepo.findAll();
    }


    public Optional<FavoriteHospital> findById(Integer id){
        return favoriteHospitalRepo.findById(id);
    }


    public void delete(FavoriteHospital favoriteHospital){
        favoriteHospitalRepo.delete(favoriteHospital);
    }



}




