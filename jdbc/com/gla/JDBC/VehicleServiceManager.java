package com.gla.JDBC;

import java.sql.*;

public class VehicleServiceManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS vehicles (" +
                    "regNo VARCHAR(20) PRIMARY KEY, " +
                    "owner VARCHAR(50), " +
                    "status VARCHAR(20))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW VEHICLE
            String insert = "INSERT INTO vehicles (regNo, owner, status) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            psInsert.setString(1, "UP32AB1234");
            psInsert.setString(2, "Ravi Sharma");
            psInsert.setString(3, "Pending");
            psInsert.executeUpdate();

            System.out.println("Vehicle added for service.");

            // 3. READ (status = Pending)
            String select = "SELECT * FROM vehicles WHERE status = 'Pending'";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nPending Vehicles:");
            while (rs.next()) {
                System.out.println(
                        rs.getString("regNo") + " | " +
                                rs.getString("owner") + " | " +
                                rs.getString("status"));
            }

            // 4. UPDATE (mark as Completed)
            String update = "UPDATE vehicles SET status = 'Completed' WHERE regNo = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setString(1, "UP32AB1234");
            psUpdate.executeUpdate();
            System.out.println("\nService marked as Completed.");

            // 5. DELETE (after delivery)
            String delete = "DELETE FROM vehicles WHERE regNo = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setString(1, "UP32AB1234");
            psDelete.executeUpdate();
            System.out.println("Vehicle record removed after delivery.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
