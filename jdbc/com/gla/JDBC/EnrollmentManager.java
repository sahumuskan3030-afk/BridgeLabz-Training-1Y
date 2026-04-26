package com.gla.JDBC;

import java.sql.*;

public class EnrollmentManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS enrollments (" +
                    "id INT PRIMARY KEY, " +
                    "student VARCHAR(50), " +
                    "course VARCHAR(50))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW ENROLLMENT
            String insert = "INSERT INTO enrollments (id, student, course) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, "Amit");
            psInsert.setString(3, "Java");
            psInsert.executeUpdate();

            System.out.println("Enrollment added.");

            // 3. READ (Enrollments for a specific course)
            String courseSearch = "Java"; // change as needed
            String select = "SELECT * FROM enrollments WHERE course = ?";
            PreparedStatement psSelect = con.prepareStatement(select);
            psSelect.setString(1, courseSearch);

            ResultSet rs = psSelect.executeQuery();

            System.out.println("\nEnrollments for course: " + courseSearch);
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("student") + " | " +
                                rs.getString("course"));
            }

            // 4. UPDATE (Change student course)
            String update = "UPDATE enrollments SET course = ? WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setString(1, "Python");
            psUpdate.setInt(2, 1);
            psUpdate.executeUpdate();
            System.out.println("\nCourse updated.");

            // 5. DELETE (Cancel enrollment)
            String delete = "DELETE FROM enrollments WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 1);
            psDelete.executeUpdate();
            System.out.println("Enrollment removed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}