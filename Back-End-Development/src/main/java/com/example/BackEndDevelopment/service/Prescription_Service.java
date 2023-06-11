package com.example.BackEndDevelopment.service;
import com.example.BackEndDevelopment.entity.pharmacy.Prescription;
import com.example.BackEndDevelopment.repository.Prescription_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Prescription_Service {

    @Autowired
    private Prescription_Repository prescription_repository;

    public int getPrescriptionCount(String pharmacy_id,String status){
        List<Prescription> prescriptions = this.prescription_repository.findAll();
        int count = 0;
        for(Prescription prescription : prescriptions){
            if(prescription.getResponse_state().equals(status) && prescription.getPharmacy().getPharmacyid().equals(pharmacy_id)){
                count+=1;
            }
        }
        return count;
    }

    public List<Prescription> getPrescriptions(String pharmacyid, String response_state) {
        List<Prescription> prescriptions = this.prescription_repository.findAll();
        List<Prescription> filteredPrescriptions = new ArrayList<>();

        for (Prescription prescription : prescriptions) {
            if (prescription.getPharmacy().getPharmacyid().equals(pharmacyid) && prescription.getResponse_state().equals(response_state)) {
                filteredPrescriptions.add(prescription);
            }
        }
        return filteredPrescriptions;
    }

    public void setPrescriptionResponseStatus(String pharmacyid, String prescription_ID, String response_state){
        List<Prescription> prescriptions = this.prescription_repository.findAll();
        for (Prescription prescription : prescriptions) {
            if (prescription.getPharmacy().getPharmacyid().equals(pharmacyid) && prescription.getPrescriptionid().equals(prescription_ID)) {
                prescription.setResponse_state(response_state);
                prescription_repository.save(prescription);
            }
        }
    }

}
