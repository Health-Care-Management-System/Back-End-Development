package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Favorite;
import com.example.BackEndDevelopment.service.FavoriteService;
import com.example.BackEndDevelopment.service.searchservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/apifavorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private searchservice searchservice1;

    @PostMapping(value = "/add")
    public ResponseEntity<String> addOrUpdateRecord(@RequestBody Favorite favorite) {
        favorite.setIsFavorite(true); // Set isFavorite to true
        favoriteService.addBLMethod(favorite);
        return new ResponseEntity<>("data saved successfully.", HttpStatus.OK);
    }



    @GetMapping("/all")
    public Iterable<Favorite> findAllRecord(){
        return favoriteService.findAll ();
    }


    //   @GetMapping("/find/{id}")
//   public searchdemo findById(@PathVariable Integer id){
//       return searchservice1.findById(id);
//  }
    @GetMapping("/{id}")
    public ResponseEntity<Favorite> findById(@PathVariable Integer id) {
        Optional<Favorite> record = favoriteService.findById(id);
        if (record.isPresent()) {
            return ResponseEntity.ok(record.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorite> updateById(@PathVariable Integer id, @RequestBody Favorite updatedRecord) {
        Optional<Favorite> record = favoriteService.findById(id);
        if (record.isPresent()) {
            Favorite existingRecord = record.get();




            Favorite savedRecord = favoriteService.addBLMethod(existingRecord);
            return ResponseEntity.ok(savedRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Integer id ){
        Optional<Favorite> record = favoriteService.findById(id);
        if (record.isPresent()) {
            favoriteService.delete(record.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }}









