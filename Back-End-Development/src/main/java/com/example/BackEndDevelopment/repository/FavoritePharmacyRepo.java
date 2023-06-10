package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.FavoritePharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritePharmacyRepo extends CrudRepository<FavoritePharmacy,Integer> {
    FavoritePharmacy findById(int id);
}
