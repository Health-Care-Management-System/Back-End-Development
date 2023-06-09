package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Pharmacy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepo extends CrudRepository<Pharmacy,Integer> {
    Pharmacy findById(int id);
}
