package com.example.BackEndDevelopment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
//    @Column(name = "empId", nullable = false)
    private Integer empId;
    //    @Column(name = "empName", nullable = false)
    private String empName;

    //    @Column(name = "empAddress", nullable = false)
    private String empAddress;
    //    @Column(name = "empNumber", nullable = false)
    private String empNumber;
    //    @Column(name = "empImage", nullable = false)
    private String empImage;

    private String email;
    //    @OneToMany(cascade=CascadeType.ALL)
//@JoinColumn(name = "fk_emp_id",referencedColumnName = " empId")
//private List<Appoinment> appoinment;
    public Employee() {
    }

//    public List<Appoinment> getAppoinment() {
//        return appoinment;
//    }
//
//    public void setAppoinment(List<Appoinment> appoinment) {
//        this.appoinment = appoinment;
//    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpImage() {
        return empImage;
    }

    public void setEmpImage(String empImage) {
        this.empImage = empImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
