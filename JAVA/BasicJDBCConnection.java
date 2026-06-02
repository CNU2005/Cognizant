// Exercise 31: Basic JDBC Connection

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBCConnection {

    static final String URL = "jdbc:sqlite:school.db";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY, name TEXT, marks INTEGER)");
            stmt.executeUpdate("DELETE FROM students");
            stmt.executeUpdate("INSERT INTO students VALUES (1, 'Alice', 85)");
            stmt.executeUpdate("INSERT INTO students VALUES (2, 'Bob', 72)");
            stmt.executeUpdate("INSERT INTO students VALUES (3, 'Charlie', 90)");

            try (ResultSet rs = stmt.executeQuery("SELECT id, name, marks FROM students")) {
                System.out.println("ID | Name    | Marks");
                System.out.println("---+---------+------");
                while (rs.next()) {
                    System.out.printf("%-2d | %-7s | %d%n",
                            rs.getInt("id"), rs.getString("name"), rs.getInt("marks"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
