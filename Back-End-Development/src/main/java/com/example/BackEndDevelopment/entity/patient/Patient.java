package com.example.BackEndDevelopment.entity.patient;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    private String id;

    @Column(name = "First_Name")
    private String firstname;

    @Column(name = "Last_Name")
    private String lastname;

    @Column(name = "dob")
    private String dob;
    @Column(name = "Address")
    private String address;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true)
    @Column(name = "Contact_Number")
    private Set<PatientPhoneNumber> phoneNumber = new HashSet<>();

    @Column(name = "Email")
    private String emailID;

    @Column(name = "Image", columnDefinition = "longblob")
    private byte[] image;

    @Column(name = "ImageAPI")
    private String imageapi;


    public Patient() {  }

    public Patient(String id, String firstname, String lastname, String dob, String address, Set<PatientPhoneNumber> phoneNumber, String emailID, byte[] image, String imageapi) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.image = image;
        this.imageapi = imageapi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<PatientPhoneNumber> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Set<PatientPhoneNumber> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageapi() {
        return imageapi;
    }

    public void setImageapi(String imageapi) {
        this.imageapi = imageapi;
    }
}
