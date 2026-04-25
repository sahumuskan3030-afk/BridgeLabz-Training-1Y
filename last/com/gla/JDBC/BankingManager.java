package com.gla.JDBC;

import java.sql.*;

public class BankingManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "accNo INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "balance DOUBLE)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW ACCOUNT
            String insert = "INSERT INTO accounts (accNo, name, balance) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);
            psInsert.setInt(1, 1001);
            psInsert.setString(2, "Ravi");
            psInsert.setDouble(3, 15000);
            psInsert.executeUpdate();
            System.out.println("Account created.");

            // 3. READ (balance > 10000)
            String select = "SELECT * FROM accounts WHERE balance > 10000";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nAccounts with balance > 10000:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("accNo") + " | " +
                                rs.getString("name") + " | " +
                                rs.getDouble("balance"));
            }

            // 4. UPDATE (Deposit / Withdraw)
            double amount = 2000; // change value (+deposit, -withdraw)
            String update = "UPDATE accounts SET balance = balance + ? WHERE accNo = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setDouble(1, amount);
            psUpdate.setInt(2, 1001);
            psUpdate.executeUpdate();
            System.out.println("\nBalance updated.");

            // 5. DELETE (Close account)
            String delete = "DELETE FROM accounts WHERE accNo = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 1001);
            psDelete.executeUpdate();
            System.out.println("Account closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
