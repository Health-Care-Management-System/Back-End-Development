package com.example.BackEndDevelopment.entity.pharmacy;

import jakarta.persistence.*;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {

    @Id
    private String pharmacyid;

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "ownerid")
    private PharmacyOwner pharmacyOwner;

    private String pharmacyname;
    private String registrationnumber;
    private String email;
    private String phonenumber;
    private String city;
    private String street;
    private String district;

    public Pharmacy(String pharmacyid, PharmacyOwner pharmacyOwner, String pharmacyname, String registrationnumber, String email, String phonenumber, String city, String street, String district) {
        this.pharmacyid = pharmacyid;
        this.pharmacyOwner = pharmacyOwner;
        this.pharmacyname = pharmacyname;
        this.registrationnumber = registrationnumber;
        this.email = email;
        this.phonenumber = phonenumber;
        this.city = city;
        this.street = street;
        this.district = district;
    }

    public Pharmacy() {

    }

    public String getPharmacyid() {
        return pharmacyid;
    }

    public void setPharmacyid(String pharmacyid) {
        this.pharmacyid = pharmacyid;
    }

    public PharmacyOwner getPharmacyOwner() {
        return pharmacyOwner;
    }

    public void setPharmacyOwner(PharmacyOwner pharmacyOwner) {
        this.pharmacyOwner = pharmacyOwner;
    }

    public String getPharmacyname() {
        return pharmacyname;
    }

    public void setPharmacyname(String pharmacyname) {
        this.pharmacyname = pharmacyname;
    }

    public String getRegistrationnumber() {
        return registrationnumber;
    }

    public void setRegistrationnumber(String registrationnumber) {
        this.registrationnumber = registrationnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
