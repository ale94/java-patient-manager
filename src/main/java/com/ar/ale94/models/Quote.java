package com.ar.ale94.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Quote implements Serializable {

    private Long id;
    private LocalDateTime time;
    private String specialty;
    private String doctor;
    private int pacienteId;

    public Quote() {
    }

    public Quote(Long id, LocalDateTime time, String specialty, String doctor) {
        this.id = id;
        this.time = time;
        this.specialty = specialty;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Quote{");
        sb.append("id=").append(id);
        sb.append(", time=").append(time);
        sb.append(", specialty='").append(specialty).append('\'');
        sb.append(", doctor='").append(doctor).append('\'');
        sb.append(", pacienteId=").append(pacienteId);
        sb.append('}');
        return sb.toString();
    }
}
