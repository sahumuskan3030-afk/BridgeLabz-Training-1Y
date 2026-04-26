package com.gla.JDBC;

import java.sql.*;

public class ProductInventory {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS product (" +
                    "pid INT PRIMARY KEY, " +
                    "pname VARCHAR(50), " +
                    "qty INT)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT 3 PRODUCTS
            String insert = "INSERT INTO product (pid, pname, qty) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            // Product 1
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Pen");
            psInsert.setInt(3, 50);
            psInsert.executeUpdate();

            // Product 2
            psInsert.setInt(1, 2);
            psInsert.setString(2, "Notebook");
            psInsert.setInt(3, 8);
            psInsert.executeUpdate();

            // Product 3
            psInsert.setInt(1, 3);
            psInsert.setString(2, "Marker");
            psInsert.setInt(3, 5);
            psInsert.executeUpdate();

            System.out.println("3 Products inserted.");

            // 3. READ (Low stock: qty < 10)
            String select = "SELECT * FROM product WHERE qty < 10";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nLow Stock Products (qty < 10):");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("pid") + " " +
                                rs.getString("pname") + " " +
                                rs.getInt("qty"));
            }

            // 4. UPDATE (Add stock)
            String update = "UPDATE product SET qty = qty + ? WHERE pid = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 20);  // adding 20 items
            psUpdate.setInt(2, 2);   // updating product with pid=2
            psUpdate.executeUpdate();
            System.out.println("\nStock updated.");

            // 5. DELETE (Discontinued product)
            String delete = "DELETE FROM product WHERE pid = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 3);  // deleting product with pid=3
            psDelete.executeUpdate();
            System.out.println("Discontinued product deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
