package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepo extends CrudRepository<Hospital,Integer> {
    Hospital findById(int id);
}

