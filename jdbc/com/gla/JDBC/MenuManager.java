package com.gla.JDBC;

import java.sql.*;

public class MenuManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS menu (" +
                    "id INT PRIMARY KEY, " +
                    "itemName VARCHAR(50), " +
                    "price DOUBLE)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW MENU ITEM
            String insert = "INSERT INTO menu (id, itemName, price) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "Burger");
            psInsert.setDouble(3, 150);
            psInsert.executeUpdate();

            psInsert.setInt(1, 2);
            psInsert.setString(2, "Pizza");
            psInsert.setDouble(3, 300);
            psInsert.executeUpdate();

            psInsert.setInt(1, 3);
            psInsert.setString(2, "Tea");
            psInsert.setDouble(3, 30);
            psInsert.executeUpdate();

            System.out.println("Menu items added.");

            // 3. READ (Items priced below ₹200)
            String select = "SELECT * FROM menu WHERE price < 200";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nItems priced below ₹200:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("itemName") + " | " +
                                rs.getDouble("price"));
            }

            // 4. UPDATE (Change item price)
            String update = "UPDATE menu SET price = ? WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setDouble(1, 180); // new price
            psUpdate.setInt(2, 1);      // Burger
            psUpdate.executeUpdate();
            System.out.println("\nPrice updated.");

            // 5. DELETE (Remove discontinued item)
            String delete = "DELETE FROM menu WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 2); // removing Pizza
            psDelete.executeUpdate();
            System.out.println("Discontinued item removed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
