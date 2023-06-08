package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.searchdemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface searchrepo extends CrudRepository<searchdemo,Integer> {
    //    searchdemo getById(Integer id);
    searchdemo findById(int id);
}
