package com.gla.JDBC;

import java.sql.*;

public class SalesManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS sales (" +
                    "id INT PRIMARY KEY, " +
                    "bookName VARCHAR(100), " +
                    "quantity INT, " +
                    "price DOUBLE)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW SALE
            String insert = "INSERT INTO sales (id, bookName, quantity, price) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "Java Basics");
            psInsert.setInt(3, 2);
            psInsert.setDouble(4, 450);
            psInsert.executeUpdate();

            psInsert.setInt(1, 2);
            psInsert.setString(2, "Python Guide");
            psInsert.setInt(3, 1);
            psInsert.setDouble(4, 500);
            psInsert.executeUpdate();

            psInsert.setInt(1, 3);
            psInsert.setString(2, "DBMS Notes");
            psInsert.setInt(3, 3);
            psInsert.setDouble(4, 300);
            psInsert.executeUpdate();

            System.out.println("Sales records inserted.");

            // 3. READ (quantity > 1)
            String select = "SELECT * FROM sales WHERE quantity > 1";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nSales with quantity > 1:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("bookName") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getDouble("price"));
            }

            // 4. UPDATE (Modify quantity)
            String update = "UPDATE sales SET quantity = ? WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 5); // new quantity
            psUpdate.setInt(2, 2); // sale id
            psUpdate.executeUpdate();
            System.out.println("\nQuantity updated.");

            // 5. DELETE (Incorrect entry removal)
            String delete = "DELETE FROM sales WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 2); // removing incorrect record
            psDelete.executeUpdate();
            System.out.println("Incorrect sale entry deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
