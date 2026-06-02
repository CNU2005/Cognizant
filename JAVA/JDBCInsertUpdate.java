// Exercise 32: Insert and Update Operations in JDBC
import java.sql.SQLException;

public class JDBCInsertUpdate {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO("jdbc:sqlite:school.db");
        try {
            dao.createTable();
            dao.insertStudent(101, "Eve", 78);
            dao.insertStudent(102, "Frank", 64);
            dao.updateMarks(101, 88);
            System.out.println("Insert and update operations completed.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
