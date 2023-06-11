package com.example.BackEndDevelopment.api;

import com.example.BackEndDevelopment.entity.Image;
import com.example.BackEndDevelopment.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("/api7")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestPart("image") MultipartFile file, String name, String city) {
        try {
            imageService.uploadImage(file,name,city);
            return ResponseEntity.ok("Image uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image.");
        }
    }
    @GetMapping("/all")
    public Iterable<Image> findAllRecord(){
        return imageService.findAll ();
    }
}


