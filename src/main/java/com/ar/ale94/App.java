package com.ar.ale94;

import com.ar.ale94.models.Patient;
import com.ar.ale94.repositories.PatientDAO;
import com.ar.ale94.services.PatientService;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        PatientService patientService = new PatientService();
        PatientDAO patientDAO = new PatientDAO();

        // CREAR PACIENTE
        createPatient(patientService);


    }

    public static void createPatient(PatientService patientService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el nombre del paciente: ");
        var name = scanner.nextLine();

        System.out.print("Digite el numero de dni: ");
        var dni = scanner.nextLine();

        System.out.print("Digite el correo: ");
        var email = scanner.nextLine();

        patientService.create(new Patient(null, name, dni, email, LocalDate.now()));
    }

    public static Patient updatePatient(PatientDAO patientDAO, PatientService patientService) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite el id del paciente: ");
        var id = Long.parseLong(scanner.nextLine());

        System.out.print("Digite el nuevo nombre del paciente: ");
        var name = scanner.nextLine();

        System.out.print("Digite el nuevo correo: ");
        var email = scanner.nextLine();

        Patient patient = patientDAO.getPatientById(id);
        patient.setName(name);
        patient.setEmail(email);
        patientService.update(patient, id);
        return patient;
    }
}
