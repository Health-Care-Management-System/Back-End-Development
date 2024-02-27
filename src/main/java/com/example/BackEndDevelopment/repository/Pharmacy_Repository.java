package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.pharmacy.PharmacyNew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pharmacy_Repository extends JpaRepository<PharmacyNew, String> {

}
