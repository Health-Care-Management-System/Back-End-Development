package com.example.BackEndDevelopment.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class searchdemo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String name;
    private boolean isFavorite;
    private String city;
    private String district;
    private String hospital;
    private String spciality;
    private String empImage;
    private String slmcnumber;


    public searchdemo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHospital() {
        return hospital;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSpciality() {
        return spciality;
    }

    public void setSpciality(String spciality) {
        this.spciality = spciality;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }

    public String getSlmcnumber() {
        return slmcnumber;
    }

    public void setSlmcnumber(String slmcnumber) {
        this.slmcnumber = slmcnumber;
    }
}
