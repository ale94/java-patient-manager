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

    public Patient getPatientById(Long id) {
        String sql = "SELECT * FROM patient WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Patient(rs.getLong("id"), rs.getString("name"), rs.getString("document"), rs.getString(
                        "email"), LocalDate.now());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updatePatient(Patient patient, Long id) {
        String sql = "UPDATE patient SET name = ?, email = ?, WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getName());
            pstmt.setString(2, patient.getEmail());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Paciente actualizado exitosamente.");
            } else {
                System.out.println("No se encontró el paciente con el id: " + patient.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
//    public void deleteProduct(int id) {
//        String sql = "DELETE FROM products WHERE id = ?";
//        try (Connection conn = DatabaseConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            int affectedRows = pstmt.executeUpdate();
//            if (affectedRows > 0) {
//                System.out.println("Producto borrado exitosamente.");
//            } else {
//                System.out.println("No se encontró el producto con el id: " + id);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
