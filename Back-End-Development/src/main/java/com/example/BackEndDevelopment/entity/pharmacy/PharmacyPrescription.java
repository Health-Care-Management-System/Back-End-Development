package com.example.BackEndDevelopment.entity.pharmacy;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PharmacyPrescription implements Serializable {

    @Column(name = "pharmacy_id")
    private long parmacyid;

    @Column(name = "prescription_id")
    private long prescriptionid;


    public PharmacyPrescription(long parmacyid, long prescriptionid) {
        this.parmacyid = parmacyid;
        this.prescriptionid = prescriptionid;
    }

    public PharmacyPrescription() {

    }

    public long getParmacyid() {
        return parmacyid;
    }

    public void setParmacyid(long parmacyid) {
        this.parmacyid = parmacyid;
    }

    public long getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(long prescriptionid) {
        this.prescriptionid = prescriptionid;
    }
}
