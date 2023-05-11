package com.example.BackEndDevelopment.entity.hospital;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class HospitalDoctorId implements Serializable {

    //If you change the class structure in a way that affects serialization,
    // such as adding or removing fields, you should update the serialVersionUID to a new unique identifier.
    // This ensures that the deserialization process will not fail due to incompatible class definitions.
    private static final long serialVersionUID = 1L;
    @Column(name = "hospital_id")
    private Long hospitalId;

    @Column(name = "doctor_id")
    private Long doctorId;


    public HospitalDoctorId(Long hospitalId, Long doctorId) {
        this.hospitalId = hospitalId;
        this.doctorId = doctorId;
    }

    public HospitalDoctorId() {

    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}
