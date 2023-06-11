package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.FavoritePharmacy;
import com.example.BackEndDevelopment.service.FavoritePharmacyService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apipharmacyfavorite")

public class FavoritePharmacyController {
    @Autowired
private FavoritePharmacyService favoritePharmacyService;
    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody FavoritePharmacy favoritePharmacy) {
        favoritePharmacy.setIsFavorite(true); // Set isFavorite to true
        favoritePharmacyService.addBLMethod(favoritePharmacy);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }



    @GetMapping("/all")
    public Iterable<FavoritePharmacy> findAllRecord(){
        return favoritePharmacyService.findAll ();
    }


    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<FavoritePharmacy> findById(@PathVariable Integer id) {
        Optional<FavoritePharmacy> record = favoritePharmacyService.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FavoritePharmacy> updateById(@PathVariable Integer id, @RequestBody FavoritePharmacy updatedRecord) {
        Optional<FavoritePharmacy> record = favoritePharmacyService.findById(id);
        if (record.isPresent()) {
            FavoritePharmacy existingRecord = record.get();




            FavoritePharmacy savedRecord = favoritePharmacyService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Integer id ){
        Optional<FavoritePharmacy> record = favoritePharmacyService.findById(id);
        if (record.isPresent()) {
            favoritePharmacyService.delete(record.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }}



