package com.gla.JDBC;

import java.sql.*;

public class TodoManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS tasks (" +
                    "id INT PRIMARY KEY, " +
                    "title VARCHAR(100), " +
                    "status VARCHAR(20))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW TASK
            String insert = "INSERT INTO tasks (id, title, status) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "Complete Java assignment");
            psInsert.setString(3, "Pending");
            psInsert.executeUpdate();

            psInsert.setInt(1, 2);
            psInsert.setString(2, "Go to gym");
            psInsert.setString(3, "Pending");
            psInsert.executeUpdate();

            psInsert.setInt(1, 3);
            psInsert.setString(2, "Read DBMS notes");
            psInsert.setString(3, "Completed");
            psInsert.executeUpdate();

            System.out.println("Tasks added.");

            // 3. READ (Pending tasks)
            String select = "SELECT * FROM tasks WHERE status = 'Pending'";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nPending Tasks:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("status"));
            }

            // 4. UPDATE (Mark task as Completed)
            String update = "UPDATE tasks SET status = 'Completed' WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 1); // task id
            psUpdate.executeUpdate();
            System.out.println("\nTask marked as Completed.");

            // 5. DELETE (Remove completed tasks)
            String delete = "DELETE FROM tasks WHERE status = 'Completed'";
            stmt.executeUpdate(delete);
            System.out.println("Completed tasks removed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
