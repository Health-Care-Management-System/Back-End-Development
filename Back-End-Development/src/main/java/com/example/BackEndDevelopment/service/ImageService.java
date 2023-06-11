package com.example.BackEndDevelopment.service;

import com.example.BackEndDevelopment.entity.Image;
import com.example.BackEndDevelopment.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    public void uploadImage(MultipartFile file, String name, String city) {
        // Save the image to the database or perform any other necessary actions
        Image image = new Image();
        image.setFileName(file.getOriginalFilename());
        image.setName(name);
        image.setCity(city);
        image.setDateTime(LocalDateTime.now().toString());
//       image.setContent(file.getBytes());
        imageRepository.save(image);
    }
//        try {
//            Image image = new Image();
//            image.setFileName(file.getOriginalFilename());
//            image.setContent(file.getBytes());
//            imageRepository.save(image);
//        } catch (IOException e) {
//            // Handle the exception here or rethrow it as a custom exception
//            e.printStackTrace();
//        }

    public Iterable<Image> findAll(){
        return imageRepository.findAll();
    }
}

