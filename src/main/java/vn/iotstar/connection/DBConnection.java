package vn.iotstar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "ltwct5st7"; // Tên database của bạn
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa"; // UserID của bạn
    private final String password = "123456"; // Password của bạn

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                    + ";encrypt=true;trustServerCertificate=true;databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            // Kết nối đến database 'ltwct5st7'
            Connection conn = new DBConnection().getConnection();
            // Tạo statement
            Statement stmt = conn.createStatement();
            // Thêm dữ liệu vào bảng 'abc' (giữ nguyên như thầy)
            stmt.executeUpdate("INSERT INTO abc (id, username, email) "
                    + "VALUES (1, 'Trung', 'trung@example.com')");
            // Lấy dữ liệu từ bảng 'abc'
            ResultSet rs = stmt.executeQuery("SELECT * FROM abc");
            // Hiển thị dữ liệu
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("username") 
                        + " " + rs.getString("email"));
            }

            // Thêm dữ liệu vào bảng login28_08 (dùng thông tin thầy)
            stmt.executeUpdate("INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate) "
                    + "VALUES ('trungnh@gmail.com', 'trungnh', 'Nguyen Huu Trung', '123456', NULL, 1, '0908617108', '2025-08-28')");
            stmt.executeUpdate("INSERT INTO login28_08 (email, username, fullname, password, avatar, roleid, phone, createdDate) "
                    + "VALUES ('trungnh@gmail.com', 'trungnh2', 'Nguyen Huu Trung Assistant', '654321', NULL, 2, '0908617109', '2025-08-28')");

            // Lấy dữ liệu từ bảng login28_08 để kiểm tra
            rs = stmt.executeQuery("SELECT * FROM login28_08");
            System.out.println("\nDữ liệu từ bảng login28_08:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("username") 
                        + " " + rs.getString("fullname") + " " + rs.getString("password")
                        + " " + rs.getInt("roleid") + " " + rs.getString("phone")
                        + " " + rs.getDate("createdDate"));
            }

            conn.close(); // Đóng kết nối
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}