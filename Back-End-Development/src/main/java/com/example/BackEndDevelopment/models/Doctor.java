package com.example.BackEndDevelopment.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

    public Doctor() {}

    public Doctor(String firstname, String lastname, String dob, String address, String contactnumber, String emailID, String slmcnumber) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.dob = dob;
        this.address = address;
        this.contactnumber = contactnumber;
        this.emailID = emailID;
        this.slmcnumber = slmcnumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
