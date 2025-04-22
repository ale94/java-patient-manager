package com.ar.ale94;

import com.ar.ale94.models.Patient;
import com.ar.ale94.services.PatientService;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        PatientService patientService = new PatientService();

        // CREAR PACIENTE
        //patientService.create(createPatient());

//        patientService.getAll();
        patientService.getById(5L);


    }

    public static Patient createPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el nombre del paciente: ");
        var name = scanner.nextLine();

        System.out.print("Digite el numero de dni: ");
        var dni = scanner.nextLine();

        System.out.print("Digite el correo: ");
        var email = scanner.nextLine();

        return new Patient(null, name, dni, email, LocalDate.now());
    }
}
