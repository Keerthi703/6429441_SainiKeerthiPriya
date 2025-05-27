import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    private final Connection conn;

    public StudentDAO() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:students.db");
        createTableIfNotExists();
    }

    // Create table if it doesn't exist
    private void createTableIfNotExists() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students (" +
                     "id INTEGER PRIMARY KEY, " +
                     "name TEXT)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.executeUpdate();
    }

    public void insertStudent(int id, String name) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (id, name) VALUES (1, Keerthi)");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.executeUpdate();
    }

    public void updateStudent(int id, String name) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE students SET name = anu WHERE id = 1");
        stmt.setString(1, name);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    // Main method to run
    public static void main(String[] args) {
        try {
            StudentDAO dao = new StudentDAO();

            // Insert student
            dao.insertStudent(1, "Alice");

            // Update student
            dao.updateStudent(1, "Alice Johnson");

            System.out.println("Student insert and update completed.");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
