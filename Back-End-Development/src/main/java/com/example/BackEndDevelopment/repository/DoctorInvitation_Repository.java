package com.example.BackEndDevelopment.repository;

import com.example.BackEndDevelopment.entity.hospital.Doctor_Invitation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorInvitation_Repository extends CrudRepository< Doctor_Invitation , Integer> {

}
