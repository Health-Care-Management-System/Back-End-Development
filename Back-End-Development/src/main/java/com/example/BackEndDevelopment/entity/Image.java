package com.example.BackEndDevelopment.entity;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private String name;
    private String dateTime;
    private String city;
    @Lob
    private byte[] content;

    public Long getId() {
        return id;
    }

    public Image(Long id, String fileName, String name, String dateTime, String city, byte[] content) {
        this.id = id;
        this.fileName = fileName;
        this.name = name;
        this.dateTime = dateTime;
        this.city = city;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Image() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}


