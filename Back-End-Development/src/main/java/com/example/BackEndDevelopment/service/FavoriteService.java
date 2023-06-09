package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Favorite;
import com.example.BackEndDevelopment.repository.FavoriteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired

    private FavoriteRepo favoriteRepo;
    public Favorite addBLMethod(Favorite favorite){
        return favoriteRepo.save(favorite);

    }
    public Iterable<Favorite> findAll(){
        return favoriteRepo.findAll();
    }


    public Optional<Favorite> findById(Integer id){
        return favoriteRepo.findById(id);
    }


    public void delete(Favorite favorite){
        favoriteRepo.delete(favorite);
    }



}

