//package com.example.BackEndDevelopment.entity.hospital;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//
//import java.io.Serializable;
//
//@Embeddable
//public class HospitalDoctorId implements Serializable {
//
//    @Column(name = "hospital_id")
//    private Long hospitalId;
//
//    @Column(name = "doctor_id")
//    private Long doctorId;
//
//    // getters and setters
//
//
//    public HospitalDoctorId(Long hospitalId, Long doctorId) {
//        this.hospitalId = hospitalId;
//        this.doctorId = doctorId;
//    }
//
//    public HospitalDoctorId() {
//
//    }
//
//    public Long getHospitalId() {
//        return hospitalId;
//    }
//
//    public void setHospitalId(Long hospitalId) {
//        this.hospitalId = hospitalId;
//    }
//
//    public Long getDoctorId() {
//        return doctorId;
//    }
//
//    public void setDoctorId(Long doctorId) {
//        this.doctorId = doctorId;
//    }
//}
