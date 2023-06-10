package com.example.BackEndDevelopment.entity.doctor;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

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

    @Column(name = "Contact_Number")
    private String contactnumber;

    @Column(name = "Email")
    private String emailID;

    @Column(name = "SLMC_Number")
    private String slmcnumber;

    @Column(name = "Experience")
    private String experience;

    @Column(name = "Image", columnDefinition = "longblob")
    private byte[] image;

    @Column(name = "ImageAPI")
    private String imageapi;



    public Doctor(String id, String firstname, String lastname, String dob, String address, String contactnumber, String emailID, String slmcnumber, String experience, byte[] image, String imageapi) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.contactnumber = contactnumber;
        this.emailID = emailID;
        this.slmcnumber = slmcnumber;
        this.experience = experience;
        this.image = image;
        this.imageapi = imageapi;
    }


    public Doctor() {

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

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getSlmcnumber() {
        return slmcnumber;
    }

    public void setSlmcnumber(String slmcnumber) {
        this.slmcnumber = slmcnumber;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
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
