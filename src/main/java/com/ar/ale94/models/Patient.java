package com.ar.ale94.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Patient implements Serializable {

    private Long id;
    private String name;
    private String document;
    private String email;
    private LocalDate birthDate;

    public Patient() {
    }

    public Patient(Long id, String name, String document, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
