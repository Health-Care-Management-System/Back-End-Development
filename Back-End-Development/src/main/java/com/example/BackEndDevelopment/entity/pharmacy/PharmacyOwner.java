package com.example.BackEndDevelopment.entity.pharmacy;

import jakarta.persistence.*;

@Entity
@Table(name = "pharmacy_owner")
public class PharmacyOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ownerid;
    private String firstname;
    private String lastname;
    private  String nic;
    private String email;
    private String phonenumber;
    private String city;
    private String street;
    private String district;

    public PharmacyOwner(String firstname, String lastname, String nic, String email, String phonenumber, String city, String street, String district) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.nic = nic;
        this.email = email;
        this.phonenumber = phonenumber;
        this.city = city;
        this.street = street;
        this.district = district;
    }

    public PharmacyOwner() {

    }

    public long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(long ownerid) {
        this.ownerid = ownerid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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
