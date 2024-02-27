package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.FavoriteHospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteHospitalRepo extends CrudRepository<FavoriteHospital,Integer> {
    FavoriteHospital findById(int id);
}
