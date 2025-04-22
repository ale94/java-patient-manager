package com.ar.ale94.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class Patient implements Serializable {

    private Long id;
    private String name;
    private String document;
    private String email;
    private LocalDate birthDate;
    private Set<Quote> quotes;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", document='").append(document).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append('}');
        return sb.toString();
    }
}
