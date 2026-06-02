// Exercise 33: Transaction Handling in JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {

    static final String URL = "jdbc:sqlite:bank.db";

    static void setup(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS accounts (" +
                    "id INTEGER PRIMARY KEY, name TEXT, balance REAL)");
            stmt.executeUpdate("DELETE FROM accounts");
            stmt.executeUpdate("INSERT INTO accounts VALUES (1, 'Alice', 500.0)");
            stmt.executeUpdate("INSERT INTO accounts VALUES (2, 'Bob', 300.0)");
        }
    }

    static void transfer(Connection conn, int fromId, int toId, double amount) throws SQLException {
        String debit = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
        String credit = "UPDATE accounts SET balance = balance + ? WHERE id = ?";

        conn.setAutoCommit(false);
        try (PreparedStatement debitPs = conn.prepareStatement(debit);
             PreparedStatement creditPs = conn.prepareStatement(credit)) {

            debitPs.setDouble(1, amount);
            debitPs.setInt(2, fromId);
            debitPs.executeUpdate();

            creditPs.setDouble(1, amount);
            creditPs.setInt(2, toId);
            creditPs.executeUpdate();

            conn.commit();
            System.out.println("Transfer of " + amount + " succeeded. Committed.");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transfer failed, rolled back: " + e.getMessage());
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    static void printBalances(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, balance FROM accounts")) {
            while (rs.next()) {
                System.out.printf("%s: %.2f%n", rs.getString("name"), rs.getDouble("balance"));
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL)) {
            setup(conn);
            System.out.println("Before transfer:");
            printBalances(conn);

            transfer(conn, 1, 2, 200.0);

            System.out.println("After transfer:");
            printBalances(conn);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
