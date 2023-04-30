package com.example.BackEndDevelopment.entity.pharmacy;

import jakarta.persistence.*;

@Entity
@Table
public class Prescription_Accept {

    @EmbeddedId
    private PharmacyPrescription id;

    @OneToOne
    @JoinColumn(name = "pharmacy_id",insertable = false,updatable = false)
    private Pharmacy pharmacy;

    @OneToOne
    @JoinColumn(name = "prescription_id",insertable = false,updatable = false)
    private Prescription prescription;


}
