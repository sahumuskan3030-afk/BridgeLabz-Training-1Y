package com.gla.JDBC;

import java.sql.*;

public class GymMemberManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS members (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "type VARCHAR(20), " +
                    "months INT)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW MEMBER
            String insert = "INSERT INTO members (id, name, type, months) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "Rahul");
            psInsert.setString(3, "Premium");
            psInsert.setInt(4, 6);
            psInsert.executeUpdate();

            psInsert.setInt(1, 2);
            psInsert.setString(2, "Aman");
            psInsert.setString(3, "Basic");
            psInsert.setInt(4, 3);
            psInsert.executeUpdate();

            psInsert.setInt(1, 3);
            psInsert.setString(2, "Sneha");
            psInsert.setString(3, "Premium");
            psInsert.setInt(4, 12);
            psInsert.executeUpdate();

            System.out.println("Members added.");

            // 3. READ (Premium members)
            String select = "SELECT * FROM members WHERE type = 'Premium'";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nPremium Members:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("type") + " | " +
                                rs.getInt("months"));
            }

            // 4. UPDATE (Extend membership months)
            String update = "UPDATE members SET months = months + ? WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 3); // extend by 3 months
            psUpdate.setInt(2, 1); // member id
            psUpdate.executeUpdate();
            System.out.println("\nMembership extended.");

            // 5. DELETE (Expired / Cancelled membership)
            String delete = "DELETE FROM members WHERE months <= 0 OR id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 2); // cancelling member
            psDelete.executeUpdate();
            System.out.println("Expired/cancelled membership removed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
