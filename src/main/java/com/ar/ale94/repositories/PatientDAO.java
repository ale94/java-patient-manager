package com.ar.ale94.repositories;

import com.ar.ale94.config.DatabaseConnection;
import com.ar.ale94.models.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
