package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Appoinment.Appoinment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentRepo extends CrudRepository<Appoinment,Integer> {
    Appoinment findById(int id);
}
