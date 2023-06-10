package com.example.BackEndDevelopment.entity.patient;

import jakarta.persistence.*;

@Entity
@Table(name = "patient_phone_number")
public class PatientPhoneNumber {

    @Id
    private String phone_id;

    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    public PatientPhoneNumber(String phonenumber, Patient patient) {
        super();
        this.phonenumber = phonenumber;
        this.patient = patient;
    }

    public PatientPhoneNumber() {

    }

    public String getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(String phone_id) {
        this.phone_id = phone_id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}