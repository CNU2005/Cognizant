// Exercise 32 (supporting file): Data Access Object for student records.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {

    private final String url;

    public StudentDAO(String url) {
        this.url = url;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    /** Creates the students table if it does not already exist. */
    public void createTable() throws SQLException {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +
                    "id INTEGER PRIMARY KEY, name TEXT, marks INTEGER)");
        }
    }

    /** Inserts a new student using a parameterized query. */
    public void insertStudent(int id, String name, int marks) throws SQLException {
        String sql = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);
            ps.executeUpdate();
            System.out.println("Inserted student " + id + " (" + name + ").");
        }
    }

    /** Updates an existing student's marks. */
    public void updateMarks(int id, int newMarks) throws SQLException {
        String sql = "UPDATE students SET marks = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newMarks);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s) for student " + id + ".");
        }
    }
}
