package com.example.BackEndDevelopment.entity.hospital;
import com.example.BackEndDevelopment.entity.doctor.Doctor;
import jakarta.persistence.*;

@Entity
@Table
public class Doctor_Invitation {

    @EmbeddedId
    private HospitalDoctorId id;

    @ManyToOne
    @JoinColumn(name = "hospital_id", insertable = false, updatable = false)
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private Doctor doctor;
    private String description;

    public HospitalDoctorId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

