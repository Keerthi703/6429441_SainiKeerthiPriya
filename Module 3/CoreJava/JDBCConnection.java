import java.sql.*;

public class JDBCConnection {
    public static void main(String[] args) throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:students.db")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
            }
        }
    }
}