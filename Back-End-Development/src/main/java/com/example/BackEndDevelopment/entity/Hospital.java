package com.example.BackEndDevelopment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String city;
    private String district;
    private String hospital;
    private String contactNum;
    private String hImage;


    public Hospital() {
    }
//    @JsonIgnore
//    @ManyToMany(cascade=CascadeType.ALL,mappedBy="hospitals")
//    private Set<searchdemo> searchdemos=new HashSet<>();
//
//    public Set<searchdemo> getSearchdemos() {
//        return searchdemos;
//    }
//
//    public void setSearchdemos(Set<searchdemo> searchdemos) {
//        this.searchdemos = searchdemos;
//    }

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

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String gethImage() {
        return hImage;
    }

    public void sethImage(String hImage) {
        this.hImage = hImage;
    }
}
