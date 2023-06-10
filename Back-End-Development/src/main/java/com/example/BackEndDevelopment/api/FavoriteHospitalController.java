package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.FavoriteHospital;
import com.example.BackEndDevelopment.service.FavoriteHospitalService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/apihospitalfavorite")
public class FavoriteHospitalController {
    @Autowired
private FavoriteHospitalService favoriteHospitalService;
    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody FavoriteHospital favoriteHospital) {
        favoriteHospital.setIsFavorite(true);// Set isFavorite to true
        favoriteHospitalService.addBLMethod(favoriteHospital);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }



    @GetMapping("/all")
    public Iterable<FavoriteHospital> findAllRecord(){
        return favoriteHospitalService.findAll ();
    }


    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<FavoriteHospital> findById(@PathVariable Integer id) {
        Optional<FavoriteHospital> record = favoriteHospitalService.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FavoriteHospital> updateById(@PathVariable Integer id, @RequestBody FavoriteHospital updatedRecord) {
        Optional<FavoriteHospital> record = favoriteHospitalService.findById(id);
        if (record.isPresent()) {
            FavoriteHospital existingRecord = record.get();




            FavoriteHospital savedRecord = favoriteHospitalService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Integer id ){
        Optional<FavoriteHospital> record = favoriteHospitalService.findById(id);
        if (record.isPresent()) {
            favoriteHospitalService.delete(record.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }}








