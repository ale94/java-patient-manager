package com.ar.ale94.services;

import com.ar.ale94.models.Patient;
import com.ar.ale94.repositories.PatientDAO;

public class PatientService {

    PatientDAO patientDAO = new PatientDAO();

    public void create(Patient patient) {
        this.patientDAO.createPatient(patient);
    }

    public void getAll() {
        for (Patient patient : patientDAO.getPatients()) {
            System.out.println(patient);
        }
    }
}
