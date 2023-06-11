package com.example.BackEndDevelopment.entity;

import com.example.BackEndDevelopment.entity.doctor.Doctor;
import com.example.BackEndDevelopment.entity.patient.Patient;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long booking_id;

    @ManyToOne
    @JoinColumn(name="patient_id",referencedColumnName = "id")
    private Patient patient_id;

    @ManyToOne
    @JoinColumn(name="doctor_id",referencedColumnName = "doc_id")
    private Doctor doctor;
    private LocalDate data;
    private LocalTime time;

    public Appointments(Patient patient_id, Doctor doctor, LocalDate data, LocalTime time) {
        super();
        this.patient_id = patient_id;
        this.doctor = doctor;
        this.data = data;
        this.time = time;
    }

    public Appointments() {

    }

    public long getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(long booking_id) {
        this.booking_id = booking_id;
    }

    public Patient getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Patient patient_id) {
        this.patient_id = patient_id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
