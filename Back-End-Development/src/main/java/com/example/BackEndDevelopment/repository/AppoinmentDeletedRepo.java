package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentDeleted;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentDeletedRepo extends CrudRepository<AppoinmentDeleted,Integer> {
    AppoinmentDeleted findById(int id);
}
