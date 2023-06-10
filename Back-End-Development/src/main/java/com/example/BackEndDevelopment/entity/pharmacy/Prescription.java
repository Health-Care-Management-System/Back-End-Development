package com.example.BackEndDevelopment.entity.pharmacy;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.entity.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Prescription {

    @Id
    private String prescriptionid;

    @OneToOne
    @JoinColumn(name="doctor_id",referencedColumnName = "id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name="patient_id",referencedColumnName = "id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="pharmacy_id",referencedColumnName = "pharmacyid")
    private Pharmacy pharmacy;

    private LocalDate date;
    private LocalTime time;

    private String description;

    private String response_state;

    public Prescription(String prescriptionid, Doctor doctor, Patient patient, Pharmacy pharmacy, LocalDate date, LocalTime time, String description, String response_state) {
        this.prescriptionid = prescriptionid;
        this.doctor = doctor;
        this.patient = patient;
        this.pharmacy= pharmacy;
        this.date = date;
        this.time = time;
        this.description = description;
        this.response_state = response_state;
    }


    public Prescription() {

    }

    public String getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(String prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse_state() {
        return response_state;
    }

    public void setResponse_state(String response_state) {
        this.response_state = response_state;
    }
}
