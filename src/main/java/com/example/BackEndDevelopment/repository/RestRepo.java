package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestRepo extends CrudRepository<Employee,Integer> {
    Employee getById(Integer empId);




}
