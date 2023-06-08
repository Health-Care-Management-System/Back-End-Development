package com.example.BackEndDevelopment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Favorite {  @Id

private Integer id;
    private String name;
    private String city;
    private String district;
    private String hospital;
    private String spciality;
    private String empImage;
    private Boolean isFavorite;
    public Favorite() {
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean favorite) {
        isFavorite = favorite;
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
}
