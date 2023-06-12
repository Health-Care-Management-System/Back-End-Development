package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.searchdemo;
import com.example.BackEndDevelopment.repository.searchrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class searchservice {
    @Autowired

    private searchrepo searchrepo1;
    public searchdemo addBLMethod(searchdemo searchdemo1){
        return searchrepo1.save(searchdemo1);

    }
    public Iterable<searchdemo> findAll(){
        return searchrepo1.findAll();
    }

    public int getDoctorCount() {
        Iterable<searchdemo> doctors = this.searchrepo1.findAll();
        int count = 0;
        for (searchdemo doctor : doctors) {
            count++;
        }
        return count;
    }

    public Optional<searchdemo> findById(Integer id){
        return searchrepo1.findById(id);
    }

    public searchdemo update(Integer id, searchdemo newSearchDemo){
        Optional<searchdemo> searchdemoOptional = searchrepo1.findById(id);
        if (searchdemoOptional.isPresent()){
            searchdemo existingSearchDemo = searchdemoOptional.get();
            existingSearchDemo.setName(newSearchDemo.getName());
            existingSearchDemo.setCity(newSearchDemo.getCity());
            existingSearchDemo.setDistrict(newSearchDemo.getDistrict());
            existingSearchDemo.setHospital(newSearchDemo.getHospital());
            existingSearchDemo.setSpciality(newSearchDemo.getSpciality());
            existingSearchDemo.setEmpImage(newSearchDemo.getEmpImage());
            return searchrepo1.save(existingSearchDemo);
        }
        else{
            return null;
        }
    }
    public void delete(searchdemo searchdemo1){
        searchrepo1.delete(searchdemo1);
    }

    public Optional<searchdemo> getDoctorById(Integer id) {
        return searchrepo1.findById(id);
    }
}
