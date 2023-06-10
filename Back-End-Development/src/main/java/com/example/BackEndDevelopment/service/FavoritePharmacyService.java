package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.FavoritePharmacy;
import com.example.BackEndDevelopment.repository.FavoritePharmacyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FavoritePharmacyService {
 @Autowired

private FavoritePharmacyRepo favoritePharmacyRepo;
    public FavoritePharmacy addBLMethod(FavoritePharmacy favoritePharmacy){
        return favoritePharmacyRepo.save(favoritePharmacy);

    }
    public Iterable<FavoritePharmacy> findAll(){
        return favoritePharmacyRepo.findAll();
    }


    public Optional<FavoritePharmacy> findById(Integer id){
        return favoritePharmacyRepo.findById(id);
    }


    public void delete(FavoritePharmacy favoritePharmacy){
        favoritePharmacyRepo.delete(favoritePharmacy);
    }



}
