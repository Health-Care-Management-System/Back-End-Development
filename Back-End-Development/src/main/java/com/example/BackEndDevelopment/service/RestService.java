package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Employee;
import com.example.BackEndDevelopment.repository.RestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestService {
    @Autowired

    private RestRepo restRepo;
    public Employee addBLMethod(Employee employee){
        return restRepo.save(employee);

    }
    public Iterable<Employee> findAll(){
        return restRepo.findAll();
    }
    public Employee findById(Integer empId){
        return restRepo.getById(empId);
    }

//    public Optional<Employee> findById(Integer empId){
//        return Optional.ofNullable(restRepo.getById(empId));
//    }

    public Employee update(Integer empId, Employee newemployee){
        Optional<Employee> EmployeeOptional = restRepo.findById(empId);
        if (EmployeeOptional.isPresent()){
            Employee existingemployee = EmployeeOptional.get();
            existingemployee.setEmpName(newemployee.getEmpName());
            existingemployee.setEmpAddress(newemployee.getEmpAddress());
            existingemployee.setEmpNumber(newemployee.getEmpNumber());
            existingemployee.setEmpImage(newemployee.getEmpImage());
            existingemployee.setEmail(newemployee.getEmail());

            return restRepo.save(existingemployee);
        }
        else{
            return null;
        }
    }



    public void delete(Employee employee){
        restRepo.delete(employee);
    }

}
