package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Employee;
import com.example.BackEndDevelopment.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RestControl {
    @Autowired
    private RestService restService;
    @PostMapping("/add")
    public Employee addOrUpdateRecord(@RequestBody Employee employee){
        return restService.addBLMethod(employee);

    }

    @GetMapping("/all")
    public Iterable<Employee> findAllRecord(){
        return restService.findAll ();
    }

    @GetMapping("/find/{empId}")
    public Employee findById(@PathVariable Integer empId){
        return restService.findById(empId);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<?> removeById(@PathVariable Integer empId ){
        Employee rm=restService.findById(empId);
        restService.delete(rm);
        HttpStatusCode body;
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }
    @PutMapping("/{empId}")
    public ResponseEntity<Employee> updateById(@PathVariable Integer empId, @RequestBody Employee updatedRecord) {
        Optional<Employee> record = Optional.ofNullable(restService.findById(empId));
        if (record.isPresent()) {
            Employee existingRecord = record.get();
            existingRecord.setEmpName(updatedRecord.getEmpName());
            existingRecord.setEmpAddress(updatedRecord.getEmpAddress());
            existingRecord.setEmpNumber(updatedRecord.getEmpNumber());
            existingRecord.setEmpImage(updatedRecord.getEmpImage());
            existingRecord.setEmail(updatedRecord.getEmail());

            Employee savedRecord = restService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> removeById( @PathVariable Integer id){
//Employee rm=restService.findById(id);
//restService.delete(rm);
//return new ResponseEntity<String>(body:"deleted", HttpStatus.OK);
    }
}





