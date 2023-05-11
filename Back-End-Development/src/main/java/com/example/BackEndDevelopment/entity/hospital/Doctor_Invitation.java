package com.example.BackEndDevelopment.entity.hospital;
import com.example.BackEndDevelopment.entity.doctor.Doctor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DoctorInvitation")

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
    private  String Status;

}

