package com.example.BackEndDevelopment.entity.pharmacy;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PharmacyPrescription implements Serializable {

    @Column(name = "pharmacy_id")
    private String parmacyid;

    @Column(name = "prescription_id")
    private String prescriptionid;

    public PharmacyPrescription(String parmacyid, String prescriptionid) {
        this.parmacyid = parmacyid;
        this.prescriptionid = prescriptionid;
    }


    public PharmacyPrescription() {

    }

    public String getParmacyid() {
        return parmacyid;
    }

    public void setParmacyid(String parmacyid) {
        this.parmacyid = parmacyid;
    }

    public String getPrescriptionid() {
        return prescriptionid;
    }

    public void setPrescriptionid(String prescriptionid) {
        this.prescriptionid = prescriptionid;
    }
}