package com.example.BackEndDevelopment.entity.hospital;
import jakarta.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hospitalid;

  //  @OneToMany        // - hosptial can have only one Owner and Owner can have many hospitals
   @OneToOne
    @JoinColumn(name = "hospitalowner_id", referencedColumnName = "hospitaowwnerid")
    private HospitalOwner hospitalOwner;

    private String name;
    private String registrationnumber;
    private String email;
    private String phonenumber;
    private String city;
    private String street;
    private String district;

    public Hospital(HospitalOwner hospitalOwner, String name, String registrationnumber, String email, String phonenumber, String city, String street, String district) {
        super();
        this.hospitalOwner = hospitalOwner;
        this.name = name;
        this.registrationnumber = registrationnumber;
        this.email = email;
        this.phonenumber = phonenumber;
        this.city = city;
        this.street = street;
        this.district = district;
    }

    public Hospital() {

    }

    public long getHospitalid() {
        return hospitalid;
    }

    public void setHospitalid(long hospitalid) {
        this.hospitalid = hospitalid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public HospitalOwner getHospitalOwner() {
        return hospitalOwner;
    }

    public void setHospitalOwner(HospitalOwner hospitalOwner) {
        this.hospitalOwner = hospitalOwner;
    }
}
