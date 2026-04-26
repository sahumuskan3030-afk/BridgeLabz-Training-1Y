package com.gla.JDBC;

import java.sql.*;

public class EmployeeCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS employee (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "salary DOUBLE)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT (Add Employee)
            String insert = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);
            psInsert.setInt(1, 101);
            psInsert.setString(2, "Rahul");
            psInsert.setDouble(3, 35000);
            psInsert.executeUpdate();
            System.out.println("Employee added.");

            // 3. READ (salary > 30000)
            String select = "SELECT * FROM employee WHERE salary > 30000";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nEmployees with salary > 30000:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getDouble("salary"));
            }

            // 4. UPDATE (Increase salary by 10%)
            String update = "UPDATE employee SET salary = salary + salary * 0.10 WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 101);
            psUpdate.executeUpdate();
            System.out.println("\nSalary increased by 10%.");

            // 5. DELETE (salary < 15000)
            String delete = "DELETE FROM employee WHERE salary < 15000";
            stmt.executeUpdate(delete);
            System.out.println("Employees with salary < 15000 deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}