package com.gla.JDBC;

import java.sql.*;

public class LibraryManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS books (" +
                    "id INT PRIMARY KEY, " +
                    "title VARCHAR(100), " +
                    "author VARCHAR(50), " +
                    "status VARCHAR(10))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW BOOK
            String insert = "INSERT INTO books (id, title, author, status) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Java Programming");
            psInsert.setString(3, "James Gosling");
            psInsert.setString(4, "Available");
            psInsert.executeUpdate();
            System.out.println("Book inserted.");

            // 3. READ (Show Available Books)
            String select = "SELECT * FROM books WHERE status = 'Available'";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nAvailable Books:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getString("status"));
            }

            // 4. UPDATE (Mark as Issued)
            String update = "UPDATE books SET status = 'Issued' WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 1);
            psUpdate.executeUpdate();
            System.out.println("\nBook marked as Issued.");

            // 5. DELETE (Remove lost/damaged book)
            String delete = "DELETE FROM books WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();
            System.out.println("Book deleted (lost/damaged).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
