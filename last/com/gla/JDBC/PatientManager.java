package com.gla.JDBC;

import java.sql.*;

public class PatientManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS patients (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "disease VARCHAR(50))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW PATIENT
            String insert = "INSERT INTO patients (id, name, disease) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Aman");
            psInsert.setString(3, "Flu");
            psInsert.executeUpdate();
            System.out.println("Patient record inserted.");

            // 3. READ (Patients with specific disease)
            String diseaseSearch = "Flu"; // change as needed
            String select = "SELECT * FROM patients WHERE disease = ?";
            PreparedStatement psSelect = con.prepareStatement(select);
            psSelect.setString(1, diseaseSearch);

            ResultSet rs = psSelect.executeQuery();
            System.out.println("\nPatients with disease: " + diseaseSearch);
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("disease"));
            }

            // 4. UPDATE (Change disease)
            String update = "UPDATE patients SET disease = ? WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setString(1, "Cold");
            psUpdate.setInt(2, 1);
            psUpdate.executeUpdate();
            System.out.println("\nDisease updated.");

            // 5. DELETE (After discharge)
            String delete = "DELETE FROM patients WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();
            System.out.println("Patient record deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
