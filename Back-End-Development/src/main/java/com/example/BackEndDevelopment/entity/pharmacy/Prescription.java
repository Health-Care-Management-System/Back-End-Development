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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prescriptionid;

    @OneToOne
    @JoinColumn(name="doctor_id",referencedColumnName = "id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name="patient_id",referencedColumnName = "id")
    private Patient patient;

    private LocalDate date;
    private LocalTime time;

    private String description;

    public Prescription(Doctor doctor, Patient patient, LocalDate date, LocalTime time, String description) {
        super();
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public Prescription() {

    }

    public long getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(long prescriptionid) {
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
}
