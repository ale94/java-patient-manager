package com.ar.ale94;

import com.ar.ale94.models.Patient;
import com.ar.ale94.services.PatientService;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        PatientService patientService = new PatientService();

        // CREAR PACIENTE
        Patient p1 = new Patient(null, "Marcos", "11111111", "lll@gmail.com", LocalDate.now());
        patientService.create(p1);


    }
}
