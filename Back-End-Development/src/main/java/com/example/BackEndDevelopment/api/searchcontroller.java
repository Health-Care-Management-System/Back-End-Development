package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.searchdemo;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api1")
public class searchcontroller {
    @Autowired
    private searchservice searchservice1;
    @PostMapping("/add")
    public searchdemo addOrUpdateRecord(@RequestBody searchdemo searchdemo1){
        return searchservice1.addBLMethod(searchdemo1);

    }

    @GetMapping("/all")
    public Iterable<searchdemo> findAllRecord(){
        return searchservice1.findAll ();
    }

    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<searchdemo> findById(@PathVariable Integer id) {
        Optional<searchdemo> record = searchservice1.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<searchdemo> updateById(@PathVariable Integer id, @RequestBody searchdemo updatedRecord) {
        Optional<searchdemo> record = searchservice1.findById(id);
        if (record.isPresent()) {
            searchdemo existingRecord = record.get();

            existingRecord.setFavorite(updatedRecord.isFavorite()); // Update the isFavorite status

            searchdemo savedRecord = searchservice1.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id ){
        Optional<searchdemo> record = searchservice1.findById(id);
        if (record.isPresent()) {
            searchservice1.delete(record.get());
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }}
