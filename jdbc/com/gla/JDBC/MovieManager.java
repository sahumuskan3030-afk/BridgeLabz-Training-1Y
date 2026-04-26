package com.gla.JDBC;

import java.sql.*;

public class MovieManager {

    static final String URL = "jdbc:mysql://localhost:3306/your_database";
    static final String USER = "root";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            // 1. CREATE TABLE
            String createTable = "CREATE TABLE IF NOT EXISTS movies (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "seats INT)";
            stmt.executeUpdate(createTable);
            System.out.println("Table created.");

            // 2. INSERT NEW MOVIES
            String insert = "INSERT INTO movies (id, name, seats) VALUES (?, ?, ?)";
            PreparedStatement psInsert = con.prepareStatement(insert);

            // Movie 1
            psInsert.setInt(1, 1);
            psInsert.setString(2, "Avengers");
            psInsert.setInt(3, 50);
            psInsert.executeUpdate();

            // Movie 2
            psInsert.setInt(1, 2);
            psInsert.setString(2, "Inception");
            psInsert.setInt(3, 0);
            psInsert.executeUpdate();

            // Movie 3
            psInsert.setInt(1, 3);
            psInsert.setString(2, "Interstellar");
            psInsert.setInt(3, 25);
            psInsert.executeUpdate();

            System.out.println("Movies added.");

            // 3. READ (seats > 0)
            String select = "SELECT * FROM movies WHERE seats > 0";
            ResultSet rs = stmt.executeQuery(select);

            System.out.println("\nMovies with available seats:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("seats"));
            }

            // 4. UPDATE (Book ticket → reduce seats)
            String update = "UPDATE movies SET seats = seats - 1 WHERE id = ?";
            PreparedStatement psUpdate = con.prepareStatement(update);
            psUpdate.setInt(1, 1); // booking ticket for movie id=1
            psUpdate.executeUpdate();
            System.out.println("\nSeat booked (1 seat reduced).");

            // 5. DELETE (Movie no longer running)
            String delete = "DELETE FROM movies WHERE id = ?";
            PreparedStatement psDelete = con.prepareStatement(delete);
            psDelete.setInt(1, 2); // deleting movie id=2
            psDelete.executeUpdate();
            System.out.println("Movie removed (no longer running).");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
