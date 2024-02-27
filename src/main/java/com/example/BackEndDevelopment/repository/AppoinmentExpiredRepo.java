package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Appoinment.AppoinmentExpired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentExpiredRepo extends CrudRepository<AppoinmentExpired,Integer> {
    AppoinmentExpired findById(int id);
}
