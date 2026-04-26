package com.gla.JDBC;

import java.sql.*;

public class CustomerManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS customers (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "phone VARCHAR(15))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW CUSTOMER
            String insert = "INSERT INTO customers (id, name, phone) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Amit");
            psInsert.setString(3, "9876543210");
            psInsert.executeUpdate();
            System.out.println("Customer added.");

            // 3. READ (Search by name using LIKE)
            String searchName = "A%"; // change as needed
            String select = "SELECT * FROM customers WHERE name LIKE ?";
            PreparedStatement psSelect = con.prepareStatement(select);
            psSelect.setString(1, searchName);

            ResultSet rs = psSelect.executeQuery();
            System.out.println("\nSearch Results:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getString("phone"));
            }

            // 4. UPDATE (Change phone number)
            String update = "UPDATE customers SET phone = ? WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setString(1, "9999999999");
            psUpdate.setInt(2, 1);
            psUpdate.executeUpdate();
            System.out.println("\nPhone number updated.");

            // 5. DELETE (Remove customer)
            String delete = "DELETE FROM customers WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();
            System.out.println("Customer deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
