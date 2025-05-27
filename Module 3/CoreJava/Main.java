import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student"; // Change this
        String user = "keerthi"; // Change this
        String password = "root"; // Change this

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Main transferService = new Main();
            transferService.transfer(conn, 1, 2, 100); // Transfer 100 from ID 1 to ID 2
            System.out.println("Transfer completed successfully.");
        } catch (SQLException e) {
            System.err.println("Transfer failed: " + e.getMessage());
        }
    }

    private void transfer(Connection conn, int i, int i0, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
