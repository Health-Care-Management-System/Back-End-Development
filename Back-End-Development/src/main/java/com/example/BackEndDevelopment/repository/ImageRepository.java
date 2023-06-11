package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository  extends JpaRepository<Image, Long> {
}
