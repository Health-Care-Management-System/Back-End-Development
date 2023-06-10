package com.example.BackEndDevelopment.entity.hospital;
import com.example.BackEndDevelopment.entity.doctor.Doctor;
import jakarta.persistence.*;

@Entity
@Table(name = "DoctorInvitation")

public class Doctor_Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer invitationId;

    @OneToOne
    private Hospital hospital;

    @OneToOne
    private Doctor doctor;


    //id will provide spring itself and so no need to provide it into constructor
    public Doctor_Invitation(Hospital hospital, Doctor doctor) {
        this.hospital = hospital;
        this.doctor = doctor;
    }

    public Doctor_Invitation() {

    }

    public Integer getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Integer invitationId) {
        this.invitationId = invitationId;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

