import java.sql.*;
import java.util.Random;

public class InsertBooks {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
        String user = "system";
        String password = "ORACLE";

        String insertSQL = "INSERT INTO BOOK (NAME, ISBN) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            Random random = new Random();
            for (int i = 1; i <= 100; i++) {
                String name = "Book " + i;
                String isbn = String.valueOf(1000000000 + random.nextInt(900000000));

                pstmt.setString(1, name);
                pstmt.setString(2, isbn);
                pstmt.executeUpdate();
            }

            System.out.println("100 kitap başarıyla eklendi.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
