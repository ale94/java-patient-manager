package com.ar.ale94.repositories;

import com.ar.ale94.config.DatabaseConnection;
import com.ar.ale94.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    public void createPatient(Patient patient) {
        String sql = "INSERT INTO patient (name, document, email, birth_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getDocument());
            pstmt.setString(3, patient.getEmail());
            pstmt.setString(4, patient.getBirthDate().toString());
            pstmt.executeUpdate();
            System.out.println("Paciente registrado exitosamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patient";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("document"),
                        rs.getString("email"),
                        LocalDate.now());
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
